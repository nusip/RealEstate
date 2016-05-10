package kz.maks.realestate.center_ui.ui.device;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.center_ui.columns.DeviceColumn;
import kz.maks.realestate.center_ui.forms.DeviceFormField;
import kz.maks.realestate.shared.dtos.DeviceDto;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class DeviceView {
    public final JSplitPane ui = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    public final DeviceSearchForm searchForm;
    public final Table<DeviceDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final FormDialog<DeviceDto> formDialog;
    public final BtnPgPanel btnPgPanel;
    public final JFrame rootFrame;

    public DeviceView(JFrame frame) {
        rootFrame = frame;
        ui.setOneTouchExpandable(true);
        ui.setDividerSize(20);
        {
            searchForm = new DeviceSearchForm(frame);
            ui.setTopComponent(searchForm.ui());
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(DeviceColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    DynamicForm<DeviceDto> detailsForm = new DynamicForm<>(frame, DeviceFormField.values());
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
