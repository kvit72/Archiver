package Archiver;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        // Добовляем только файлы
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }

        // Добовляем содержимое директории
        if (Files.isDirectory(path)) {
            // Проходимся по всему содержимому директории
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }
}
