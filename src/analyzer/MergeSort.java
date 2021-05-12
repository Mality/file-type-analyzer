package analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort<T> {

    private static <E extends Comparable<E>> void merge(E[] array, int l, int m, int r) {
        int cl = l, cr = m;
        List<E> tmp = new ArrayList<>();

        while (cl < m && cr < r) {
            if (array[cl].compareTo(array[cr]) >= 0) {
                tmp.add(array[cl++]);
            } else {
                tmp.add(array[cr++]);
            }
        }

        for (; cl < m; cl++) {
            tmp.add(array[cl]);
        }

        for (; cr < r; cr++) {
            tmp.add(array[cr]);
        }

        for (int i = l; i < r; i++) {
            array[i] = tmp.get(i - l);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] array, int l, int r) {
        if (l + 1 >= r) {
            return;
        }

        int m = (r + l) / 2;
        sort(array, l, m);
        sort(array, m, r);

        merge(array, l, m, r);
    }

}
