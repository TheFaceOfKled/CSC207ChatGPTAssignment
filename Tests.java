import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class Tests {


    public class ArtifactModelTest {

        private ArtifactModel artifactModel;

        @BeforeEach
        public void setUp() {
            // Initialize the ArtifactModel instance before each test
            artifactModel = new ArtifactModel();
        }

        @Test
        public void testCalculateChance0Below() {
            // Test the calculateChance0 method with different scenarios
            // Add your test cases here and use assertions to verify the results
            // For example:
            artifactModel.setStartingCritRate(0.0);
            artifactModel.setStartingCritDamage(0.0);
            artifactModel.setDesiredCritValue(1.0);
            double result = artifactModel.calculateChance0();
            assertEquals(0.0, result);
        }

        @Test
        public void testCalculateChance0Above() {
            // Test the calculateChance0 method with different scenarios
            // Add your test cases here and use assertions to verify the results
            // For example:
            artifactModel.setStartingCritRate(0.0);
            artifactModel.setStartingCritDamage(0.0);
            artifactModel.setDesiredCritValue(0.0);
            double result = artifactModel.calculateChance0();
            assertEquals(1.0, result);
        }
        @Test
        public void testCalculateChance1() {
            artifactModel.setStartingCritRate(0.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(15.0);
            double result = artifactModel.calculateChance1();
            assertEquals(0.5, result);
        }
        @Test
        public void testCalculateChance1Fail() {
            artifactModel.setStartingCritRate(0.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(18.0);
            double result = artifactModel.calculateChance1();
            assertEquals(0.0, result);
        }
        @Test
        public void testCalculateChance1Above() {
            artifactModel.setStartingCritRate(0.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(10.0);
            double result = artifactModel.calculateChance1();
            assertEquals(1.0, result);
        }
        @Test
        public void testCalculateChance2() {
            artifactModel.setStartingCritRate(10.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(35.0);
            double result = artifactModel.calculateChance2();
            assertEquals(0.5, result);
        }
        @Test
        public void testCalculateChance2Fail() {
            artifactModel.setStartingCritRate(10.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(40.0);
            double result = artifactModel.calculateChance2();
            assertEquals(0.0, result);
        }
        @Test
        public void testCalculateChance2Above() {
            artifactModel.setStartingCritRate(10.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(30.0);
            double result = artifactModel.calculateChance2();
            assertEquals(1.0, result);
        }
        @Test
        public void testEdgeCase() {
            artifactModel.setStartingCritRate(10.0);
            artifactModel.setStartingCritDamage(10.0);
            artifactModel.setDesiredCritValue(37.77);
            double result = artifactModel.calculateChance2();
            assertEquals(0.0625, result);
        }
    }
}