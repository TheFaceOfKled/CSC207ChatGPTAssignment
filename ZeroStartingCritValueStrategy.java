public class ZeroStartingCritValueStrategy implements CalculationStrategy {
    @Override
    public double calculateChance(ArtifactModel model) {
        return model.calculateChance0();
    }
}
