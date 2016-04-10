package kz.maks.realestate.parser.assemblers.parser;

import com.google.common.base.Joiner;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.parser.entities.refs.*;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.shared.refs.*;
import kz.maks.realestate.shared.refs.Valyuta;
import kz.maks.realestate.shared.refs.kvartira.*;
import kz.maks.realestate.shared.refs.kvartira.Balkon;
import kz.maks.realestate.shared.refs.kvartira.Dver;
import kz.maks.realestate.shared.refs.kvartira.Pol;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractKvartiraEntityAssembler<ENTITY extends AbstractKvartiraEntity>
        implements IAssembler<KvartiraPlain, ENTITY> {

    @Inject
    private RegionService regionService;

    @Inject
    private RefService refService;

    @Override
    public ENTITY assemble(KvartiraPlain kvartiraPlain, ENTITY entity) {
        entity.setKrishaId(kvartiraPlain.getKrishaId());
        {
            String[] titleTokens = kvartiraPlain.getTitle().split(",");
            String[] subtitleTokens = kvartiraPlain.getSubtitle().split(",");
            {
                String kolichestvoKomnat = titleTokens[0].replaceAll("\\D+", "");
                entity.setKolichestvoKomnat(Integer.valueOf(kolichestvoKomnat));
            }
            {
                if (titleTokens.length == 3) {
                    Region region = regionService.getRegionByNameAndParent(
                            titleTokens[1].trim(),
                            subtitleTokens[subtitleTokens.length - 1].trim()
                    );

                    entity.setRegion(region);
                    entity.setUlica(titleTokens[2].trim());

                } else if (titleTokens.length == 2) {
                    Region region = regionService.getRegionByNameAndParent(
                            titleTokens[1].trim(),
                            subtitleTokens[subtitleTokens.length - 1].trim()
                    );

                    if (region == null) {
                        if (subtitleTokens.length > 1) {
                            region = regionService.getRegionByNameAndParent(
                                    subtitleTokens[subtitleTokens.length - 1].trim(),
                                    subtitleTokens[subtitleTokens.length - 2].trim()
                            );
                        } else {
                            region = regionService.getRegionByName(
                                    subtitleTokens[0].trim()
                            );
                        }
                        entity.setRegion(region);
                        entity.setUlica(titleTokens[1].trim());
                    }

                    entity.setRegion(region);

                } else {
                    throw new RuntimeException("Unexpected case");
                }

                if (entity.getRegion() == null) {
                    titleTokens[0] = null;
                    entity.setUlica(Joiner.on("").skipNulls().join(titleTokens).trim());

                    Region region;

                    if (subtitleTokens.length > 1) {
                        region = regionService.getRegionByNameAndParent(
                                subtitleTokens[subtitleTokens.length - 1].trim(),
                                subtitleTokens[subtitleTokens.length - 2].trim()
                        );
                    } else {
                        region = regionService.getRegionByName(
                                subtitleTokens[0].trim()
                        );
                    }

                    entity.setRegion(region);

                    System.err.println("REGION_NOT_FOUND_FOR_AD = " + kvartiraPlain);
                }
            }
        }

        {
            String price = kvartiraPlain.getPrice().replaceAll("\\D+", "");
            entity.setCena(BigDecimal.valueOf(Double.parseDouble(price)));
            entity.setValyuta((kz.maks.realestate.parser.entities.refs.Valyuta) refService.get(Ref.Valyuta, Valyuta.TENGE.name()));
        }

//        entity.setZhiloyKomplex(kvartiraPlain.getZhiloyKomplex());

        if (kvartiraPlain.getDom() != null) {
            String[] tokens = kvartiraPlain.getDom().split(",");

            String tipStroyeniya = tokens[0].trim();
            KvartiraTipStroyeniya ref = (KvartiraTipStroyeniya) refService.get(
                    Ref.KvartiraTipStroyeniya,
                    TipStroyeniya.getByTitle(tipStroyeniya).name());
            entity.setTipStroyeniya(ref);

            if (tokens.length > 1) {
                String godPostroyki = tokens[1].replaceAll("\\D+", "");
                entity.setGodPostroyki(Integer.parseInt(godPostroyki));
            }
        }

        if (kvartiraPlain.getEtaj() != null) {
            String[] tokens = kvartiraPlain.getEtaj().split("из");

            String etaj = tokens[0].trim();
            entity.setEtazh(Integer.parseInt(etaj));

            if (tokens.length > 1) {
                String etajnost = tokens[1].trim();
                entity.setEtazhnost(Integer.parseInt(etajnost));
            }
        }

        if (kvartiraPlain.getPloshad() != null) {
            String[] tokens = kvartiraPlain.getPloshad().split(",");

            for (String token : tokens) {
                String[] subTokens = token.split("—");

                if (subTokens.length == 1) {
                    String plowadObshaya = subTokens[0].replaceAll("\\D+", "");
                    entity.setPloshadObshaya(Double.parseDouble(plowadObshaya));
                } else {
                    String ploshadType = subTokens[0].trim();
                    String ploshadAmount = subTokens[1].replaceAll("\\D+", "");

                    if (ploshadType.startsWith("жилая")) {
                        entity.setPloshadZhilaya(Double.parseDouble(ploshadAmount));
                    } else if (ploshadType.startsWith("кухня")) {
                        entity.setPloshadKuhnya(Double.parseDouble(ploshadAmount));
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }

//        entity.setIsObwyaga("да".equalsIgnoreCase(kvartiraPlain.getObwyaga()));

        if (kvartiraPlain.getSostoyanie() != null) {
            KvartiraSostoyaniye ref = (KvartiraSostoyaniye) refService.get(Ref.KvartiraSostoyaniye,
                    Sostoyaniye.getByTitle(kvartiraPlain.getSostoyanie()).name());
            entity.setSostoyaniye(ref);
        }
        if (kvartiraPlain.getTelefon() != null) {
            KvartiraTelefon ref = (KvartiraTelefon) refService.get(Ref.KvartiraTelefon,
                    Telefon.getByTitle(kvartiraPlain.getTelefon()).name());
            entity.setTelefon(ref);
        }
//        if (kvartiraPlain.getInternet() != null) {
//            entity.setInternet(Internet.getByTitle(kvartiraPlain.getInternet()));
//        }
        if (kvartiraPlain.getSanuzel() != null) {
            KvartiraSanuzel ref = (KvartiraSanuzel) refService.get(Ref.KvartiraSanuzel,
                    Sanuzel.getByTitle(kvartiraPlain.getSanuzel()).name());
            entity.setSanuzel(ref);
        }
        if (kvartiraPlain.getBalkon() != null) {
            kz.maks.realestate.parser.entities.refs.Balkon ref = (kz.maks.realestate.parser.entities.refs.Balkon) refService.get(Ref.Balkon,
                    Balkon.getByTitle(kvartiraPlain.getBalkon()).name());
            entity.setBalkon(ref);
        }
        if (kvartiraPlain.getDver() != null) {
            kz.maks.realestate.parser.entities.refs.Dver ref = (kz.maks.realestate.parser.entities.refs.Dver) refService.get(Ref.Dver,
                    Dver.getByTitle(kvartiraPlain.getDver()).name());
            entity.setDver(ref);
        }
//        if (kvartiraPlain.getParkovka() != null) {
//            entity.setParkovka(Parkovka.getByTitle(kvartiraPlain.getParkovka()));
//        }
//        if (kvartiraPlain.getMebel() != null) {
//            entity.setMebel(Mebel.getByTitle(kvartiraPlain.getMebel()));
//        }
        if (kvartiraPlain.getPol() != null) {
            kz.maks.realestate.parser.entities.refs.Pol ref = (kz.maks.realestate.parser.entities.refs.Pol) refService.get(Ref.Pol,
                    Pol.getByTitle(kvartiraPlain.getPol()).name());
            entity.setPol(ref);
        }

//        if (kvartiraPlain.getPotolki() != null) {
//            String vysotaPotolkov = kvartiraPlain.getPotolki().replaceAll("\\D+", "");
//            entity.setVysotaPotolkov(Double.parseDouble(vysotaPotolkov));
//        }

//        if (kvartiraPlain.getBezopasnost() != null) {
//            String[] tokens = kvartiraPlain.getBezopasnost().split(",");
//
//            for (String token : tokens) {
//                token = token.trim();
//
//                if ("решетки на окнах".equalsIgnoreCase(token)) {
//                    entity.setReshetkiNaOknah(true);
//                }
//                if ("охрана".equalsIgnoreCase(token)) {
//                    entity.setOhrana(true);
//                }
//                if ("домофон".equalsIgnoreCase(token)) {
//                    entity.setDomofon(true);
//                }
//                if ("кодовый замок".equalsIgnoreCase(token)) {
//                    entity.setKodovyZamok(true);
//                }
//                if ("сигнализация".equalsIgnoreCase(token)) {
//                    entity.setSignalizaciya(true);
//                }
//                if ("видеонаблюдение".equalsIgnoreCase(token)) {
//                    entity.setVideonablyudeniye(true);
//                }
//                if ("видеодомофон".equalsIgnoreCase(token)) {
//                    entity.setVideomofon(true);
//                }
//                if ("консьерж".equalsIgnoreCase(token)) {
//                    entity.setKonsyerzh(true);
//                }
//            }
//        }

        entity.setRaznoe(kvartiraPlain.getRaznoe());

        if (kvartiraPlain.getNomer() != null) {
            String[] tokens = kvartiraPlain.getNomer().split(",");
            List<String> numbers = new ArrayList<>();

            for (String token : tokens) {
                numbers.add(token.trim());
            }

            entity.setTelNumbers(numbers);
        }

        // TODO set photo paths

        return entity;
    }
}
