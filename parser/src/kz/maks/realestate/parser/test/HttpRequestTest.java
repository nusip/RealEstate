package kz.maks.realestate.parser.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by Maksat on 20.12.2015.
 */
public class HttpRequestTest {

    public static void main(String[] args) throws IOException {
        String url = "http://krisha.kz/ajax/show-advert-phones?id=19364117";

        URL obj = new URL(url);

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("12.207.13.20", 3128));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

        con.setRequestMethod("GET");
        con.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        System.out.println(response.toString());
    }

}
