package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.KvartiraSaleColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleSearchFormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import javax.swing.*;
import java.awt.*;

public class KvartiraSaleView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final Form<KvartiraSaleSearchParams> searchForm;
    public final JButton btnSearch;
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
            searchForm = new Form<>(frame, KvartiraSaleSearchFormField.values(), 2);
            splitPane.setTopComponent(new JScrollPane(searchForm.ui));
            {
                btnSearch = new JButton("Поиск");
                searchForm.insertComponent(btnSearch, 5, 0);
            }
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
                    hBox.add(btnCRUDPanel.ui);
                }

                Form<KvartiraSaleGetDto> detailsForm = new Form<>(frame, KvartiraSaleFormField.values());
                FrontUtils.setPreferredWidth(detailsForm.ui, 400);
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
