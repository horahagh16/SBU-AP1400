package util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {
    public static String getFileContents(String filePath) throws Exception {
        StringBuilder contents = new StringBuilder();
        InputStream inputstream = new FileInputStream(filePath);
        int data = inputstream.read();
        while (data != -1) {
            contents.append((char) data);
            data = inputstream.read();
        }
        inputstream.close();
        return contents.toString();
    }

    public static List<String> getDirectoryFilesList(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        List<String> paths = new ArrayList<>();
        return RecursiveCheck(files, 0, paths);
    }

    static List<String> RecursiveCheck(File[] arr, int index, List<String> paths) {

        if (index == arr.length)
            return paths;

        if (arr[index].isFile())
            paths.add(arr[index].getAbsolutePath());

        else if (arr[index].isDirectory()) {
            RecursiveCheck(Objects.requireNonNull(arr[index].listFiles()), 0, paths);
        }
        RecursiveCheck(arr, ++index, paths);
        return paths;
    }
}
