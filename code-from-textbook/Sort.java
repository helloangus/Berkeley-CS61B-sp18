/**
 * Sorts strings destructively.
 */


public class Sort {



    /**
     * Returns the smallest string in x.
     * @param x
     * @return
     * @source Got help with string compares from https://goo.gl/a7yBU5.
     */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


    /**
     * Swap the element with index a and b in a String array.
     * @param x
     * @param a
     * @param b
     */
    public static void swap(String[] x, int a, int b)
    {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }


    /** Sorts strings destructively starting from item start. */
    private static void sort(String[] x, int start) { 
        if(start == x.length)
        {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    public static void sort(String[] x)
    {
        sort(x, 0);
    }

}
