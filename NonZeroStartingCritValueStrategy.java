public class NonZeroStartingCritValueStrategy implements CalculationStrategy {
    @Override
    public double calculateChance(ArtifactModel model) {
        if (model.getStartingCritRate() != 0 && model.getStartingCritDamage() != 0) {
            return model.calculateChance2();
        } else {
            return model.calculateChance1();
        }
    }
}