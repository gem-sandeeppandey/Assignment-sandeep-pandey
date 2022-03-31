import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Candidate_who_got_less_then_Notta {

    private static WebDriver driver;
    static List<WebElement> constituencyOptions;
    static List<Integer> maximum_vote_difference=new ArrayList<Integer>();
    public static int  count;
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
            maximum_vote_difference.clear();
                        count=0;
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
        //System.out.println("number of candidate having votes less then Notta"+count);
    }
/*

    public static void minimum_vote_difference_Percentage_In_Constituency(List list,int stateIndex){
        double obj = (Integer) Collections.min(list);

        int row = list.indexOf(obj);

        System.out.println("row number "+row);
        System.out.println("person who get minimum percentage vote diffrence");
        driver.findElement(By.xpath("//*[@id='ddlState']/option[" + stateIndex + "]")).click();

        searchConstituencyByIndex(row+2);
        System.out.println("vote diffrence "+list.get(row)+"%");
    }
*/
/*
    public static int notta_Votes_for_Each_Constituenecy(String Notta_xpath){


      //  System.out.println("notta xpath  "+Notta_xpath);

        String Notta_Votes = (driver.findElement(By.xpath(Notta_xpath)).getText());
        int notta_votes=Integer.parseInt(Notta_Votes);
        return notta_votes;
    }*/


    public static void searchConstituencyByIndex(int index) {




        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();

        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        //System.out.println(constituencyName + " ");


        //Total number of rows in Web table
        String rowxpath = "//*[@id=\"div1\"]/table[1]/tbody/tr";
        int rowData = driver.findElements(By.xpath(rowxpath)).size();


        // finding all votes with their row index
        WebElement currentTotalVote = driver.findElement(By.xpath("//*[@id=\"div1\"]/table[1]/tbody/tr/td[6]"));

        String firstPart = "//*[@id=\"div1\"]/table[1]/tbody/tr[";
        String secondPart = "]/td[6]";




        String firstNotta_xpath_Part="//*[@id=\"div1\"]/table[1]/tbody/tr[";
        String secondNotta_xpath_Partt="]/td[6]";
        String finalNotta_xpath_Part=firstPart+(rowData-1)+secondPart;

        String Notta_Votes = (driver.findElement(By.xpath(finalNotta_xpath_Part)).getText());
        int notta_votes=Integer.parseInt(Notta_Votes);


        ArrayList<Integer> Votes=new ArrayList<Integer>();


        for (int i = 4; i < rowData; i++) {

            // changing expath for each row value
            String finalPart = firstPart + i + secondPart;
            //  System.out.println(finalPart);

            String votes = driver.findElement(By.xpath(finalPart)).getText();
            Integer intvote = Integer.parseInt(votes);
            int votes1 = intvote.intValue();


                 if(votes1<notta_votes){
                  //  System.out.println(votes1+"          "+ notta_votes);
                    count= count+1;
                   // System.out.println(count);
                 }
            Votes.add(votes1);
        }

        int obj = Collections.max(Votes);
        int row = Votes.indexOf(obj)+4;

       // System.out.println("maximum votes in contituency value is " + obj + " and Row position is " + row);

//candidate who won with maximum vote difference.
        int size= Votes.size();

        int secondHighestVoteGainer=getSecondLargest(Votes,size);
       // System.out.println("second votes in contituency value is " + secondHighestVoteGainer );
        int vote_differnce= (int) (obj-secondHighestVoteGainer);
//        System.out.println("vote diffre   " +vote_differnce);

        maximum_vote_difference.add(vote_differnce);

//name of candidate

        String xpathforName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + row + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();

      // System.out.println(maximum_vote_difference.size()+"                "+constituencyOptions.size());
        if(maximum_vote_difference.size()==constituencyOptions.size()-1) {

            System.out.println("The number of candidate who get vote less then notta in "
                    +constituencyname+
                    " is "+ count);
        }

    }
    public static void vote_diffrenvce_in_constituency(){

    }
    public static int getSecondLargest(ArrayList list , int size){
        Collections.sort(list);
        int secondLargest=(int)list.get(list.size()-2);

        return  secondLargest;
    }
    private static void openConnectionInCrome(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
}


