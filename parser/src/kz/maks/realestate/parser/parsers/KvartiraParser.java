package kz.maks.realestate.parser.parsers;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.models.KvartiraPlain;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

@Bean
public class KvartiraParser {
    private KvartiraPlain kvartiraPlain;

    @Inject
    private RealtorParser realtorParser;

    public KvartiraPlain parse(String adLink) throws IOException, InterruptedException {
        kvartiraPlain = new KvartiraPlain();

        Document document = ParserUtils.jSoupParse(adLink);

        parseId(adLink);
        parseHeader(document);
        parseBody(document);
        parsePhoneNumbers();
        parsePhotos(adLink);

        return kvartiraPlain;
    }

    private void parseId(String adLink) {
        String id = ParserUtils.extractKrishaId(adLink);
        kvartiraPlain.setKrishaId(id);
    }

    private void parsePhotos(String adLink) {
        // TODO
    }

    private void parseHeader(Document document) {
        Element header = document.select("div.contentInner > div.header_adv > span").first();

        Elements title = header.select("h1");
        kvartiraPlain.setTitle(title.first().text().trim());

        Elements price = header.select("span.price > span.price");
        kvartiraPlain.setPrice(price.first().text().trim());

        Elements subtitle = document.select("div.contentInner > span.where");
        kvartiraPlain.setSubtitle(subtitle.first().text().trim());
    }

    private void parseBody(Document document) {
        Elements rows = document.select("div.aDescr > table.fullInfo > tbody > tr");

        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.children();

            if (cols.size() == 2) {
                String param = cols.first().text().trim();
                String value = cols.last().text().trim();

                if (param.isEmpty() && value.equalsIgnoreCase("В залоге")) {
                    kvartiraPlain.setZalog(cols.last().html());
                } else if (param.equalsIgnoreCase("Дом")) {
                    kvartiraPlain.setDom(value);
                } else if (param.equalsIgnoreCase("Год постройки")) {
                    kvartiraPlain.setGodPostroiki(value);
                } else if (param.equalsIgnoreCase("ЖК")) {
                    kvartiraPlain.setZhiloyKomplex(value);
                } else if (param.equalsIgnoreCase("Этаж")) {
                    kvartiraPlain.setEtaj(value);
                } else if (param.equalsIgnoreCase("Площадь")) {
                    kvartiraPlain.setPloshad(value);
                } else if (param.equalsIgnoreCase("Состояние")) {
                    kvartiraPlain.setSostoyanie(value);
                } else if (param.equalsIgnoreCase("Санузел")) {
                    kvartiraPlain.setSanuzel(value);
                } else if (param.equalsIgnoreCase("Балкон")) {
                    kvartiraPlain.setBalkon(value);
                } else if (param.equalsIgnoreCase("Дверь")) {
                    kvartiraPlain.setDver(value);
                } else if (param.equalsIgnoreCase("Телефон")) {
                    kvartiraPlain.setTelefon(value);
                } else if (param.equalsIgnoreCase("Интернет")) {
                    kvartiraPlain.setInternet(value);
                } else if (param.equalsIgnoreCase("Парковка")) {
                    kvartiraPlain.setParkovka(value);
                } else if (param.equalsIgnoreCase("Мебель")) {
                    kvartiraPlain.setMebel(value);
                } else if (param.equalsIgnoreCase("Пол")) {
                    kvartiraPlain.setPol(value);
                } else if (param.equalsIgnoreCase("Потолки")) {
                    kvartiraPlain.setPotolki(value);
                } else if (param.equalsIgnoreCase("Безопасность")) {
                    kvartiraPlain.setBezopasnost(value);
                } else if (param.equalsIgnoreCase("В прив. общежитии")) {
                    kvartiraPlain.setObwyaga(value);
                }
            } else if (cols.size() == 1) {
                String raznoe = cols.first().text();

                if (kvartiraPlain.getRaznoe() == null) {
                    kvartiraPlain.setRaznoe(raznoe);
                } else {
                    kvartiraPlain.setRaznoe(kvartiraPlain.getRaznoe() + "\n" + raznoe);
                }
            }

        }
    }

    private void parsePhoneNumbersInner() throws IOException {
        String url = "http://krisha.kz/ajax/show-advert-phones?id=" + kvartiraPlain.getKrishaId();
        HttpURLConnection con = ParserUtils.getConnection(url);

        con.setRequestMethod("GET");
        con.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        String number = response.toString();

        if (!number.isEmpty()) {
            kvartiraPlain.setNomer(number);
        }
    }

    private void parsePhoneNumbers() throws IOException, InterruptedException {
        ParserUtils.synchronizedWait();

        if (ParserUtils.USE_PROXY) {
            parsePhoneNumbersWithProxyMaxAttempts();
        } else {
            parsePhoneNumbersInner();
        }
    }

    private void parsePhoneNumbersWithProxyMaxAttempts() throws IOException {
        Utils.execute(ProxyList.count(), IOException.class, new Callable() {
            @Override
            public Object call() throws Exception {
                parsePhoneNumbersInner();
                return null;
            }
        });

    }

}
