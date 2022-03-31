import org.testng.annotations.Test;
public class ThirdCase {

        @Test
        public void tC1() {
            System.out.println("Test Case 1");
        }
    @Test
        public void tC2() {
            System.out.println("Test Case 2");
        }
        @Test(priority = 1)
        public void tC3() {
            System.out.println("Test Case 3");
        }
        @Test(priority = 3)
        public void tC4() {
            System.out.println("Test Case 4");
        }

}
