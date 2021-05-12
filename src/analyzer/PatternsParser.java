package analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatternsParser {

    public static FilePattern[] parseFile(File file) {
        List<FilePattern> patterns = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(";");
                line[1] = line[1].replace("\"", "");
                line[2] = line[2].replace("\"", "");
                patterns.add(new FilePattern(Integer.parseInt(line[0]), line[1], line[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return patterns.toArray(FilePattern[]::new);
    }
}
