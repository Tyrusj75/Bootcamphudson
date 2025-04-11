import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask for the first number
        System.out.print("Enter the first number: ");
        float firstNumber = scanner.nextFloat();

        // Ask for the second number
        System.out.print("Enter the second number: ");
        float secondNumber = scanner.nextFloat();

        // Display the operation menu
        System.out.println("Possible calculations:");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");

        // Ask for the operation
        System.out.print("Please select an option: ");
        String option = scanner.next().toUpperCase();

        // Perform the chosen operation
        switch (option) {
            case "A":
                float sum = firstNumber + secondNumber;
                System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
                break;
            case "S":
                float difference = firstNumber - secondNumber;
                System.out.println(firstNumber + " - " + secondNumber + " = " + difference);
                break;
            case "M":
                float product = firstNumber * secondNumber;
                System.out.println(firstNumber + " * " + secondNumber + " = " + product);
                break;
            case "D":
                if (secondNumber != 0) {
                    float quotient = firstNumber / secondNumber;
                    System.out.println(firstNumber + " / " + secondNumber + " = " + quotient);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid option selected.");
        }

        scanner.close();
    }
}

}