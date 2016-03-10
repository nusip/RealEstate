package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.DomRentColumn;
import kz.maks.realestate.front.forms.dom.DomRentFormField;
import kz.maks.realestate.front.forms.dom.DomRentSearchFormField;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import javax.swing.*;

public class DomRentView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final DynamicForm<DomRentSearchParams> searchForm;
    public final JButton btnSearch;
    public final Table<DomRentListDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<DomRentGetDto> formDialog;

    public DomRentView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new DynamicForm<>(frame, DomRentSearchFormField.values(), 2);
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
                    table = new Table<>(DomRentColumn.values());
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel();
                    btnCRUDPanel.btnDelete.setVisible(false);
                    hBox.add(btnCRUDPanel.ui);
                }

                DynamicForm<DomRentGetDto> detailsForm = new DynamicForm<>(frame, DomRentFormField.values());
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
