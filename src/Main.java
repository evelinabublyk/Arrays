import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1) Count occurrences of a number in an array");
            System.out.println("2) Reverse an array");
            System.out.println("3) Sort an array by digit sum");
            System.out.println("4) Analyze an array of floating-point numbers");
            System.out.println("8) Settings");
            System.out.println("0) Exit");

            int menuChoice = sc.nextInt();

            switch (menuChoice)
            {
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
                    Settings();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }
    static void taskCountOccurrences(){

    }
    static void taskReverseArray(){

    }
    static void taskSortByDigitSum(){

    }
    static void taskAnalyzeFloats(){

    }
    static void Settings(){

    }
}
