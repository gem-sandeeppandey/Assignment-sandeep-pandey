import com.fasterxml.jackson.core.JsonFactoryBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class httpClient_POST {

    public static void main(String[] args) {
        try {
            String result = sendPOSTthroughJson("https://gorest.co.in/public/v2/users");
            System.out.println(result);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

private static String sendPOST(String url) throws IOException {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    String result = "";
    //          curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer ACCESS-TOKEN" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'

    HttpPost post = new HttpPost(url);

    post.addHeader("Accept", "application/json");
    post.addHeader("Content-Type", "application/json");
    post.addHeader("Authorization", "Bearer 1bf8e0761e008ef2e173713471eb296ec1fd9aad2b994b3614230b56cd56dc02");


    StringBuilder json = new StringBuilder();
    json.append("{");
    json.append("\"name\":\"sharma\",");
    json.append("\"gender\":\"male\",");
    json.append("\"email\":\"sa@gmail.com\",");
    json.append("\"status\":\"active\"");
    json.append("}");

    //send a jason data
    post.setEntity(new StringEntity(json.toString()));
    CloseableHttpResponse response = httpClient.execute(post);

    result = EntityUtils.toString(response.getEntity());
return result;

}

private static String sendPostUsingConnectionURL(String url){
    String result="";
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection=(HttpURLConnection) url1.openConnection();
           // To send a POST request, we'll have to set the request method property to POST:
                connection.setRequestMethod("POST");


            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer 1bf8e0761e008ef2e173713471eb296ec1fd9aad2b994b3614230b56cd56dc02");


            //To send request content, let's enable the URLConnection object's doOutput property to true.
                connection.setDoOutput(true);
                //json
            String inputJson="{\"name\":\"shubhi parashar\", \"gender\":\"female\", \"email\":\"Shubhi@gmail.com\", \"status\":\"active\"}";

               //dont know what this part of code will do
            try(OutputStream os = connection.getOutputStream()){
                byte[] input = inputJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

                //fetching response code e.g ok 200
            int code = connection.getResponseCode();
            System.out.println(code);


            try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))){
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
               result= response.toString();

            }


        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    return result;
}

private static String sendPOSTthroughJson(String url) throws IOException{
    CloseableHttpClient httpClient = HttpClients.createDefault();
    String result = "";
    HttpPost post = new HttpPost(url);

    post.addHeader("Accept", "application/json");
    post.addHeader("Content-Type", "application/json");
    post.addHeader("Authorization", "Bearer c9eaf55d98c03cd114547e8bb49c6f206cfecd5dff7052baeac6245288c5a7db");


    String json=new JSONObject().put("name","puspa").
            put("gender","male").
            put("email","puspa@sa.com")
            .put("status","active").toString();


    post.setEntity(new StringEntity(json));

    CloseableHttpResponse response = httpClient.execute(post);

    result = EntityUtils.toString(response.getEntity());
    return result;


}
private static
    }

