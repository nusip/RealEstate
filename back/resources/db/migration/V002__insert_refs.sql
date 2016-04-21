insert into elektrichestvo values(1, 'EST', 'есть');
insert into elektrichestvo values(2, 'EST_VOZMOJNOST_PODKL', 'есть возможность подключения');
insert into elektrichestvo values(3, 'NET', 'нет');
select setval('elektrichestvo_seq', 3);

insert into gaz values(1, 'MAGISTRALNY', 'магистральный');
insert into gaz values(2, 'AVTONOMNY', 'автономный');
insert into gaz values(3, 'EST_VOZMOJNOST_PODKL', 'есть возможность подключения');
insert into gaz values(4, 'NET', 'нет');
select setval('gaz_seq', 4);

insert into kanalizaciya values(1, 'CENTRALNAYA', 'центральная');
insert into kanalizaciya values(2, 'EST_VOZMOJNOST_PODVEDENIYA', 'есть возможность подведения');
insert into kanalizaciya values(3, 'SEPTIK', 'септик');
insert into kanalizaciya values(4, 'NET', 'нет');
select setval('kanalizaciya_seq', 4);

insert into otopleniye values(1, 'CENTRALNOE', 'центральное');
insert into otopleniye values(2, 'NA_GAZE', 'на газе');
insert into otopleniye values(3, 'NA_TVERDOM_TOPLIVE', 'на твердом топливе');
insert into otopleniye values(4, 'NA_JIDKOM_TOPLIVE', 'на жидком топливе');
insert into otopleniye values(5, 'SMESHANNOE', 'смешанное');
insert into otopleniye values(6, 'BEZ_OTOPLENIYA', 'без отопления');
select setval('otopleniye_seq', 6);

insert into domsanuzel values(1, 'RAZDELNY', 'раздельный');
insert into domsanuzel values(2, 'SOVMESHENNY', 'совмещенный');
insert into domsanuzel values(3, 'DVA_I_BOLEE', '2 с/у и более');
insert into domsanuzel values(4, 'VO_DVORE', 'во дворе');
select setval('dom_sanuzel_seq', 4);

insert into domsostoyaniye values(1, 'HOROSHEE', 'хорошее');
insert into domsostoyaniye values(2, 'SREDNEE', 'среднее');
insert into domsostoyaniye values(3, 'EVROREMONT', 'евроремонт');
insert into domsostoyaniye values(4, 'TREBUYET_REMONTA', 'требует ремонта');
insert into domsostoyaniye values(5, 'SVOBODNAYA_PLANIROVKA', 'свободная планировка');
insert into domsostoyaniye values(6, 'CHERNOVAYA_OTDELKA', 'черновая отделка');
insert into domsostoyaniye values(7, 'NEDOSTROENO', 'недостроено');
select setval('dom_sostoyaniye_seq', 7);

insert into domtelefon values(1, 'EST', 'есть');
insert into domtelefon values(2, 'EST_VOZMOJNOST_PODKL', 'есть возможность подключения');
insert into domtelefon values(3, 'NET', 'нет');
select setval('dom_telefon_seq', 3);

insert into domtipstroyeniya values(1, 'KIRPICH', 'кирпичный');
insert into domtipstroyeniya values(2, 'PANEL', 'панельный');
insert into domtipstroyeniya values(3, 'MONOLIT', 'монолитный');
insert into domtipstroyeniya values(4, 'DEREVO', 'деревянный');
insert into domtipstroyeniya values(5, 'KARKAS_KAMYSH', 'каркасно-камышитовый');
insert into domtipstroyeniya values(6, 'PENOBLOK', 'пеноблочный');
insert into domtipstroyeniya values(7, 'SANDVICH_PANEL', 'сэндвич-панели');
insert into domtipstroyeniya values(8, 'KARKAS_SHIT', 'каркасно-щитовой');
insert into domtipstroyeniya values(9, 'SHLAKOBLOK', 'шлакоблочный');
insert into domtipstroyeniya values(10, 'INOE', 'иное');
select setval('dom_tip_stroyeniya_seq', 10);

insert into voda values(1, 'CENTRALNOE_VODOSNABJENIE', 'центральное водоснабжение');
insert into voda values(2, 'EST_VOZMOJNOST_PODKL', 'есть возможность подключения');
insert into voda values(3, 'SKVAJINA', 'скважина');
insert into voda values(4, 'NET', 'нет');
select setval('voda_seq', 4);

insert into balkon values(1, 'BALKON', 'балкон');
insert into balkon values(2, 'LODJIYA', 'лоджия');
insert into balkon values(3, 'BALKON_I_LODJIYA', 'балкон и лоджия');
insert into balkon values(4, 'NESKOLKO_BALKONOV_ILI_LODJIY', 'несколько балконов или лоджий');
select setval('balkon_seq', 4);

