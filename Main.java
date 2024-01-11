import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Displays a menu for the user to select a search or sort operation.
    public static void displayMenu() {
        System.out.println("\nMenu of Searching and Sorting Testbed.");
        System.out.println("1) Linear searching");
        System.out.println("2) Binary searching");
        System.out.println("3) n^2 type of sorting");
        System.out.println("4) n * log(n) type of sorting");
        System.out.println("5) Sorting performance");
        System.out.println();
        System.out.println("q/Q) Quit");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataItem[] values = new DataItem[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = new DataItem(i);
        }
        String choice;

        do {
            displayMenu(); // Display the menu
            System.out.print("Your choice: ");
            choice = scanner.next();

            switch (choice) {
                case "1": // Linear searching
                    // Prompt for user input and perform linear search
                    System.out.print("In the list are values  " + values[0] + ", ..., " + values[values.length - 1] + " which value you would like to search with linear search? ");
                    DataItem targetLinear = new DataItem(scanner.nextInt());
                    boolean foundLinear = LinearSearch.linearSearch(values, targetLinear);
                    if (foundLinear) {
                        System.out.println("Found");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case "2": // Binary searching
                    // Prompt for user input and perform binary search
                    System.out.print("In the list are values  " + values[0] + ", ..., " + values[values.length - 1] + " which value you would like to search with binary search? ");
                    DataItem targetBinary = new DataItem(scanner.nextInt());
                    boolean foundBinary = BinarySearch.binarySearch(values, targetBinary);
                    if (foundBinary) {
                        System.out.println("Found");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case "3": // O(n^2) type of sorting
                    // Generate and sort a random set of DataItems using Insertion Sort
                    Random rand = new Random();
                    DataItem[] randomDataItems = new DataItem[10];
                    for (int i = 0; i < randomDataItems.length; i++) {
                        randomDataItems[i] = new DataItem(rand.nextInt(201) - 100);
                    }
                    System.out.println("Data set before insertion sorting: " + Arrays.toString(randomDataItems));
                    InsertionSort.insertionSort(randomDataItems);
                    System.out.println("Data set after insertion sorting: " + Arrays.toString(randomDataItems));
                    break;
                    case "4": // O(n*log(n)) type of sorting
                        // Generate and sort a random set of DataItems using QuickSort
                        Random random = new Random();
                        DataItem[] randomDataItemsQuickSort = new DataItem[10];
                        for (int i = 0; i < randomDataItemsQuickSort.length; i++) {
                            randomDataItemsQuickSort[i] = new DataItem(random.nextInt(201) - 100);
                        }

                    System.out.println("Data set before quicksort: " + Arrays.toString(randomDataItemsQuickSort));
                    QuickSort.quickSort(randomDataItemsQuickSort, 0, randomDataItemsQuickSort.length - 1);
                    System.out.println("Data set after quicksort: " + Arrays.toString(randomDataItemsQuickSort));
                    break;
                    case "5": // Sorting performance
                    int n = 5000;
                    System.out.printf("%-25s %-10s %-20s %-20s%n", "Algorithm", "Size", "Time (ms)", "Comparisons");
                    Random randomNum = new Random(0);
                    for (int i = 1; i <= 10; i++) {
                        int size = i * n;
                        DataItem[] originalDataSet = new DataItem[size];

                        for (int j = 0; j < originalDataSet.length; j++) {
                            originalDataSet[j] = new DataItem(randomNum.nextInt());
                        }
                        // Measure performance for each sorting algorithm
                        measureAndPrintPerformance("InsertionSort", Arrays.copyOf(originalDataSet, originalDataSet.length));
                        measureAndPrintPerformance("QuickSort", Arrays.copyOf(originalDataSet, originalDataSet.length));
                        measureAndPrintPerformance("BubbleSort", Arrays.copyOf(originalDataSet, originalDataSet.length));
                        measureAndPrintPerformance("MergeSort", Arrays.copyOf(originalDataSet, originalDataSet.length));
                    }
                    break;
                    case "Q":
                    System.out.println("Exiting program.");
                    break;
                    default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (!choice.equalsIgnoreCase("q"));
        scanner.close();
    }

    //Measures and prints the performance of different sorting algorithms.
    private static void measureAndPrintPerformance(String algorithm, DataItem[] originalDataSet) {
        DataItem[] dataSet = Arrays.copyOf(originalDataSet, originalDataSet.length);
        DataItem.resetComparisons();
        long startTime = System.nanoTime();

        // Call the appropriate sorting algorithm
        switch (algorithm) {
            case "InsertionSort":
            InsertionSort.insertionSort(dataSet);
                break;
            case "QuickSort":
                QuickSort.quickSort(dataSet, 0, dataSet.length - 1);
                break;
            case "BubbleSort":
                BubbleSort.bubbleSort(dataSet);
                break;
            case "MergeSort":
            MergeSort.mergeSort(dataSet, 0, dataSet.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long comparisons = DataItem.getComparisons();

        // Convert nanoseconds to milliseconds and round off to the nearest millisecond
        long timeInMilliseconds = (timeElapsed + 500_000) / 1_000_000;

        System.out.printf("%-20s %10d %15d %20d%n",
            algorithm,
            dataSet.length,
            timeInMilliseconds,
            comparisons
        );
    }
}


