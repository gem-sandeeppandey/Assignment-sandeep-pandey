import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Alert {
    public static void main(String[] args) throws InterruptedException,AWTException{
        String projectPath=System.getProperty("user.dir");
        System.out.println(projectPath);

        System.setProperty("webdriver.chrome.driver","D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Alert message handling
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.manage().window().maximize();
/*

//1. Click on Alert and accept it
        driver.findElement(By.name("alert")).click();
        Thread.sleep(3000);


        //Switching to alert
        org.openqa.selenium.Alert alert;

        alert=driver.switchTo().alert();

        //capturing alert message
        String alertMessage=driver.switchTo().alert().getText();

        System.out.print(alertMessage);
        Thread.sleep(1000);

        //accepting alert
        driver.switchTo().alert().accept();
*/
/*

//2. Click on confirmation box and get the text and cancel it




        driver.findElement(By.name("confirmation")).click();
        Thread.sleep(3000);
        String confirmationMessage=driver.switchTo().alert().getText();
        System.out.print(confirmationMessage);
        Thread.sleep(1000);
        org.openqa.selenium.Alert alert;

        alert=driver.switchTo().alert();
        alert.dismiss();

*/

      /*  //3. Click on prompt and enter text and accept it
        driver.findElement(By.name("prompt")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Sandeep Pandey");
        Thread.sleep(1000);

        driver.switchTo().alert().accept();

        driver.close();
*/
/*
        //5. Double click on Double click me and get the text from alert

        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(By.id("double-click"));
        actions.doubleClick(element).perform();

        String confirmationMessage=driver.switchTo().alert().getText();
        System.out.println("Alert Text\n" +confirmationMessage);

     */

       /* //6. Move mouse to Sub menu and click on it

        WebElement element=driver.findElement(By.id("sub-menu"));
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);

       *//*
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Google");*//*
*/
/*
        //7.Press tab key and select google and click on it
        WebElement element=driver.findElement(By.id("sub-menu"));
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
element.sendKeys(Keys.TAB);
element.sendKeys(Keys.ENTER);*/
    }
}
