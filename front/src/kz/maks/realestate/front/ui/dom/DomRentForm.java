package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.ConnectedUser;
import kz.maks.realestate.front.columns.DomRentHistoryColumn;
import kz.maks.realestate.front.forms.dom.DomRentFormField;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

import javax.swing.*;
import java.awt.*;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.realestate.front.forms.dom.DomRentFormField.modifiedById;
import static kz.maks.realestate.front.forms.dom.DomRentFormField.telNumbers;

public class DomRentForm extends DynamicForm<DomRentDto> {
    public final JTabbedPane tabs = new JTabbedPane();
    public final JScrollPane historyPanel = new JScrollPane();
    public final Table<DomRentDto> table = new Table<>(DomRentHistoryColumn.values());

    private SimpleTableField<String> telNumbersField;

    public SimpleTableField<String> telNumbersField() {
        return telNumbersField;
    }

    public DomRentForm(Frame parent) {
        super(parent, DomRentFormField.values(), 3);
        tabs.setBorder(BorderFactory.createEmptyBorder());
        tabs.addTab("Дом", ui);
        tabs.addTab("История изменений", buildHistoryPanel());

        telNumbersField = (SimpleTableField<String>) fieldValues.get(telNumbers);

        fieldValues.put(modifiedById, new HiddenField(modifiedById) {
            @Override
            public Object get() {
                return extractId(ConnectedUser.get());
            }
        });
    }

    @Override
    public JComponent ui() {
        return tabs;
    }

    private Component buildHistoryPanel() {
        table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        historyPanel.setViewportView(table.ui);
        return historyPanel;
    }
}
