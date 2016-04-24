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

    private int PAGE_LIMIT = 2; // remove later, for testing only

    @Inject(proxy = true)
    private RealtorService realtorService;

    @Inject
    private RealtorParser realtorParser;

    public void parseRealtors() {
        List<String> adLinks = collectAdLinks();

        for (String adLink : adLinks) {
            parseRealtor(adLink);
        }
    }

    private void parseRealtor(String adLink) {
        String krishaId = ParserUtils.extractKrishaId(adLink);
        boolean exists = realtorService.realtorExists(krishaId);

        if (!exists) {
            RealtorDto realtorDto = realtorParser.parse(adLink);
            realtorService.save(realtorDto);
        }
    }

    private List<String> collectAdLinks() {
        final String domain = "http://krisha.kz";
        final String baseUri = "/pro/specialist/almaty/";
        String uri = "/pro/specialist/almaty/?&sort-by[status-and-date]=desc";

        List<String> adLinks = new ArrayList<>();

        Elements nav = null;

        boolean firstPage = true;

        while (PAGE_LIMIT-- > 0) {
            if (nav != null) {
                String href = nav.last().attr("href");
                uri = baseUri + href;
            }

            Document document = ParserUtils.jSoupParse(domain + uri);

            Elements elements = document.select("div.pitem > div.pr_block > div > a.name");

            System.out.println("COUNT: " + elements.size());

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

        System.out.println("TOTAL COUNT: " + adLinks.size());

        return adLinks;
    }

}
