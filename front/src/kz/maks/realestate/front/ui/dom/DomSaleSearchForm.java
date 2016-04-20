package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.forms.dom.DomSaleSearchFormField;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import javax.swing.*;
import java.awt.*;

import static kz.maks.realestate.front.forms.dom.DomSaleSearchFormField.*;

public class DomSaleSearchForm extends AbstractForm<DomSaleSearchParams> {
    private static final int COL_WIDTH = 300;
    private static final int LABEL_WIDTH = 100;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int COL_GAP_SIZE = 20;
    private static final String FROM_STR = "с";
    private static final String TO_STR = "по";

    public final JButton btnSearch = new JButton("Поиск");

    public DomSaleSearchForm(Frame parent) {
        super(parent, DomSaleSearchFormField.values());
        FrontUtils.addMargins(ui);
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        {
            Box hBox = Box.createHorizontalBox();
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addDataSozdaniya(vBox);
                addRegion(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addPloshadObshaya(vBox);
                addPloshadKuhnya(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addKolichestvoKomnat(vBox);
                addBtnSearch(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            ui.add(hBox);
        }
        processAnnotations();
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

    private void addKolichestvoKomnat(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(rooms);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(rooms));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshadKuhnya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(ploshadKuhnyaMin);
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
            fieldRow.add(addField(ploshadKuhnyaMin));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(ploshadKuhnyaMax));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshadObshaya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(ploshadObshayaMin);
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
            fieldRow.add(addField(ploshadObshayaMin));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(ploshadObshayaMax));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataSozdaniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(dataSozdaniyaFrom);
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
            fieldRow.add(addField(dataSozdaniyaFrom));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = new JLabel(TO_STR);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(dataSozdaniyaTo));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRegion(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(regionId);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(regionId));
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
