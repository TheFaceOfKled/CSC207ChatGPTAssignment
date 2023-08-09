import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArtifactModel {
    private double startingCritValue;
    private double desiredCritValue;
    private int upgradeCount;
    private double requiredCoefficient;
    private static final double MAX_CRIT_VALUE = 7.77;
    public void setStartingCritValue(double startingCritValue) {
        this.startingCritValue = startingCritValue;
    }

    public void setDesiredCritValue(double desiredCritValue) {
        this.desiredCritValue = desiredCritValue;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setRequiredCoefficient(double requiredCoefficient) {
        this.requiredCoefficient = requiredCoefficient;
    }

    // Calculate chance when starting crit value is higher or equal to desired crit value
    public double calculateChance0() {
        if (startingCritValue >= desiredCritValue) {
            return 1.0;
        }
        return 0.0;
    }


    private int totalCombinations() {
        return (int) Math.pow(16, upgradeCount);
    }

    public double calculateChance1() {
        if (startingCritValue >= desiredCritValue) {
            return 1.0;
        }
        int successfulCombinations = countCombinationsAboveThreshold1(upgradeCount, requiredCoefficient);
        return (double) successfulCombinations/totalCombinations();
    }


    private int countCombinationsAboveThreshold1(int upgradeCount, double requiredCoefficient) {
        int count = 0;
        List<Double> combList = new ArrayList<>();
        combList.add(0.0);
        combList = createCombinationList1(upgradeCount, combList);
        for (int i = 0; i < combList.size(); i++){
            if (combList.get(i) >= requiredCoefficient) {
                count++;
            }
        }
        return count;
    }

    public List<Double> createCombinationList1(int upgradeCount, List<Double> currentList) {
        if (upgradeCount == 0){
            return currentList;
        }
        List<Double> newList = new ArrayList<>();
        double[] combinationList = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.7, 0.8, 0.9, 1.0};
        for (int i = 0; i < currentList.size(); i++){

            for (int j = 0; j < 16; j++){
                newList.add(currentList.get(i) + (double) Array.get(combinationList, j));
            }
        }
        return createCombinationList1(upgradeCount - 1, newList);
    }
    public double calculateChance2() {
        if (startingCritValue >= desiredCritValue) {
            return 1.0;
        }
        int successfulCombinations = countCombinationsAboveThreshold2(upgradeCount, requiredCoefficient);
        return (double) successfulCombinations/totalCombinations();
    }

    private int countCombinationsAboveThreshold2(int upgradeCount, double requiredCoefficient) {
        int count = 0;
        List<Double> combList = new ArrayList<>();
        combList.add(0.0);
        combList = createCombinationList2(upgradeCount, combList);
        for (int i = 0; i < combList.size(); i++){
            if (combList.get(i) >= requiredCoefficient) {
                count++;
            }
        }
        return count;
    }

    public List<Double> createCombinationList2(int upgradeCount, List<Double> currentList) {
        if (upgradeCount == 0){
            return currentList;
        }
        List<Double> newList = new ArrayList<>();
        double[] combinationList = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.7, 0.8, 0.9, 1.0, 0.7, 0.8, 0.9, 1.0};
        for (int i = 0; i < currentList.size(); i++){

            for (int j = 0; j < 16; j++){
                newList.add(currentList.get(i) + (double) Array.get(combinationList, j));
            }
        }
        return createCombinationList2(upgradeCount - 1, newList);
    }

}
