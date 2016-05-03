package kz.maks.realestate.front.ui.users;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.UserColumn;
import kz.maks.realestate.front.forms.users.UserFormField;
import kz.maks.realestate.shared.dtos.UserDto;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class UserView {
    public final JSplitPane ui = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    public final JFrame rootFrame;
    public final UserSearchForm searchForm;
    public final Table<UserDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<UserDto> formDialog;

    public UserView(JFrame rootFrame) {
        this.rootFrame = rootFrame;
        ui.setOneTouchExpandable(true);
        ui.setDividerSize(20);
        {
            searchForm = new UserSearchForm(this.rootFrame);
            ui.setTopComponent(searchForm.ui());
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(UserColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    vBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    DynamicForm<UserDto> detailsForm = new DynamicForm<>(rootFrame, UserFormField.values());
                    formDialog = new FormDialog<>(rootFrame, detailsForm);
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
