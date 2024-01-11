public class LinearSearch {
    public static boolean linearSearch(DataItem[] arr, DataItem target) {
        for (DataItem dataItem : arr) {
            if (dataItem.compareTo(target) == 0) {
                return true;
            }
        }
        return false;
    }
}
