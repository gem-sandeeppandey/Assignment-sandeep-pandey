import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.max;

public class Candidate_who_won_with_Maximum_Vote_Differnce extends Dump_to_excel {


    private static WebDriver driver;
    static List<WebElement> constituencyOptions;
    static List<Integer> maximum_vote_difference =new ArrayList<Integer>();
    static List<String> list_of_name_who_got_second_maximum_vote_constituency =new ArrayList<String>();
    private static int count=4;
    static ArrayList<Integer> list_of_Max_Votes =new ArrayList<>();
    static ArrayList<Integer> list_of_Second_Max_Votes =new ArrayList<>();
    static ArrayList<String> list_of_name_who_maximum_vote_constituency =new ArrayList<>();
    static ArrayList<String> list_of_constituency =new ArrayList<>();
    static  String constituencyname;
    static  List<String> runnerUpName=new ArrayList<String>();
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
            list_of_Max_Votes.clear();
            list_of_name_who_maximum_vote_constituency.clear();
            list_of_constituency.clear();
            runnerUpName.clear();
            list_of_name_who_got_second_maximum_vote_constituency.clear();
            list_of_Second_Max_Votes.clear();
            maximum_vote_difference.clear();
            list_of_constituency.clear();
            list_of_name_who_maximum_vote_constituency.clear();
            String state_name=driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            System.out.println(state_name);
            constituencyname = driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            constituencyOptions = constituency.getOptions();
            System.out.println("Total number of consituency in  "+constituencyname+" : " + (constituencyOptions.size()-1));


            for (int j = 1; j <=constituencyOptions.size(); j++)
            {
                searchConstituencyByIndex(j);

            }
            max_Vote_difference_in_State(state_name,list_of_constituency,list_of_name_who_maximum_vote_constituency,list_of_Max_Votes,list_of_name_who_got_second_maximum_vote_constituency,list_of_Second_Max_Votes);


        }
    }


    public static void searchConstituencyByIndex(int index) {



        // System.out.println("====================");
        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();

        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        list_of_constituency.add(constituencyName);
        // System.out.println(constituencyName + " ");


        //Total number of rows in Web table
        String rowxpath = "//*[@id=\"div1\"]/table[1]/tbody/tr";
        int rowData = driver.findElements(By.xpath(rowxpath)).size();


        // finding all votes with their row index
        WebElement currentTotalVote = driver.findElement(By.xpath("//*[@id=\"div1\"]/table[1]/tbody/tr/td[6]"));

        String firstPart = "//*[@id=\"div1\"]/table[1]/tbody/tr[";
        String secondPart = "]/td[6]";

        ArrayList<Integer> Votes=new ArrayList<Integer>();


        for (int i = 4; i < rowData; i++) {

            // changing expath for each row value
            String finalPart = firstPart + i + secondPart;
            //  System.out.println(finalPart);

            String votes = driver.findElement(By.xpath(finalPart)).getText();
            Integer intvote = Integer.parseInt(votes);
            int votes1 = intvote.intValue();

            Votes.add(votes1);
        }

        int obj = Collections.max(Votes);
        int row = Votes.indexOf(obj)+4;

        // System.out.println("maximum votes in contituency value is " + obj + " and Row position is " + row);

//candidate who won with maximum vote difference.
        int size= Votes.size();

        int secondHighestVoteGainer=getSecondLargest(Votes,size);
        //  System.out.print("     "+secondHighestVoteGainer);
        int indexOfSecond;
         indexOfSecond = Votes.indexOf(secondHighestVoteGainer)+4;
        list_of_Second_Max_Votes.add(secondHighestVoteGainer);
        int vote_differnce=obj-secondHighestVoteGainer;


        //    System.out.println("vote diffre   " +vote_differnce);
        list_of_Max_Votes.add(obj);
        maximum_vote_difference.add(vote_differnce);

//name of candidate

        String xpathforName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + row + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        list_of_name_who_maximum_vote_constituency.add(nameOfCandidate);
        //System.out.println("---" + nameOfCandidate);

        String xpathforsecondName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + indexOfSecond + "]/td[2]";
        String nameOfsecondCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        list_of_name_who_got_second_maximum_vote_constituency.add(nameOfsecondCandidate);


        if(list_of_Max_Votes.size()==constituencyOptions.size()-1) {
            int indexmax= list_of_Max_Votes.indexOf(Collections.max(list_of_Max_Votes));
            System.out.println("The candidate who get  maximum number of vote diffremce in "
                    +constituencyname+
                    " is "+
                    list_of_name_who_maximum_vote_constituency.get(indexmax)+
                    " in constituency "+ list_of_constituency.get(indexmax)+
                    " with number of vote  " + Collections.max(list_of_Max_Votes));
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
    public static void max_Vote_difference_in_State(String stateName, List<String> constiName, List<String> winningCand, List<Integer> Votes, List<String> runnerUpName, List<Integer> runnerUpVotes) {
        int idx;
        List<Integer> differenceList = new ArrayList<Integer>();
        for (int i = 0; i < Votes.size() && i < runnerUpVotes.size(); i++) {
            differenceList.add(Votes.get(i) - runnerUpVotes.get(i));
        }
//        System.out.println("difference list " + differenceList.toString());
        idx = differenceList.indexOf(max(differenceList));
        System.out.println(stateName+"  "+constiName.get(idx)+"  "+winningCand.get(idx)+"  "+Votes.get(idx)+"  "+runnerUpName.get(idx)+"  "+runnerUpVotes.get(idx)+"  "+differenceList.get(idx));
        write_Into_excel_type_2("State_wise_result",stateName,"maximum_vote_difference_margin",constiName.get(idx),winningCand.get(idx),Votes.get(idx).toString(),runnerUpName.get(idx),runnerUpVotes.get(idx).toString(),differenceList.get(idx).toString());
    }
}



// maximum_vote_difference_In_Constituency(maximum_vote_difference,2);
/*

        public static void maximum_vote_difference_In_Constituency(List list,int stateIndex){
        int obj = (int) Collections.max(list);

                int row = list.indexOf(obj);

                System.out.println("row number "+row);
        System.out.println("person who get maximum vote diffrence");
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + stateIndex + "]")).click();

            searchConstituencyByIndex(row+2);
System.out.println("vote diffrence"+list.get(row));    }

    */
