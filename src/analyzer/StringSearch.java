package analyzer;

public class StringSearch {

    SearchingAlgorithm algorithm;

    public StringSearch(SearchingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean hasSubstring(String text, String pattern) {
        return algorithm.Search(text, pattern);
    }

}
