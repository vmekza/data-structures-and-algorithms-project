public class DataItem implements Comparable<DataItem> {
    private final int value;
    private static long comparisons = 0;

    public DataItem(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(DataItem other) {
        comparisons++;
        return Integer.compare(this.value, other.value);
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
