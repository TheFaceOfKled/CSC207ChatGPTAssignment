public class Main {
    public static void main(String[] args) {
        ArtifactModel model = new ArtifactModel();
        ArtifactView view = new ArtifactView();
        ArtifactController controller = new ArtifactController(model, view);

        // Choose the appropriate strategy based on user inputs
        if (model.getStartingCritValue() == 0) {
            controller.setCalculationStrategy(new ZeroStartingCritValueStrategy());
        } else {
            controller.setCalculationStrategy(new NonZeroStartingCritValueStrategy());
        }

        controller.calculateAndDisplayChance();
    }
}