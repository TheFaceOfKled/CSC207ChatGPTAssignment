import static java.lang.Math.ceil;

public class ArtifactController {
    private ArtifactModel model;
    private ArtifactView view;
    private CalculationStrategy calculationStrategy;

    private static final int MAX_ARTIFACT_LEVEL = 20;
    private static final int ARTIFACT_LEVEL_INCREMENT = 4;
    private static final double MAX_CRIT_VALUE = 7.77;
    public ArtifactController(ArtifactModel model, ArtifactView view) {
        this.model = model;
        this.view = view;
    }



    // Calculate the number of upgrades needed based on starting level
    public int calculateUpgradeCount(int startingLevel) {
        return (int) Math.ceil((double) (MAX_ARTIFACT_LEVEL - startingLevel) / ARTIFACT_LEVEL_INCREMENT);
    }


    // Calculate the required coefficient for permutations
    public double calculateRequiredCoefficient(double startingCritValue, double desiredCritValue) {
        return ((desiredCritValue - startingCritValue) / MAX_CRIT_VALUE);
    }

    public void setCalculationStrategy(CalculationStrategy strategy) {
        this.calculationStrategy = strategy;
    }

    // Calculate and display the chance of getting above the desired crit value
    public void calculateAndDisplayChance() {
        double startingCritRate = view.getStartingCritRate();
        double startingCritDamage = view.getStartingCritDamage();
        int startingLevel = view.getStartingLevel();
        double desiredCritValue = view.getDesiredCritValue();
        int upgradeCount = calculateUpgradeCount(startingLevel);

        // Convert startingCritRate and startingCritDamage to startingCritValue
        double startingCritValue = startingCritDamage + 2 * startingCritRate;

        // Get required crit coefficient for permutations
        double requiredCoefficient = calculateRequiredCoefficient(startingCritValue, desiredCritValue);

        model.setStartingCritValue(startingCritValue);
        model.setDesiredCritValue(desiredCritValue);
        model.setUpgradeCount(upgradeCount);
        model.setRequiredCoefficient(requiredCoefficient);

        double chance;
        if (startingCritValue == 0) {
            chance = model.calculateChance0();
        } else if (startingCritRate != 0 && startingCritDamage != 0) {
            chance = model.calculateChance2();
        } else {
            chance = model.calculateChance1();
        }
        view.displayResult(chance);
    }
}
