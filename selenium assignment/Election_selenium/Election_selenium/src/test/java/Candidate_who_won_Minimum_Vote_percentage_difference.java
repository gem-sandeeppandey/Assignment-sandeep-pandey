import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.min;

public class Candidate_who_won_Minimum_Vote_percentage_difference extends Dump_to_excel {

    private static WebDriver driver;
    static List<WebElement> constituencyOptions;
    static List<Double> maximum_vote_difference=new ArrayList<Double>();

    static ArrayList<Double> list_of_Min_Votes =new ArrayList<>();
    static ArrayList<String> list_of_name_who_minimum_vote_constituency =new ArrayList<>();
    static ArrayList<String> list_of_constituency =new ArrayList<>();
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

            list_of_Min_Votes.clear();
            list_of_name_who_minimum_vote_constituency.clear();
            list_of_constituency.clear();
            maximum_vote_difference.clear();

            String state_name=driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            System.out.println(state_name);
            constituencyname = driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            constituencyOptions = constituency.getOptions();
            // System.out.println("Total number of consituency in  "+constituencyname+" : " + (constituencyOptions.size()-1));


            for (int j = 1; j < constituencyOptions.size(); j++)
            {
                searchConstituencyByIndex(j);

            }
            min_Vote_in_State_Percentage(state_name,list_of_constituency,list_of_name_who_minimum_vote_constituency,list_of_Min_Votes);


        }

       // minimum_vote_difference_Percentage_In_Constituency(maximum_vote_difference,2);
    }

  /*  public static void minimum_vote_difference_Percentage_In_Constituency(List list,int stateIndex){
        double obj = (double) Collections.min(list);

        int row = list.indexOf(obj);

        System.out.println("row number "+row);
        System.out.println("person who get minimum percentage vote diffrence");
        driver.findElement(By.xpath("//*[@id='ddlState']/option[" + stateIndex + "]")).click();

        searchConstituencyByIndex(row+1);
        System.out.println("vote diffrence "+list.get(row)+"%");    }
*/
    public static void searchConstituencyByIndex(int index) {




        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();

        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        list_of_constituency.add(constituencyName);
        //        System.out.println(constituencyName + " ");


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

            Votes.add(votes1);
        }

        double obj = Collections.max(Votes);
        int row = Votes.indexOf(obj)+4;

        //System.out.println("maximum votes in contituency value is " + obj + " and Row position is " + row);

//candidate who won with maximum vote difference.
        int size= Votes.size();

        double secondHighestVoteGainer=getSecondLargest(Votes,size);
       // System.out.println("second votes in contituency value is " + secondHighestVoteGainer );
        double vote_differnce=obj-secondHighestVoteGainer;
//        System.out.println("vote diffre   " +vote_differnce);
        list_of_Min_Votes.add(vote_differnce);
        maximum_vote_difference.add(vote_differnce);

//name of candidate

        String xpathforName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + row + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        list_of_name_who_minimum_vote_constituency.add(nameOfCandidate);
       // System.out.println("---" + nameOfCandidate);



        if(list_of_Min_Votes.size()==constituencyOptions.size()-1) {
            int indexmin= list_of_Min_Votes.indexOf(Collections.min(list_of_Min_Votes));
            System.out.println("The candidate who get  minimum number of vote percent in "
                    +constituencyname+
                    " is "+
                    list_of_name_who_minimum_vote_constituency.get(indexmin)+
                    " in constituency "+ list_of_constituency.get(indexmin)+
                    " with margin of vote  " + Collections.min(list_of_Min_Votes)+" %");
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
    public static void min_Vote_in_State_Percentage(String stateName, List<String> constiName, List<String> winningCand, List<Double> VotesPercentage) {
        int idx = VotesPercentage.indexOf(min(VotesPercentage));
        System.out.println(constiName.get(idx) + "  " + winningCand.get(idx) + "  " + VotesPercentage.get(idx));
        write_Into_excel("State_wise_result",stateName,"minimum_vote_percentage_winner",constiName.get(idx),winningCand.get(idx),VotesPercentage.get(idx).toString());
    }

}


