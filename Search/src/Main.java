/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

abstract class SearchAlgorithm {
    abstract int search(int[] arr, int target);
}

class LinearSearch extends SearchAlgorithm {
    @Override
    int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class BinarySearch extends SearchAlgorithm {
    @Override
    int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  1: Input
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array (in sorted order):");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        SearchAlgorithm linearSearch = new LinearSearch();
        SearchAlgorithm binarySearch = new BinarySearch();

        // Section 3: User Interaction
        System.out.println("Search options:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice: ");
       choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Search(linearSearch, array, scanner);
                    break;
                case 2:
                    Search(binarySearch, array, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void performSearch(SearchAlgorithm searchAlgorithm, int[] array, Scanner scanner) {
        System.out.print("Enter the target number to search for: ");
        int target = scanner.nextInt();
        int index = searchAlgorithm.search(array, target);
        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }

