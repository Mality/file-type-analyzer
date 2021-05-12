package analyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        String directoryPath = args[0];
        String patternsPath = args[1];

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            return;
        }

        FilePattern[] filePatterns = PatternsParser.parseFile(new File(patternsPath));
        MergeSort.sort(filePatterns, 0, filePatterns.length);
    
        FileAnalyzer fileAnalyzer = new FileAnalyzer(filePatterns);

        File[] innerFiles = directory.listFiles();

        for (File file : innerFiles) {
            try {
                String fileType = fileAnalyzer.getFileType(file);
                if ("Unknown file type".equals(fileType)) {
                    System.out.printf("%s: Unknown file type\n", file.getName());
                } else {
                    System.out.printf("%s: %s\n", file.getName(), fileType);
                }
            } catch (Exception e) {
                System.out.printf("File not found: %s\n", file.getName());
            }
        }
    }

}
