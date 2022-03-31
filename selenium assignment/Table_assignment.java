import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Table_assignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sa.pandey1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //1.Launch https://codepen.io/abdulmlik/pen/dJOJov
//2. Launch the file.
        driver.get("file:///C:/Users/sa.pandey1/Downloads/Assignment.html");
//        driver.switchTo().frame("result");
//        Thread.sleep(1000);
        driver.manage().window().maximize();
/*

        TreeMap<String,Integer> tree_map
                = new TreeMap<String,Integer>();


        List <WebElement> col = driver.findElements(By.xpath("\"//table/tbody/tr\""));
        System.out.println("No of cols are : " +col.size());
*/

        List<WebElement> elements = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
System.out.println(elements.size());
ArrayList<String> list=new ArrayList<String>();

        for (WebElement cell : elements) {
            System.out.println("content >>   " + cell.getText());
            list.add(cell.getText());
        }
        list.stream().distinct().forEach(System.out::println);
       /* String[] str = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        Map<String, ArrayList<String>> map1=new HashMap<String, ArrayList<String>>();
map1.put(str[],new ArrayList<String>());
map1.get(str2[3]).add(str2[4]);
        map1.get(str2[3]).add(str2[5]);
        map1.get(str2[6]).add(str2[7]);
        map1.get(str2[6]).add(str2[8]);
        map1.get(str2[9]).add(str2[10]);
        map1.get(str2[9]).add(str2[11]);
    System.out.println(Arrays.asList(map1));
   */ }

}
