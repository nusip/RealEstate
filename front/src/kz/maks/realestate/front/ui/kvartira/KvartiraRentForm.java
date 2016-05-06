package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.ConnectedUser;
import kz.maks.realestate.front.columns.KvartiraRentHistoryColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraRentFormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

import javax.swing.*;
import java.awt.*;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.realestate.front.forms.kvartira.KvartiraRentFormField.modifiedById;
import static kz.maks.realestate.front.forms.kvartira.KvartiraRentFormField.telNumbers;

public class KvartiraRentForm extends DynamicForm<KvartiraRentDto> {
    public final JTabbedPane tabs = new JTabbedPane();
    public final JScrollPane historyPanel = new JScrollPane();
    public final Table<KvartiraRentDto> table = new Table<>(KvartiraRentHistoryColumn.values());

    private SimpleTableField<String> telNumbersField;

    public SimpleTableField<String> telNumbersField() {
        return telNumbersField;
    }

    public KvartiraRentForm(Frame parent) {
        super(parent, KvartiraRentFormField.values(), 3);
        tabs.setBorder(BorderFactory.createEmptyBorder());
        tabs.addTab("Квартира", ui);
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
