package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.KvartiraSaleColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class KvartiraSaleView {
    public final JSplitPane ui = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    public final JFrame frame;
    public final KvartiraSaleSearchForm searchForm;
    public final Table<KvartiraSaleDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<KvartiraSaleDto> formDialog;

    public KvartiraSaleView(JFrame frame) {
        this.frame = frame;
        ui.setOneTouchExpandable(true);
        ui.setDividerSize(20);
        {
            searchForm = new KvartiraSaleSearchForm(frame);
            ui.setTopComponent(new JScrollPane(searchForm.ui()));
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(KvartiraSaleColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    KvartiraSaleForm detailsForm = new KvartiraSaleForm(frame);
                    formDialog = new FormDialog<>(frame, detailsForm);
                }
                vBox.add(hBox);
            }
            {
                btnPgPanel = new BtnPgPanel();
                vBox.add(btnPgPanel.ui);
            }
            ui.setBottomComponent(vBox);
        }
    }
}
