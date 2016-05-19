package kz.maks.realestate.parser.parsers;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.parser.services.RealtorService;
import kz.maks.realestate.shared.dtos.RealtorDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

@Bean
public class RealtorListParser {

    private int PAGE_LIMIT; // remove later, for testing only

    @Inject(proxy = true)
    private RealtorService realtorService;

    @Inject
    private RealtorParser realtorParser;

    public void parseRealtors() {
        PAGE_LIMIT = 999999;
        collectAdLinks();
    }

    private void parseRealtor(String adLink) {
        String krishaId = ParserUtils.extractKrishaId(adLink);
        boolean exists = realtorService.realtorExists(krishaId);

        if (!exists) {
            RealtorDto realtorDto = realtorParser.parse(adLink);
            realtorService.save(realtorDto);
        }
    }

    private void collectAdLinks() {
        final String domain = "http://krisha.kz";
        final String baseUri = "/pro/specialist/almaty/";
        String uri = "/pro/specialist/almaty/?&sort-by[status-and-date]=desc";

        Elements nav = null;

        boolean firstPage = true;

        while (PAGE_LIMIT-- > 0) {
            if (nav != null) {
                String href = nav.last().attr("href");
                uri = baseUri + href;
            }

            Document document = ParserUtils.jSoupParse(domain + uri);

            Elements elements = document.select("div.pitem > div.pr_block > div > a.name");

            for (Element element : elements) {
                String adLink = element.attr("href");
                parseRealtor(adLink);
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

    }

}
