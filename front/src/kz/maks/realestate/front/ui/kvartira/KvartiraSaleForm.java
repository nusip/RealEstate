package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.Cache;
import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.core.front.ui.TextField;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.refs.IstochnikInfo;
import kz.maks.realestate.shared.refs.Valyuta;
import kz.maks.realestate.shared.refs.kvartira.*;

import javax.swing.*;
import java.awt.*;

import static kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField.*;

public class KvartiraSaleForm extends AbstractForm<KvartiraSaleGetDto> {

    private static final int COL_1_1_WIDTH = 360;
    private static final int COL_1_2_WIDTH = 270;

    private static final int COL_3_1_WIDTH = 300;
    private static final int COL_3_2_WIDTH = 330;

    private static final int COL_GAP_SIZE = 10;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int SHORT_FIELD_WIDTH = 50;

    private static final int LABEL_WIDTH_2 = 70;
    private static final int LABEL_WIDTH_3 = 120;
    private static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    public KvartiraSaleForm(Frame parent) {
        super(KvartiraSaleFormField.values());

        FrontUtils.addMargins(ui);
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));

        {
            FormField formField = KvartiraSaleFormField.id;
            fieldValues.put(formField, new HiddenField(formField));
        }
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addKolichestvoKomnat_etazh(vBox);
                addPloshad(vBox);
                addGodPostroiki_tipStroyeniya(vBox);
                addVZaloge(vBox);
                addCena(vBox);
                addCenaProdazhi(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRegion(vBox, parent);
                addUlica(vBox);
                addPeresechenie(vBox);
                addDomKvaritra(vBox);
                addTelNumbers(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_2_WIDTH);
            }
            ui.add(hBox);
        }
        ui.add(FrontUtils.vGap(10));
        ui.add(new JSeparator(JSeparator.HORIZONTAL));
        ui.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addOpisanie(vBox);
                addPrimechanie(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addSostoyanie(vBox);
                addPlanirovka(vBox);
                addTelefon(vBox);
                addSanuzel(vBox);
                addBalkon(vBox);
                addDver(vBox);
                addPol(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_1_2_WIDTH);
            }
            ui.add(hBox);
        }
        ui.add(FrontUtils.vGap(10));
        ui.add(new JSeparator(JSeparator.HORIZONTAL));
        ui.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addVArhive(vBox);
                addDataSozdaniya(vBox);
                addDataIzmeneniya(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_3_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRealtor(vBox);
                addIstochnikInformacii(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_3_2_WIDTH);
            }
            ui.add(hBox);
        }
    }

    private void addVZaloge(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(isZalog.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            CheckBox checkBox = new CheckBox(KvartiraSaleFormField.isZalog);
            fieldValues.put(KvartiraSaleFormField.isZalog, checkBox);
            fieldRow.add(checkBox.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addGodPostroiki_tipStroyeniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(godPostroyki.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(godPostroyki);
            FrontUtils.setMinWidth(spinner.ui, SHORT_FIELD_WIDTH);
            FrontUtils.setPreferredWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldRow.add(spinner.ui);
            fieldValues.put(godPostroyki, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(tipStroyeniya.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.tipStroyeniya, TipStroyeniya.values());
            fieldValues.put(KvartiraSaleFormField.tipStroyeniya, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRealtor(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(assignedToId.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.assignedToId, Cache.getCombo("User").toArray());
            fieldValues.put(KvartiraSaleFormField.assignedToId, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataIzmeneniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(updatedAt.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.updatedAt, DATE_FORMAT_FULL);
            dateSpinner.ui.setEnabled(false);
            fieldValues.put(KvartiraSaleFormField.updatedAt, dateSpinner);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataSozdaniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(createdAt.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.createdAt, DATE_FORMAT_FULL);
            dateSpinner.ui.setEnabled(false);
            fieldValues.put(KvartiraSaleFormField.createdAt, dateSpinner);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addVArhive(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(isArchive.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            CheckBox checkBox = new CheckBox(KvartiraSaleFormField.isArchive);
            fieldValues.put(KvartiraSaleFormField.isArchive, checkBox);
            fieldRow.add(checkBox.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPlanirovka(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(planirovka.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.planirovka, Planirovka.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.planirovka, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelNumbers(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(telNumbers.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextFieldList textFieldList = new TextFieldList(telNumbers);
            fieldValues.put(KvartiraSaleFormField.telNumbers, textFieldList);
            fieldRow.add(textFieldList.ui);
        }
//        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPol(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(pol.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.pol, Pol.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.pol, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDver(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(dver.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.dver, Dver.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.dver, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addBalkon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(balkon.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.balkon, Balkon.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.balkon, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSanuzel(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(sanuzel.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.sanuzel, Sanuzel.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.sanuzel, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelefon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(telefon.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.telefon, Telefon.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.telefon, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPrimechanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.primechanie.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.primechanie);
            fieldValues.put(KvartiraSaleFormField.primechanie, textField);
            fieldRow.add(textField.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addIstochnikInformacii(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.istochnikInfo.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.istochnikInfo, IstochnikInfo.values());
            fieldValues.put(KvartiraSaleFormField.istochnikInfo, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSostoyanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.sostoyaniye.title());
            FrontUtils.setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.sostoyaniye, Sostoyaniye.values());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.sostoyaniye, comboBox);
            fieldRow.add(comboBox.ui);
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addOpisanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.raznoe.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextAreaField textAreaField = new TextAreaField(KvartiraSaleFormField.raznoe);
            JScrollPane scrollPane = new JScrollPane(textAreaField.ui);
            FrontUtils.setPreferredHeight(scrollPane, 100);
            FrontUtils.setMinHeight(scrollPane, 100);
            fieldValues.put(KvartiraSaleFormField.raznoe, textAreaField);
            fieldRow.add(scrollPane);
        }
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDomKvaritra(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.dom.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.dom);
            FrontUtils.setForcedWidth(textField.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.dom, textField);
            fieldRow.add(textField.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.kvartira.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.kvartira);
            FrontUtils.setForcedWidth(textField.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.kvartira, textField);
            fieldRow.add(textField.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());

        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCenaProdazhi(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.cenaProdazhi.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.cenaProdazhi);
            FrontUtils.setPreferredWidth(spinner.ui, 100);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleFormField.cenaProdazhi, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCena(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.cena.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.cena);
            FrontUtils.setPreferredWidth(spinner.ui, 100);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleFormField.cena, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.valyuta.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleFormField.valyuta, Valyuta.values());
            FrontUtils.setForcedWidth(comboBox.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.valyuta, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPeresechenie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.peresechenie.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.peresechenie);
            fieldValues.put(KvartiraSaleFormField.peresechenie, textField);
            fieldRow.add(textField.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addUlica(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.ulica.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TextField textField = new TextField(KvartiraSaleFormField.ulica);
            fieldValues.put(KvartiraSaleFormField.ulica, textField);
            fieldRow.add(textField.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRegion(Box vBox, Frame parent) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.regionId.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TreeLink treeLink = new TreeLink(parent, KvartiraSaleFormField.regionId);
            fieldValues.put(KvartiraSaleFormField.regionId, treeLink);
            fieldRow.add(treeLink.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshad(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleFormField.ploshadObshaya.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.ploshadObshaya, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            FrontUtils.setPreferredWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.ploshadObshaya, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.ploshadZhilaya.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.ploshadZhilaya, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            FrontUtils.setPreferredWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.ploshadZhilaya, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.ploshadKuhnya.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.ploshadKuhnya, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            FrontUtils.setPreferredWidth(spinner.ui, SHORT_FIELD_WIDTH);
            fieldValues.put(KvartiraSaleFormField.ploshadKuhnya, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addKolichestvoKomnat_etazh(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(kolichestvoKomnat.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(kolichestvoKomnat);
            fieldRow.add(spinner.ui);
            fieldValues.put(kolichestvoKomnat, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.etazh.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.etazh);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleFormField.etazh, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(KvartiraSaleFormField.etazhnost.title());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleFormField.etazhnost);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleFormField.etazhnost, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    public void setFieldHeight(Box fieldRow) {
        FrontUtils.setHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setPreferredHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setMaxHeight(fieldRow, FIELD_ROW_HEIGHT);
    }

    public void addFieldRowGap(Box fieldRow) {
        fieldRow.add(FrontUtils.vGap());
    }

}
