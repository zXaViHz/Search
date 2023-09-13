

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class Menu {

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter number:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Algorithm linearSearch = new LinearSearch();
        Algorithm binarySearch = new BinarySearch();

        System.out.println("Search options:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }

        System.out.print("Enter the target number to search for: ");
        int target = scanner.nextInt();

        int index;
        if (choice == 1) {
            index = linearSearch.search(array, target);
        } else {
            index = binarySearch.search(array, target);
        }

        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }
}