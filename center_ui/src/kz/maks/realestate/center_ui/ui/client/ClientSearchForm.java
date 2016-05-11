package kz.maks.realestate.center_ui.ui.client;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.center_ui.forms.ClientSearchFormField;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import static kz.maks.realestate.center_ui.forms.ClientSearchFormField.*;

import javax.swing.*;
import java.awt.*;

public class ClientSearchForm extends AbstractForm<ClientSearchParams> {
    private static final int COL_WIDTH = 300;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int LABEL_WIDTH = 100;

    public final JButton btnSearch = new JButton("Поиск");

    public ClientSearchForm(Frame parent) {
        super(parent, ClientSearchFormField.values());
        FrontUtils.addMargins(ui);
        ui.setLayout(new BoxLayout(ui, BoxLayout.Y_AXIS));
        {
            Box hBox = Box.createHorizontalBox();
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addName(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
                addIsActive(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setForcedWidth(vBox, COL_WIDTH);
            }
            hBox.add(Box.createHorizontalGlue());
            {
                Box vBox = Box.createVerticalBox();
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

    private void addIsActive(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(isActive);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(isActive));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addName(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(name);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(name));
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
