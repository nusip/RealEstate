package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.columns.KvartiraSaleColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleSearchFormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import javax.swing.*;

public class KvartiraSaleView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final KvartiraSaleSearchForm searchForm;
    public final Table<KvartiraSaleListDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<KvartiraSaleGetDto> formDialog;

    public KvartiraSaleView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new KvartiraSaleSearchForm(frame);
            splitPane.setTopComponent(new JScrollPane(searchForm.ui));
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(KvartiraSaleColumn.values());
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel();
                    btnCRUDPanel.btnDelete.setVisible(false);
                    hBox.add(btnCRUDPanel.ui);
                }

                KvartiraSaleForm detailsForm = new KvartiraSaleForm(frame);
                formDialog = new FormDialog<>(frame, detailsForm);

                vBox.add(hBox);
            }
            {
                btnPgPanel = new BtnPgPanel();
                vBox.add(btnPgPanel.ui);
            }
            splitPane.setBottomComponent(vBox);
        }
    }
}
