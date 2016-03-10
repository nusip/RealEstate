package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleSearchFormField;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;
import kz.maks.realestate.shared.models.RoomRange;
import kz.maks.realestate.shared.models.YesNo;

import javax.swing.*;

import java.awt.*;

public class KvartiraSaleSearchForm extends AbstractForm<KvartiraSaleSearchParams> {
    private static final int COL_WIDTH = 300;
    private static final int LABEL_WIDTH = 100;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int COL_GAP_SIZE = 20;
    private static final String FROM_STR = "с";
    private static final String TO_STR = "по";

    private final Frame parent;

    public final JButton btnSearch = new JButton("Поиск");

    public KvartiraSaleSearchForm(Frame parent) {
        super(KvartiraSaleSearchFormField.values());
        this.parent = parent;
        FrontUtils.addMargins(ui);
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        {
            Box hBox = Box.createHorizontalBox();
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addDataSozdaniya(vBox);
                addRegion(vBox);
                addKolichestvoKomnat(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addEtazh(vBox);
                addEtazhnost(vBox);
                addObwyaga(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addPloshadObshaya(vBox);
                addPloshadKuhnya(vBox);
                addBtnSearch(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            ui.add(hBox);
        }
    }

    private void addBtnSearch(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel("");
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            FrontUtils.setPreferredWidth(btnSearch, 100);
            fieldRow.add(btnSearch);
            fieldRow.add(Box.createHorizontalGlue());
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addEtazhnost(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.etazhnostMin.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(FROM_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.etazhnostMin);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.etazhnostMin, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.etazhnostMax);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.etazhnostMax, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addObwyaga(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.obwyaga.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleSearchFormField.obwyaga, YesNo.values());
            fieldValues.put(KvartiraSaleSearchFormField.obwyaga, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshadKuhnya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.ploshadKuhnyaMin.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(FROM_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.ploshadKuhnyaMin, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.ploshadKuhnyaMin, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.ploshadKuhnyaMax, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.ploshadKuhnyaMax, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshadObshaya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.ploshadObshayaMin.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(FROM_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.ploshadObshayaMin, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.ploshadObshayaMin, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.ploshadObshayaMax, Spinner.DECIMAL_MODE);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.ploshadObshayaMax, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addEtazh(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.etazhMin.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(FROM_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.etazhMin);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.etazhMin, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            Spinner spinner = new Spinner(KvartiraSaleSearchFormField.etazhMax);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.etazhMax, spinner);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addKolichestvoKomnat(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.rooms.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            EnumBox comboBox = new EnumBox(KvartiraSaleSearchFormField.rooms, RoomRange.values());
            fieldValues.put(KvartiraSaleSearchFormField.rooms, comboBox);
            fieldRow.add(comboBox.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRegion(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.regionId.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            TreeLink treeLink = new TreeLink(parent, KvartiraSaleSearchFormField.regionId);
            fieldValues.put(KvartiraSaleSearchFormField.regionId, treeLink);
            fieldRow.add(treeLink.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataSozdaniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(KvartiraSaleSearchFormField.dataSozdaniyaFrom.title());
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(FROM_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner spinner = new DateSpinner(KvartiraSaleSearchFormField.dataSozdaniyaFrom);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.dataSozdaniyaFrom, spinner);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner spinner = new DateSpinner(KvartiraSaleSearchFormField.dataSozdaniyaTo);
            fieldRow.add(spinner.ui);
            fieldValues.put(KvartiraSaleSearchFormField.dataSozdaniyaTo, spinner);
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
