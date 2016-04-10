package kz.maks.realestate.front.ui.refs;

import kz.maks.core.front.ui.BtnCRUDPanel;
import kz.maks.core.front.ui.RefColumn;
import kz.maks.core.front.ui.Table;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.shared.refs.Ref;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.*;

public class RefManagementView {

    public final Box ui = Box.createHorizontalBox();
    public final JFrame parent;
    public final Ref ref;
    public final Table<RefDto> table;
    public final BtnCRUDPanel btnCRUDPanel;

    public RefManagementView(JFrame parent, Ref ref) {
        this.parent = parent;
        this.ref = ref;
        {
            table = new Table<>(RefColumn.values(), true);
            JScrollPane scrollPane = new JScrollPane(table.ui);
            ui.add(scrollPane);
        }
        {
            btnCRUDPanel = new BtnCRUDPanel(SAVE, REFRESH);
            btnCRUDPanel.btnEdit.setVisible(false);
            ui.add(btnCRUDPanel.ui);
        }
    }

}
