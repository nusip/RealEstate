package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.DomSaleColumn;
import kz.maks.realestate.front.forms.dom.DomSaleFormField;
import kz.maks.realestate.front.forms.dom.DomSaleSearchFormField;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class DomSaleView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final DomSaleSearchForm searchForm;
    public final Table<DomSaleDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<DomSaleDto> formDialog;

    public DomSaleView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new DomSaleSearchForm(frame);
            splitPane.setTopComponent(new JScrollPane(searchForm.ui()));
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(DomSaleColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    DomSaleForm detailsForm = new DomSaleForm(frame);
//                    FrontUtils.setPreferredWidth(detailsForm.ui(), 400);
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