insert into dver values(1, 'DEREVYANNAYA', 'деревянная');
insert into dver values(2, 'METALICHESKAYA', 'металлическая');
insert into dver values(3, 'BRONIROVANNAYA', 'бронированная');
select setval('dver_seq', 3);

insert into mebel values(1, 'PONOSTYU_MEBELIROVANA', 'полностью меблирована');
insert into mebel values(2, 'CHASTICHNO_MEBLIROVANA', 'частично меблирована');
insert into mebel values(3, 'PUSTAYA', 'пустая');
select setval('mebel_seq', 3);

insert into parkovka values(1, 'PARKING', 'паркинг');
insert into parkovka values(2, 'GARAZH', 'гараж');
insert into parkovka values(3, 'RYADOM_OHRANYAEMAYA_STOYANKA', 'рядом охраняемая стоянка');
select setval('parkovka_seq', 3);

insert into planirovka values(1, 'IZOLIROVANNYE', 'изолированные');
insert into planirovka values(2, 'SMEJNYE', 'смежные');
insert into planirovka values(3, 'DVA_PLUS_ODIN', '2+1');
select setval('planirovka_seq', 3);

insert into pol values(1, 'LINOLEUM', 'линолеум');
insert into pol values(2, 'PARKET', 'паркет');
insert into pol values(3, 'LAMINAT', 'ламинат');
insert into pol values(4, 'DEREVO', 'дерево');
insert into pol values(5, 'KOVROLAN', 'ковролан');
insert into pol values(6, 'PLITKA', 'плитка');
insert into pol values(7, 'PROBKOVOE', 'пробковое');
select setval('pol_seq', 7);

insert into kvartirasanuzel values(1, 'RAZDELNY', 'раздельный');
insert into kvartirasanuzel values(2, 'SOVMESHENNY', 'совмещенный');
insert into kvartirasanuzel values(3, 'DVA_I_BOLEE', '2 с/у и более');
insert into kvartirasanuzel values(4, 'NET', 'нет');
select setval('kvartira_sanuzel_seq', 4);

insert into kvartirasostoyaniye values(1, 'HOROSHEE', 'хорошее');
insert into kvartirasostoyaniye values(2, 'SREDNEE', 'среднее');
insert into kvartirasostoyaniye values(3, 'EVROREMONT', 'евроремонт');
insert into kvartirasostoyaniye values(4, 'TREBUYET_REMONTA', 'требует ремонта');
insert into kvartirasostoyaniye values(5, 'SVOBODNAYA_PLANIROVKA', 'свободная планировка');
insert into kvartirasostoyaniye values(6, 'CHERNOVAYA_OTDELKA', 'черновая отделка');
select setval('kvartira_sostoyaniye_seq', 6);

insert into kvartiratelefon values(1, 'OTDELNY', 'отдельный');
insert into kvartiratelefon values(2, 'BLOKIRATOR', 'блокиратор');
insert into kvartiratelefon values(3, 'EST_VOZMOJNOST_PODKL', 'есть возможность подключения');
insert into kvartiratelefon values(4, 'NET', 'нет');
select setval('kvartira_telefon_seq', 4);

insert into kvartiratipstroyeniya values(1, 'KIRPICH', 'кирпичный');
insert into kvartiratipstroyeniya values(2, 'PANEL', 'панельный');
insert into kvartiratipstroyeniya values(3, 'MONOLIT', 'монолитный');
insert into kvartiratipstroyeniya values(4, 'KARKAS_KAMYSH', 'каркасно-камышитовый');
insert into kvartiratipstroyeniya values(5, 'INOE', 'иное');
select setval('kvartira_tip_stroyeniya_seq', 5);

insert into internet values(1, 'ADSL', 'ADSL');
insert into internet values(2, 'TV_CABLE', 'через TV кабель');
insert into internet values(3, 'PROVODNOY', 'проводной');
insert into internet values(4, 'OPTIKA', 'оптика');
select setval('internet_seq', 4);

insert into istochnikinfo values(1, 'KRISHA', 'крыша');
insert into istochnikinfo values(2, 'IZ_RUK_V_RUKI', 'из рук в руки');
insert into istochnikinfo values(3, 'NEDVIJIMOST_BEZ_POSREDNIKOV', 'недвижимость без посредников');
insert into istochnikinfo values(4, 'GAZETA', 'газета');
select setval('istochnik_seq', 4);

insert into kaksdayete values(1, 'PO_CHASAM', 'по часам');
insert into kaksdayete values(2, 'POSUTOCHNO', 'посуточно');
insert into kaksdayete values(3, 'POMESYACHNO', 'помесячно');
insert into kaksdayete values(4, 'POKVARTALNO', 'поквартально');
select setval('kak_sdayete_seq', 4);

insert into valyuta values(1, 'TENGE', 'тг');
insert into valyuta values(2, 'USD', '$');
insert into valyuta values(3, 'EURO', '€');
insert into valyuta values(4, 'RUBLE', 'руб');
select setval('valyuta_seq', 4);
