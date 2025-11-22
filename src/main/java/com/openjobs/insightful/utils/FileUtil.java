package com.openjobs.insightful.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public final class FileUtil {

    private FileUtil() {
    }

    public static String readFileToString(String classpathOrPath) throws IOException {
        File file = ResourceUtils.getFile(classpathOrPath);
        return Files.readString(file.toPath());
    }

    public static byte[] readFileToBytes(String classpathOrPath) throws IOException {
        File file = ResourceUtils.getFile(classpathOrPath);
        return Files.readAllBytes(file.toPath());
    }

    public static void writeStringToFile(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void writeBytesToFile(String path, byte[] bytes) throws IOException {
        Files.write(Paths.get(path), bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null) return "";
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? "" : fileName.substring(dotIndex + 1);
    }

    public static String getFileNameWithoutExtension(String fileName) {
        if (fileName == null) return "";
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
    }

    public static boolean deleteIfExists(String path) {
        try {
            return Files.deleteIfExists(Paths.get(path));
        } catch (Exception e) {
            return false;
        }
    }

    public static void createDirectories(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }
}