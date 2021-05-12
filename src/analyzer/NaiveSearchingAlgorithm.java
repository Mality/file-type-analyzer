package analyzer;

public class NaiveSearchingAlgorithm implements SearchingAlgorithm {
    @Override
    public boolean Search(String text, String pattern) {
        return text.contains(pattern);
    }
}
