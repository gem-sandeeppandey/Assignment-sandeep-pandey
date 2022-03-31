import org.testng.annotations.Test;

public class SecondTest {
    @Test(priority = 1)
    void setup(){
        //selemium code
        System.out.println("This is setup setup test");
    }
    @Test(priority = 2)
    void login(){
        System.out.println("This is login test");
    }
    @Test(priority = 3)
    void teardown(){
        System.out.println("closing browser");
    }

}
