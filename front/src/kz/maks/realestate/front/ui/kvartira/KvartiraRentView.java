package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.KvartiraRentColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraRentFormField;
import kz.maks.realestate.front.forms.kvartira.KvartiraRentSearchFormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import javax.swing.*;

public class KvartiraRentView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final DynamicForm<KvartiraRentSearchParams> searchForm;
    public final JButton btnSearch;
    public final Table<KvartiraRentListDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<KvartiraRentGetDto> formDialog;

    public KvartiraRentView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new DynamicForm<>(frame, KvartiraRentSearchFormField.values(), 2);
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
                    table = new Table<>(KvartiraRentColumn.values());
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel();
                    btnCRUDPanel.btnDelete.setVisible(false);
                    hBox.add(btnCRUDPanel.ui);
                }

                DynamicForm<KvartiraRentGetDto> detailsForm = new DynamicForm<>(frame, KvartiraRentFormField.values());
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
