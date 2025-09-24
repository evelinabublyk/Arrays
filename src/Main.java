import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean auto = true;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1) Count occurrences of a number in an array");
            System.out.println("2) Reverse an array");
            System.out.println("3) Sort an array by digit sum");
            System.out.println("4) Analyze an array of floating-point numbers");
            System.out.println("8) Settings");
            System.out.println("0) Exit");

            int menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    taskCountOccurrences();
                    break;
                case 2:
                    taskReverseArray();
                    break;
                case 3:
                    taskSortByDigitSum();
                    break;
                case 4:
                    taskAnalyzeFloats();
                    break;
                case 8:
                    settings();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }

    static void taskCountOccurrences() {
        int[] arr = auto ? randomArray() : readArray();
        System.out.print("Which number are you looking for? ");
        int target = sc.nextInt();
        int result = countOccurrences(arr, target);
        System.out.println("Occurrences of " + target + " = " + result);
    }

    static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int x : arr) if (x == target) count++;
        return count;
    }

    static int[] randomArray() {
        System.out.print("n = ");
        int n = sc.nextInt();
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10);
        }
        System.out.println("Array: " + Arrays.toString(a));
        return a;
    }

    static int[] readArray() {
        System.out.print("n = ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(a));
        return a;
    }

    static void settings() {
        System.out.println("\nSettings:");
        System.out.println("1) Auto-generate arrays");
        System.out.println("2) Manual input");
        System.out.print("Choose: ");
        int s = sc.nextInt();
        if (s == 1) {
            auto = true;
            System.out.println("Auto-generation enabled");
        } else if (s == 2) {
            auto = false;
            System.out.println("Manual input enabled");
        } else {
            System.out.println("Invalid choice");
        }
    }

    static void taskReverseArray() {
        int[] a;
        if (auto) {
            a = randomArray();
        } else {
            a = readArray();
        }
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j--;
        }
        a = b;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void taskSortByDigitSum() {
        int[] a;
        if (auto) {
            a = randomArray();
        } else {
            a = readArray();
        }
        int n = a.length;
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int s = 0;
            while (x > 0) {
                s += x % 10;
                x /= 10;
            }
            sums[i] = s;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sums[i] > sums[j]) {
                    int tmp = sums[i];
                    sums[i] = sums[j];
                    sums[j] = tmp;
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        System.out.println("Sorted array = " + Arrays.toString(a));
        System.out.println("Digit sums  = " + Arrays.toString(sums));
    }

    static void taskAnalyzeFloats() {
        double[] a;
        if (auto) {
            System.out.print("n = ");
            int n = sc.nextInt();
            a = new double[n];
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                a[i] = -10 + 20 * r.nextDouble();
            }
            System.out.println("Array: " + Arrays.toString(a));
        } else {
            System.out.print("n = ");
            int n = sc.nextInt();
            a = new double[n];
            System.out.println("Enter " + n + " doubles:");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextDouble();
            }
            System.out.println("Array: " + Arrays.toString(a));
        }

        double sumNegatives = 0.0;
        for (double x : a) {
            if (x < 0) sumNegatives += x;
        }
        System.out.println("Sum of negative elements = " + sumNegatives);

        double productEvenIndices = 1.0;
        for (int i = 0; i < a.length; i += 2) {
            productEvenIndices *= a[i];
        }
        System.out.println("Product of elements with even indices = " + productEvenIndices);

        int count = 0;
        for (double x : a) if (x > 0) count++;
        double[] positives = new double[count];
        int idx = 0;
        for (double x : a) {
            if (x > 0) positives[idx++] = x;
        }
        System.out.println("Array of positives = " + Arrays.toString(positives));
    }
}
