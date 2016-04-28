package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.DomRentColumn;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class DomRentView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final DomRentSearchForm searchForm;
    public final Table<DomRentDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<DomRentDto> formDialog;

    public DomRentView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new DomRentSearchForm(frame);
            splitPane.setTopComponent(new JScrollPane(searchForm.ui()));
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(DomRentColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    DomRentForm detailsForm = new DomRentForm(frame);
//                FrontUtils.setPreferredWidth(detailsForm.ui(), 400);
                    formDialog = new FormDialog<>(frame, detailsForm);
                }
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
