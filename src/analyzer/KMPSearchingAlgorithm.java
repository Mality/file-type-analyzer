package analyzer;

public class KMPSearchingAlgorithm implements SearchingAlgorithm {

    private static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];
        int p = 0;
        for (int i = 1; i < str.length(); i++) {
            while (p > 0 && str.charAt(p) != str.charAt(i)) {
                p = prefixFunc[p - 1];
            }
            if (str.charAt(p) == str.charAt(i)) {
                ++p;
            }
            prefixFunc[i] = p;
        }
        return prefixFunc;
    }

    private static boolean KMPSearch(String text, String pattern) {
        int[] prefixFunc = prefixFunction(pattern);
        int p = 0;
        for (int i = 0; i < text.length(); i++) {
            while (p > 0 && text.charAt(i) != pattern.charAt(p)) {
                p = prefixFunc[p - 1];
            }
            if (text.charAt(i) == pattern.charAt(p)) {
                ++p;
            }
            if (p == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Search(String text, String pattern) {
        return KMPSearch(text, pattern);
    }
}
