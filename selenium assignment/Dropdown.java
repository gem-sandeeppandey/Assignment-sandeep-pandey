import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dropdown {


    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sa.pandey1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //1.Launch https://codepen.io/abdulmlik/pen/dJOJov

        driver.get("https://codepen.io/abdulmlik/pen/dJOJov");
        driver.switchTo().frame("result");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        WebElement day = driver.findElement(By.id("day"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement year = driver.findElement(By.id("year"));

          /*   Select select=new Select(day);
           select.selectByVisibleText("5");

           Select select1=new Select(month);
           select1.selectByVisibleText("5");

           Select select2=new Select(year);
           select2.selectByVisibleText("2005");*/
       //2.Select date 05-05-2005 drom the dropdown and validate the same.

        String date = "5-5-2005";
        String[] dateArr = date.split("-");
        selectVoalueFromDropDown(day, dateArr[0]);
        selectVoalueFromDropDown(month, dateArr[1]);
        selectVoalueFromDropDown(year, dateArr[2]);

    //3. Fetch the year from the dropdown and validate the year is in Ascending Order.
           driver.findElement(By.id("year"));

// Caputring all years in list
/*
List<WebElement> beforesortingyear=driver.findElements(By.className("container"));

Select dropdown=new Select(driver.findElement(By.className("container")));

        Collections.sort(beforesortingyear);
        System.out.prinln(beforesortingyear);
*/

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"year\"]"));
        System.out.println(elements.size());
        List<String> strings = new ArrayList<String>();
        for(WebElement e : elements){
            strings.add(e.getText());
        }
        Collections.sort(strings);
        // Loop to print one by one
        for (int j = 0; j < elements.size(); j++) {
            System.out.println(strings.get(j));

        }
    }

    public static void selectVoalueFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}


