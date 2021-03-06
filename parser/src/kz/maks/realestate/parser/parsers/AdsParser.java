package kz.maks.realestate.parser.parsers;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Bean
public class AdsParser {

    private int PAGE_LIMIT; // remove later, for testing only

    @Inject(proxy = true)
    private KvartiraSaleService kvartiraSaleService;

    @Inject
    private KvartiraParser kvartiraParser;

    private Logger log = Logger.getLogger(AdsParser.class);

    public void parseAds() throws InterruptedException, SQLException, IOException {
        parseKvartiraSales();
    }

    private void parseKvartiraSales() throws IOException, InterruptedException {
        PAGE_LIMIT = 999999;
        List<String> adLinks = collectAdLinks();

        for (String adLink : adLinks) {
            try {
                parseKvartiraSale(adLink);

            } catch (Exception e) {
                log.error(null, e);
            }
        }
    }

    private void parseKvartiraSale(String adLink) throws IOException, InterruptedException {
        String krishaId = ParserUtils.extractKrishaId(adLink);
        boolean exists = kvartiraSaleService.kvartiraSaleExists(krishaId);

        if (!exists) {
            KvartiraPlain kvartiraPlain = kvartiraParser.parse(adLink);
            kvartiraSaleService.saveKvartiraSale(kvartiraPlain);
        }
    }

    private List<String> collectAdLinks() {
        String domain = "http://krisha.kz";
        String uri = "/prodazha/kvartiry/almaty/?das[who]=1";

        List<String> adLinks = new ArrayList<>();

        Elements nav = null;

        boolean firstPage = true;

        while (PAGE_LIMIT-- > 0) {
            uri = nav == null ? uri : nav.last().attr("href");

            Document document = ParserUtils.jSoupParse(domain + uri);

            Elements elements = document.select("div.item > div.descr > div.title > a");

            for (Element element : elements) {
                adLinks.add(element.attr("href"));
            }

            nav = document.select("a.nn");

            if (nav.size() == 0) {
                break;
            } else if (nav.size() == 1 && firstPage) {
                firstPage = false;
                continue;
            } else if (nav.size() == 1) {
                break;
            } else { // nav.size() == 2
                continue;
            }
        }

        return adLinks;
    }

}
