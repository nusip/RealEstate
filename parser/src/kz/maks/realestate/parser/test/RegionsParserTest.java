package kz.maks.realestate.parser.test;

import com.google.gson.Gson;
import kz.maks.realestate.parser.models.KrishaRegion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegionsParserTest {

    public static void main(String[] args) throws IOException {
        String url = "http://krisha.kz/ajax/regions?&mapGeoId=4";

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        String sJson = response.toString();

        System.out.println(sJson);

        Gson gson = new Gson();
        KrishaRegion[] regions = gson.fromJson(sJson, KrishaRegion[].class);

        for (KrishaRegion region : regions) {
            System.out.println(region);
        }
    }

}
