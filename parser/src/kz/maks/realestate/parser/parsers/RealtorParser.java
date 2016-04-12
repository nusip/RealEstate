package kz.maks.realestate.parser.parsers;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.shared.dtos.RealtorDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

@Bean
public class RealtorParser { // TODO check

    private RealtorDto realtorDto;

    public void parse(String link) {
        realtorDto = new RealtorDto();

        Document document = ParserUtils.jSoupParse(link);

        parseId(link);
        parseHeader(document);
        parsePhoneNumbers(document);
    }

    private void parseHeader(Document document) {
        Element header = document.select("div.pro_list > div.pro_head_info").first();
        {
            Element name = header.select("h1").first();
            realtorDto.setName(name.text().trim());
        }
        {
            Element speciality = header.select("div.pro_head_speciality").first();
            Elements companyLinks = speciality.select("a");

            if (!companyLinks.isEmpty()) {
                realtorDto.setCompany(companyLinks.first().text().trim());
            }

            {
                String vidDeyatelnosti = speciality.ownText()
                        .replaceAll("[\\W^ ]", "").trim();
                realtorDto.setVidDeyatelnosti(vidDeyatelnosti);
            }
        }
    }

    private void parsePhoneNumbers(Document document) {
        Element phones = document.select("div.pro_list > div.pro_contacts > div.pro_contacts_left > p.phones").first();
        String[] tokens = phones.ownText().split(",");

        realtorDto.setTelNumbers(new ArrayList<String>());

        for (String token : tokens) {
            realtorDto.getTelNumbers().add(token.trim());
        }
    }

    private void parseId(String adLink) {
        String id = ParserUtils.extractKrishaId(adLink);
        realtorDto.setKrishaId(id);
    }

}
