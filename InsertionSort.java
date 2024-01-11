public class InsertionSort {
      // Insertion sort algorithm for O(n^2) sorting
      public static void insertionSort(DataItem[] array) {
        for (int i = 1; i < array.length; i++) {
            DataItem current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

}
