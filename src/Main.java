import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean auto = true;

    public static void main(String[] args) {
        while(true){
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
            // Масив або генерується, або вводиться вручну

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

        //Автоматична генерація масиву
        static int[] randomArray() {
            System.out.print("n = ");
            int n = sc.nextInt();

            int[] a = new int[n];
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                a[i] = r.nextInt(10); // числа 0..9
            }

            System.out.println("Array: " + Arrays.toString(a));
            return a;
        }

        //Ручний ввід масиву
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

        //Налаштування
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
        static void taskReverseArray(){
        //Поміняти місцями елементи від початку жо кінця
           int[] a;

           if(auto){
               a = randomArray();
           }
           else(!auto){
               a = readArray();
            }

           for(int i = 0; i < a.length / 2; i++){

           }

        }
        static void taskSortByDigitSum(){

        }
        static void taskAnalyzeFloats(){

        }
        static void Settings(){
        }
    }



