
import java.util.Scanner;

public class ArtifactView {
    private Scanner scanner;

    public ArtifactView() {
        scanner = new Scanner(System.in);
    }

    // Get starting crit rate from the user
    public double getStartingCritRate() {
        System.out.print("Enter the starting crit rate: ");
        return scanner.nextDouble();
    }

    // Get starting crit damage from the user
    public double getStartingCritDamage() {
        System.out.print("Enter the starting crit damage: ");
        return scanner.nextDouble();
    }

    // Get starting level of the artifact from the user
    public int getStartingLevel() {
        System.out.print("Enter the level of the artifact: ");
        return scanner.nextInt();
    }

    // Get desired crit value from the user
    public double getDesiredCritValue() {
        System.out.print("Enter the desired crit value: ");
        return scanner.nextDouble();
    }

    // Display the calculated chance result to the user
    public void displayResult(double chance) {
        System.out.println("The chance of getting above the desired crit value: " + chance * 100 + "%");
    }
}
