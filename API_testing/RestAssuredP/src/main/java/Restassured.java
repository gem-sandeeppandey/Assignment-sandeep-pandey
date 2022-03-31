import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import  io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.given;

public class Restassured {

    public static void main(String[] args) {
        //curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer ACCESS-TOKEN" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'
        RestAssured.baseURI= "https://gorest.co.in/";

        Put();
    }
    // Get request
    private static String Get(){
        RestAssured.basePath = "/public/v2/users";
        Response response= given().contentType(ContentType.JSON).when().relaxedHTTPSValidation().get();

         String s= response.prettyPrint();
           return s;
    }
// Post request
    private static void Post(){

        RestAssured.basePath = "/public/v2/users";

//        Map<String,Object> map=new HashMap<String,Object>();
//
//        map.put("name","sandeep");
//        map.put("gender","male");
//        map.put("email","sandeep@gmail.com");
//        map.put("status","active");
//
//        //System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name","shuchi");
        request.put("gender","female");
        request.put("email","suchi@gmail.com");
        request.put("status","active");

        //JSON of POSt
       // System.out.println(request.toString());

       given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                header("Authorization","Bearer 3de658d4656e8645464bd9b93c4cab82653d31f16b73c1c3ad1b70951d4a3652").
                body(request.toString()).
                when().post("https://gorest.co.in/public/v2/users").
                then().statusCode(201);
    }
private static void Put(){



        //curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer ACCESS-TOKEN" -XPATCH "https://gorest.co.in/public/v2/users/123" -d '{"name":"Allasani Peddana", "email":"allasani.peddana@15ce.com", "status":"active"}'
    RestAssured.basePath = "/public/v2/users/4509";

    RequestSpecification request  = RestAssured.given();
    request.header("Accept","application/json").
            header("Content-Type","application/json").
            header("Authorization","Bearer 3de658d4656e8645464bd9b93c4cab82653d31f16b73c1c3ad1b70951d4a3652");

    StringBuilder json = new StringBuilder();
    json.append("{");
    json.append("\"name\":\"sharma\",");
    json.append("\"gender\":\"male\",");
    json.append("\"email\":\"sa@gmail.com\",");
    json.append("\"status\":\"active\"");
    json.append("}");

    Response replaceUserdata =request.body(json.toString()).put("https://gorest.co.in/public/v2/users/4509");

    System.out.println(replaceUserdata.getStatusCode());


}
}
