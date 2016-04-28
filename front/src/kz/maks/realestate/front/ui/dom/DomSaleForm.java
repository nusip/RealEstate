package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.ui.DynamicForm;
import kz.maks.core.front.ui.HiddenField;
import kz.maks.core.front.ui.SimpleTableField;
import kz.maks.core.front.ui.Table;
import kz.maks.realestate.front.columns.DomSaleHistoryColumn;
import kz.maks.realestate.front.forms.dom.DomSaleFormField;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.realestate.front.UserUtils.connected;
import static kz.maks.realestate.front.forms.dom.DomSaleFormField.modifiedById;
import static kz.maks.realestate.front.forms.dom.DomSaleFormField.telNumbers;

public class DomSaleForm extends DynamicForm<DomSaleDto> {
    public final JTabbedPane tabs = new JTabbedPane();
    public final JScrollPane historyPanel = new JScrollPane();
    public final Table<DomSaleDto> table = new Table<>(DomSaleHistoryColumn.values());

    private SimpleTableField telNumbersField;

    public SimpleTableField telNumbersField() {
        return telNumbersField;
    }

    public DomSaleForm(Frame parent) {
        super(parent, DomSaleFormField.values(), 3);
        tabs.setBorder(BorderFactory.createEmptyBorder());
        tabs.addTab("Дом", ui);
        tabs.addTab("История изменений", buildHistoryPanel());

        telNumbersField = (SimpleTableField) fieldValues.get(telNumbers);

        fieldValues.put(modifiedById, new HiddenField(modifiedById) {
            @Override
            public Object get() {
                return extractId(connected());
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
