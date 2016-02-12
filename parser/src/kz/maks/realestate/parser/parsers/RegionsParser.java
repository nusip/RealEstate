package kz.maks.realestate.parser.parsers;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.parser.models.KrishaRegion;
import kz.maks.realestate.parser.services.RegionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

@Bean
public class RegionsParser {

    public static final KrishaRegion ROOT_REGION;

    static {
        ROOT_REGION = new KrishaRegion();
        ROOT_REGION.setId("1");
        ROOT_REGION.setLabel("Казахстан");
        ROOT_REGION.setAlias("kazakhstan");
    }

    @Inject(proxy = true)
    private RegionService regionService;

    public void parseRegions() {
        try {
            List<KrishaRegion> krishaRegions = getKrishaRegionsTree(ROOT_REGION.getId());
            ROOT_REGION.setChildren(krishaRegions);
            regionService.saveRootRegions(Lists.newArrayList(ROOT_REGION));

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private List<KrishaRegion> getKrishaRegionsTree(String id) throws IOException, InterruptedException {
        List<KrishaRegion> krishaRegions = Arrays.asList(getKrishaRegions(id));

        for (KrishaRegion krishaRegion : krishaRegions) {
            List<KrishaRegion> children = getKrishaRegionsTree(krishaRegion.getId());
            krishaRegion.setChildren(children);
        }

        return krishaRegions;
    }

    private KrishaRegion[] getKrishaRegions(String rootId) throws IOException, InterruptedException {
//        Thread.sleep(ParserUtils.SLEEP_TIME);

        String url = "http://krisha.kz/ajax/regions?&mapGeoId=" + rootId;

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

        String sJson = response.toString();

        KrishaRegion[] krishaRegions = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                .fromJson(sJson, KrishaRegion[].class);

        return krishaRegions;
    }

}
