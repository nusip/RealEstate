package kz.maks.realestate.center_ui.ui.client;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.center_ui.columns.ClientColumn;
import kz.maks.realestate.center_ui.forms.ClientFormField;
import kz.maks.realestate.shared.dtos.ClientDto;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class ClientView {
    public final JSplitPane ui = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    public final ClientSearchForm searchForm;
    public final Table<ClientDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final FormDialog<ClientDto> formDialog;
    public final BtnPgPanel btnPgPanel;
    public final JFrame rootFrame;

    public ClientView(JFrame frame) {
        this.rootFrame = frame;
        ui.setOneTouchExpandable(true);
        ui.setDividerSize(20);
        {
            searchForm = new ClientSearchForm(frame);
            ui.setTopComponent(searchForm.ui());
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(ClientColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    DynamicForm<ClientDto> detailsForm = new DynamicForm<>(frame, ClientFormField.values());
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
