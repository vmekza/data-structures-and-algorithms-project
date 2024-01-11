public class BinarySearch {
    public static boolean binarySearch(DataItem[] arr, DataItem target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int comparison = arr[mid].compareTo(target);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

}
