package scheduler;

/**
 * Created by vande on 07/04/2016.
 */


import net.sf.corn.httpclient.HttpClient;
import net.sf.corn.httpclient.HttpResponse;

import java.net.URI;

@org.springframework.stereotype.Service
public class Service {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URI = "http://";

    protected String get() throws Exception {
        HttpClient client = new HttpClient(new URI(URI));
        HttpResponse response = client.sendData(HttpClient.HTTP_METHOD.GET);
        String result = "";
        if (!response.hasError()) {
            result = response.getData();
        } else {
            result = response.getMessage();
        }
        return result;
    }
}
