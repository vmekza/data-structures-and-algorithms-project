import java.util.Random;

public class QuickSort {
    //Performs the quicksort algorithm on an array of DataItem objects.
        public static void quickSort(DataItem[] arr, int begin, int end) {
            if (begin < end) {
                int partitionIndex = randomizedPartition(arr, begin, end);
                quickSort(arr, begin, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, end);
            }
        }

    //Partitions the array segment using a randomly selected pivot.
        private static int randomizedPartition(DataItem[] arr, int begin, int end) {
            int pivotIndex = randomPivot(begin, end);
            swap(arr, pivotIndex, end);
            return partition(arr, begin, end);
        }

    //Partitions the array segment around a pivot element.
        private static int partition(DataItem[] arr, int begin, int end) {
            DataItem pivot = arr[end];
            int i = begin - 1;

            for (int j = begin; j < end; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, end);
            return i + 1;
        }

        //Generates a random pivot index within the specified range.
        private static int randomPivot(int begin, int end) {
            Random rand = new Random();
            return rand.nextInt((end - begin) + 1) + begin;
        }

        private static void swap(DataItem[] arr, int i, int j) {
            DataItem temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

}
