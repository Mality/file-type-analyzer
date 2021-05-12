package analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileAnalyzer {

    private FilePattern[] patterns;

    public FileAnalyzer(FilePattern[] patterns) {
        this.patterns = patterns;
    }

    public String getFileContent(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.getPath())));
    }

    public String getFileType(File file) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Pair<Future<Boolean>, String>> executions = new ArrayList<>();
        try {
            String fileContent = getFileContent(file);
            for (var pattern : patterns) {
                try {
                    executions.add(new Pair<>(executorService.submit(
                            new ParallelSearch(fileContent, pattern.getPattern())), pattern.getResultType()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (var execution : executions) {
            try {
                if (execution.first.get()) {
                    executorService.shutdown();
                    return execution.second;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return "Unknown file type";
    }
}
