package kz.maks.realestate.parser.parsers;

public class ProxyList {

    private static final String[] PROXY_LIST = new String[] {
            "213.208.177.124:3128",
            "52.25.81.220:80",
            "82.209.251.164:80",
            "184.154.58.99:8888",
            "103.254.127.82:80",
            "88.153.53.65:80",
            "45.63.83.49:8080",
            "200.35.187.114:8080",
            "104.156.226.200:8080",
            "124.207.175.91:8080",
            "92.222.237.73:8898",
            "104.236.144.189:80",
            "200.86.219.33:80",
            "188.195.104.119:80",
            "80.82.154.208:8080",
            "52.76.114.223:80",
            "27.115.75.114:8080",
            "37.59.206.55:80",
            "40.76.214.190:80",
            "178.32.158.124:80",
            "103.251.83.62:8080",
            "103.42.56.85:3128",
            "80.112.128.65:80",
            "31.173.74.73:8080",
            "94.23.234.179:8585",
            "203.82.48.172:808",
            "120.198.231.23:8080",
            "117.135.250.138:80",
            "58.176.85.104:80",
            "181.48.80.122:8081",
    };

    private static int index = 0;

    public static String getProxyStr() {
        if (index > PROXY_LIST.length) {
            index = 0;
        }

        return PROXY_LIST[index++];
    }

    public static int count() {
        return PROXY_LIST.length;
    }

}