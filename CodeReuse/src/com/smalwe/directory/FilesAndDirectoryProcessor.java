package com.smalwe.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesAndDirectoryProcessor {

    private static final String ROOT_FOLDER = "/Users/smalwe/Downloads/Learners";
    private static final String DOCX = "docx";
    private static final String PDF = "pdf";


    public static void main(String[] args) {

        List<String> supportedDocTypes = new ArrayList<>();
        supportedDocTypes.add(DOCX);

        System.out.println("Print result for getFiles");
        getFiles(ROOT_FOLDER).stream().forEach(System.out::println);

        System.out.println("Print result for getAllFiles");
        getAllFiles(ROOT_FOLDER).stream().forEach(System.out::println);

        System.out.println("Print result for getAllFilesUsingStreams");
        getAllFilesUsingStreams(ROOT_FOLDER, supportedDocTypes).stream().forEach(System.out::println);

    }

    /**
     * Method to list files in a given folder
     * Note: This method does not run recursively, thus prints only one level of files/folder names
     */
    public static List<String> getFiles(String path) {
        File dir = new File(path);
        String pathnames[] = dir.list();
        return Arrays.asList(pathnames);
    }

    /**
     * Method to list of files recursively in a given folder
     */
    public static List<String> getAllFiles(String rootPath) {
        List<String> allFilesPath = new ArrayList<>();
        File dir = new File(rootPath);

        Queue<File> folderQueue = new LinkedList();
        folderQueue.add(dir);

        while(!folderQueue.isEmpty()) {
            File currFolder = folderQueue.poll();
            for(File file : currFolder.listFiles()) {
               if(file.isDirectory()) {
                   folderQueue.add(file);
               } else {
                   allFilesPath.add(file.getAbsolutePath());
               }
            }
        }

        return allFilesPath;
    }

    /**
     * Method to list of files recursively in a given folder using Streams
     */
    public static List<String> getAllFilesUsingStreams(String rootPath, List<String> supportedDocTypes) {

        List<String> allFilesPath = new ArrayList<>();

        try (Stream<Path> pathStream = Files.walk(Paths.get(rootPath))) {
            allFilesPath = pathStream
                    .filter(Files::isRegularFile)
                    .map(path -> path.toString())
                    .flatMap(sPath -> supportedDocTypes.stream()
                            .filter(docType -> sPath.endsWith(docType))
                            .map(docType -> sPath))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            System.out.println("Error while parsing the folder structure");
        }

        return allFilesPath;
    }
}
