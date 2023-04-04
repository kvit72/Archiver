package Archiver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите полный путь файла архива:");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(bis.readLine()));

        System.out.println("Введите полное имя файла для архивации:");
        zipFileManager.createZip(Paths.get(bis.readLine()));
    }
}
