import org.asynchttpclient.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.preparePost("https://travelco2.com/api/v1/simpletrips")
                        .setHeader("Content-Type","application/json")
                        .setHeader("Accept","application/json")
                        .setHeader("Authorization","Bearer RFXykRMgYo0tRKYwzOBlWlSSDHWHgFkOgktJIFF6Acbd938UkySNZbG2B9VE\t")
                        .setBody("{\n  \"from\": \"Berlin, Germany\",\n  \"to\": \"Stockholm, Sweden\",\n  \"ways\": 2,\n  \"people\": 2,\n  \"language\": \"en\",\n  \"title\": \"Comparing flying and public transport from Berlin to Stockholm.\",\n  \"transport_types\": [\n    \"flying\",\n    \"public-transport\"\n  ]\n}")
                        .execute()
                        .toCompletableFuture()
                        .thenAccept(System.out::println)
                        .join();
        //client.close();

    }



    }




