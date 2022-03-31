import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.min;

public class Name_Of_Candidate_who_minimum_vote extends Dump_to_excel{

    private static boolean ASC = true;
    private static boolean DSc = false;
    private static Select constituency;
    private static WebDriver driver;
    static List<WebElement> constituencyOptions;
    static ArrayList<Integer> minimum_vote_in_constituency=new  ArrayList<Integer>();

    static ArrayList<Integer> list_of_Min_Votes =new ArrayList<>();
    static ArrayList<String> list_of_name_who_minimum_vote_constituency =new ArrayList<>();
    static ArrayList<String> list_of_constituency =new ArrayList<>();
    static String constituencyname;

    public static void main(String[] args) {

    String target_URL="https://results.eci.gov.in/ResultAcGenMar2022/partywiseresult-S05.htm";

    openConnectionInCrome(target_URL);


    WebElement em = driver.findElement(By.linkText("Constituencywise-All Candidates"));
        em.click();



    WebElement selectState=driver.findElement(By.xpath("//*[@id='ddlState']"));
    Select state = new Select(selectState);
    List<WebElement> statechange = state.getOptions();
        System.out.println( "Total number of states : "+ (statechange.size()-1));

        for( int k=2;k<=statechange.size();k++) {
            list_of_Min_Votes.clear();
            list_of_name_who_minimum_vote_constituency.clear();
            list_of_constituency.clear();
            minimum_vote_in_constituency.clear();
            String state_name=driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            System.out.println(state_name);
            constituencyname = driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
        driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


        WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
        Select constituency = new Select(dropdown2);
        constituencyOptions = constituency.getOptions();
        System.out.println("Total number of consituency in  "+constituencyname+" : " + (constituencyOptions.size()-1));


        for (int j = 1; j<constituencyOptions.size(); j++)
        {
            searchConstituencyByIndex(j);

        }
            min_Vote_in_State(state_name,list_of_constituency,list_of_name_who_minimum_vote_constituency,list_of_Min_Votes);


        }
      //  name_Of_Candidate_In_State_Who_Got_Minimum_Votes(minimum_vote_in_constituency,2);

}

/*public static void name_Of_Candidate_In_State_Who_Got_Minimum_Votes(ArrayList list,int stateIndex){
    int obj =(int) Collections.min(list);
    int row = list.indexOf(obj);

System.out.println("--------------------");
    System.out.println("person who get minimum  vote in State");
    driver.findElement(By.xpath("//*[@id='ddlState']/option[" + stateIndex + "]")).click();


    searchConstituencyByIndex(row+1);
    System.out.println(" "+list.get(row));
}*/
    public static void searchConstituencyByIndex(int index) {

        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();

        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        list_of_constituency.add(constituencyName);
      // System.out.print(constituencyName + " ");


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

        int obj = Collections.min(Votes);
        int row = Votes.indexOf(obj)+4;

       // System.out.println("minimum votes in contituency value is " + obj + " and Row position is " + row);
        list_of_Min_Votes.add( obj);
        minimum_vote_in_constituency.add(obj);
//name of candidate

        String xpathforName = "//*[@id=\"div1\"]/table[1]/tbody/tr[" + row + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        list_of_name_who_minimum_vote_constituency.add(nameOfCandidate);
        //System.out.println("---" + nameOfCandidate);


        if(list_of_Min_Votes.size()==constituencyOptions.size()-1) {
            int indexmin= list_of_Min_Votes.indexOf(Collections.min(list_of_Min_Votes));
            System.out.println("The candidate who get  minimum number of vote  in "
                    +constituencyname+
                    " is "+
                    list_of_name_who_minimum_vote_constituency.get(indexmin)+
                    " in constituency "+ list_of_constituency.get(indexmin)+
                    " with number of vote  " + Collections.min(list_of_Min_Votes));
        }
    }

    private static void openConnectionInCrome(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\browser_exefile\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    public static void min_Vote_in_State(String stateName, List<String> constiName, List<String> winningCand, List<Integer> Votes) {
        int idx = Votes.indexOf(min(Votes));
        System.out.println(constiName.get(idx) + "  " + winningCand.get(idx) + "  " + Votes.get(idx));
        write_Into_excel("State_wise_result",stateName,"candidates_with_MinVote",constiName.get(idx),winningCand.get(idx),Votes.get(idx).toString());

    }

}
