package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.*;

public class iframeandcrossbrowser {

    public static void main (String[] args)
    {
      long arr[]=new long[3];
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        long start = System.currentTimeMillis();
       driver.get("https://www.geminisolutions.com/");
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        arr[0]=totalTime;
        System.out.println("Total Time for page load on browser chrome - "+totalTime);
        System.out.println(driver.getTitle());

     /* System.setProperty("webdriver.ie.driver","C:\\Users\\D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver_ie = new InternetExplorerDriver();
        driver_ie.get("https://www.geminisolutions.com/");
        System.out.println(driver_ie.getTitle());*/

        System.setProperty("webdriver.edge.driver","C:\\Users\\sh.gupta5\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver_edge = new EdgeDriver();
        long start2 = System.currentTimeMillis();
        driver_edge.get("https://www.geminisolutions.com/");
        long finish2 = System.currentTimeMillis();
        long totalTime2 = finish2 - start2;
        arr[1]=totalTime2;
        System.out.println("Total Time for page load on browser edge- "+totalTime2);
        System.out.println(driver_edge.getTitle());

          System.setProperty("webdriver.gecko.driver","C:\\Users\\sh.gupta5\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        WebDriver driver_firefox = new FirefoxDriver();
        long start1 = System.currentTimeMillis();
        driver_firefox.get("https://www.geminisolutions.com/");
        long finish1 = System.currentTimeMillis();
        long totalTime1 = finish1 - start1;
        arr[2]=totalTime1;
        System.out.println("Total Time for page load on browser firefox - "+totalTime1);
        System.out.println(driver_firefox.getTitle());

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]<arr[j])
                {
                    long temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("Loading time of browsers in ascending order");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }




    }
}
