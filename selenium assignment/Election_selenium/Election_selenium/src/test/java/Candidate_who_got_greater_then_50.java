import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Candidate_who_got_greater_then_50 {

    private static WebDriver driver;
    static List<WebElement> constituencyOptions;
    static List<Double> maximum_vote_difference=new ArrayList<Double>();
public static int count_percentage_greater_then_50 ;

    static  String constituencyname;
    public static void main(String[] args) {


        String target_URL = "https://results.eci.gov.in/ResultAcGenMar2022/partywiseresult-S05.htm";

        openConnectionInCrome(target_URL);
        WebElement em = driver.findElement(By.linkText("Constituencywise-All Candidates"));
        em.click();

        WebElement selectState=driver.findElement(By.xpath("//*[@id='ddlState']"));
        Select state = new Select(selectState);
        List<WebElement> statechange = state.getOptions();
        System.out.println( "Total number of states : "+ statechange.size());

        for( int k=2;k<= statechange.size();k++) {
            count_percentage_greater_then_50=0;
            System.out.println(driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText());
             constituencyname = driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            constituencyOptions = constituency.getOptions();
            // System.out.println("Total number of consituency in  "+constituencyname+" : " + (constituencyOptions.size()-1));


            for (int j = 2; j <=constituencyOptions.size(); j++)
            {
                searchConstituencyByIndex(j);

            }

        }
     //   System.out.println("number of candidates who votes greater then 50%---------"+count_percentage_greater_then_50);
    }

    public static void searchConstituencyByIndex(int index) {




        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();

        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());



        //Total number of rows in Web table
        String rowxpath = "//*[@id=\"div1\"]/table[1]/tbody/tr";
        int rowData = driver.findElements(By.xpath(rowxpath)).size();


        // finding all votes with their row index
        WebElement currentTotalVote = driver.findElement(By.xpath("//*[@id=\"div1\"]/table[1]/tbody/tr/td[7]"));

        String firstPart = "//*[@id=\"div1\"]/table[1]/tbody/tr[";
        String secondPart = "]/td[7]";

        ArrayList<Double> Votes=new ArrayList<Double>();


        for (int i = 4; i < rowData; i++) {

            // changing expath for each row value
            String finalPart = firstPart + i + secondPart;
            //  System.out.println(finalPart);

            String votes = driver.findElement(By.xpath(finalPart)).getText();
            Double intvote = Double.parseDouble(votes);
            double votes1 = intvote.doubleValue();


  if(votes1>50.0)
  {
      count_percentage_greater_then_50=count_percentage_greater_then_50+1;

  }
            Votes.add(votes1);
        }

        double obj = Collections.max(Votes);
        int row = Votes.indexOf(obj)+4;

        //System.out.println("maximum votes in contituency value is " + obj + " and Row position is " + row);

//candidate who won with maximum vote difference.
        int size= Votes.size();

        double secondHighestVoteGainer=getSecondLargest(Votes,size);
        //System.out.println("second votes in contituency value is " + secondHighestVoteGainer );
        double vote_differnce=obj-secondHighestVoteGainer;
//        System.out.println("vote diffre   " +vote_differnce);

        maximum_vote_difference.add(vote_differnce);

//name of candidate

        String xpathforName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + row + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();

        //System.out.println("---" + nameOfCandidate);
        if(maximum_vote_difference.size()==constituencyOptions.size()-1) {

            System.out.println("The number of candidate who get vote less then 50 % in "
                    +constituencyname+
                    " is "+ count_percentage_greater_then_50);
        }

    }
    public static void vote_diffrenvce_in_constituency(){

    }
    public static double getSecondLargest(ArrayList list , int size){
        Collections.sort(list);
        double secondLargest=(double)list.get(list.size()-2);

        return  secondLargest;
    }
    private static void openConnectionInCrome(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
}
