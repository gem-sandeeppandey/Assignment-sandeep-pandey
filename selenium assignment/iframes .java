package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class iframes {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://techtuts.in/");
        int count = driver.findElements(By.tagName("iframe")).size();
        System.out.println(count);
        for(int i=0;i<count;i++)
        {
            driver.switchTo().frame(i);
           System.out.println("Switched to frame "+i);
            driver.switchTo().defaultContent();
        }
    }


}
