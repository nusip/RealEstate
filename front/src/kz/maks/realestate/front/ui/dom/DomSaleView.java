package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.DomSaleColumn;
import kz.maks.realestate.front.forms.dom.DomSaleFormField;
import kz.maks.realestate.front.forms.dom.DomSaleSearchFormField;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import javax.swing.*;
import java.awt.*;

public class DomSaleView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final Form<DomSaleSearchParams> searchForm;
    public final JButton btnSearch;
    public final Table<DomSaleListDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<DomSaleGetDto> formDialog;

    public DomSaleView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new Form<>(frame, DomSaleSearchFormField.values(), 2);
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
                    table = new Table<>(DomSaleColumn.values());
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel();
                    hBox.add(btnCRUDPanel.ui);
                }

                Form<DomSaleGetDto> detailsForm = new Form<>(frame, DomSaleFormField.values());
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
