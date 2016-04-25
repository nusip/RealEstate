package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.EnumBox;
import kz.maks.core.front.validation.AbstractFieldValidator;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.front.forms.dom.DomRentSearchFormField;
import kz.maks.realestate.shared.models.SortField;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import javax.swing.*;
import java.awt.*;

import static kz.maks.realestate.front.forms.dom.DomRentSearchFormField.*;

public class DomRentSearchForm extends AbstractForm<DomRentSearchParams> {
    private static final int COL_WIDTH = 340;
    private static final int LABEL_WIDTH = 100;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int COL_GAP_SIZE = 20;
    private static final String FROM_STR = "с";
    private static final String TO_STR = "по";

    public final JButton btnSearch = new JButton("Поиск");

    public DomRentSearchForm(Frame parent) {
        super(parent, DomRentSearchFormField.values());
        FrontUtils.addMargins(ui);
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        {
            Box hBox = Box.createHorizontalBox();
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addDataSozdaniya(vBox);
                addRegion(vBox);
                addSorting(vBox);
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
                addVArhive(vBox);
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

    private void addVArhive(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(vArhive);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(vArhive));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSorting(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(sortField);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            final EnumBox<SortField> enumBox = new EnumBox<>(sortField, SortField.values());
            fieldValues.put(sortField, new AbstractFieldValidator<String>(sortField) {
                @Override
                public String get() {
                    return Utils.extractEnumName(enumBox.get());
                }

                @Override
                public void set(String val) {
                    enumBox.set(val != null ? SortField.valueOf(val) : null);
                }
            });
            fieldComponents.put(sortField, enumBox.ui);
            fieldRow.add(enumBox.ui);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = getLabel(sortAsc);
            fieldRow.add(label);
        }
        {
            fieldRow.add(addField(sortAsc));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
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
