import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class WaitsInSelenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Alert message handling
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();

    /*List<WebElement> allHeader=driver.findElements(By.xpath("//table[contains(@id,'customers')]//th"));
    System.out.println(allHeader.size());

    for(WebElement ele:allHeader){
       String value= ele.getText();

       System.out.println(value);
    }
*/
   /* //All the rows within the table
        System.out.println("=====================================");

    List<WebElement>numberOfRows=driver.findElement(By.xpath("//table[contains(@id,'customers')]//tr"));
            System.out.println("Tptal number of rows"+numberOfRows.size());
              System.out.println("=====================================");

*/
         /*   //all table data
        List<WebElement>allRecords= driver.findElements(By.xpath("//table[contains(@id,'customers')]//td"));
        int count=0;
        for (WebElement ele:
             allRecords) {

            String value=ele.getText();
            count++;

            System.out.print(value+"    ");

            if(count%3==0){
                System.out.println();
                System.out.println();
            }
        }

*/
/*
//Print ony company name
        List<WebElement>allRecords= driver.findElements(By.xpath("//table[contains(@id,'customers')]//tr//td[1]"));
        for (WebElement ele:
                allRecords) {
            String value=ele.getText();
            System.out.println(value);
        }
*/

        // Verify that Roland Mendel works in Microsoft and lives in Austria.

        WebElement element=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[4]"));
        String str=element.getText();
        String str1;
        WebElement element2;
        if(str.equals("microsoft")){
            element2=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[4]//td[2]"));
            str1=element2.getText();

            Assert.assertTrue(true, String.valueOf(str1.equals("Roland Mendel")));
        }else{
            Assert.fail();;
        }


    }
}
