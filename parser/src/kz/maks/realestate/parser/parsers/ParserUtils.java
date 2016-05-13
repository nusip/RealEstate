package kz.maks.realestate.parser.parsers;

import kz.maks.core.shared.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.Callable;

public class ParserUtils {

    public static final boolean USE_PROXY = false;
    private static final int SLEEP_TIME = 6000;

    public static HttpURLConnection getConnection(String url) {
        try {
            if (USE_PROXY) {
                return getProxyConnection(url);
            } else {
                return getNonProxyConnection(url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpURLConnection getNonProxyConnection(String url) throws IOException {
        URL obj = new URL(url);
        return (HttpURLConnection) obj.openConnection();
    }

    private static HttpURLConnection getProxyConnection(String url) throws IOException {
        String proxyStr = ProxyList.getProxyStr();
        String[] tokens = proxyStr.split(":");
        String host = tokens[0];
        int port = Integer.parseInt(tokens[1]);

        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
        return (HttpURLConnection) obj.openConnection(proxy);
    }

    private static Document jSoupProxyParse(String url) throws IOException {
        HttpURLConnection connection = getProxyConnection(url);
        String line;
        StringBuffer tmp = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((line = in.readLine()) != null) {
            tmp.append(line);
        }

        return Jsoup.parse(String.valueOf(tmp));
    }

    private static Document jSoupProxyParseMaxAttempts(final String url) {
        final Document[] document = {null};

        Utils.execute(ProxyList.count(), IOException.class, new Callable() {
            @Override
            public Object call() throws Exception {
                document[0] = jSoupProxyParse(url);
                return null;
            }
        });

        return document[0];
    }

    public static synchronized Document jSoupParse(final String url) {
        try {
            synchronizedWait();

            if (USE_PROXY) {
                return jSoupProxyParseMaxAttempts(url);
            } else {
                return Jsoup.connect(url).get();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractKrishaId(String adLink) {
        adLink = adLink.endsWith("/") ? adLink.substring(0, adLink.lastIndexOf("/")) : adLink;
        String id = adLink.substring(adLink.lastIndexOf("/") + 1);
        return id;
    }

    public static synchronized void synchronizedWait() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
    }

}
