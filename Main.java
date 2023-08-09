public class Main {
    public static void main(String[] args) {
        ArtifactModel model = new ArtifactModel();
        ArtifactView view = new ArtifactView();
        ArtifactController controller = new ArtifactController(model, view);
        controller.calculateAndDisplayChance();
    }
}
