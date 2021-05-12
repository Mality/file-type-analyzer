package analyzer;

import java.util.concurrent.Callable;

public class ParallelSearch implements Callable {

    String text;
    String pattern;

    public ParallelSearch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    @Override
    public Object call() throws Exception {
        StringSearch stringSearch = new StringSearch(new KMPSearchingAlgorithm());
        return stringSearch.hasSubstring(text, pattern);
    }
}
