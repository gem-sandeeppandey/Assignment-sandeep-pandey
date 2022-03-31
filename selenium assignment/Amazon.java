import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sa.pandey1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println("hello");
        }


        driver.findElement(By.name("field-keywords")).sendKeys("books");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).sendKeys(Keys.ENTER);
       // driver.findElement(By.ByLinkText("Warlord of Ayodhya Book 1: Rebellion")).click();


        WebElement name= driver.findElement(By.className("a-section aok-relative s-image-fixed-height"));
        System.out.println(name.getText());
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            System.out.println("hello");
        }

    }
}