package analyzer;

public class FilePattern implements Comparable<FilePattern> {

    private int priority;
    private String pattern;
    private String resultType;

    public FilePattern(int priority, String pattern, String resultType) {
        this.priority = priority;
        this.pattern = pattern;
        this.resultType = resultType;
    }

    public int getPriority() {
        return priority;
    }

    public String getPattern() {
        return pattern;
    }

    public String getResultType() {
        return resultType;
    }

    @Override
    public int compareTo(FilePattern filePattern) {
        return Integer.compare(priority, filePattern.getPriority());
    }
}
