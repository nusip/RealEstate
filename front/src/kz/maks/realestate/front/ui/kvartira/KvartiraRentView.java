package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.KvartiraRentColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraRentFormField;
import kz.maks.realestate.front.forms.kvartira.KvartiraRentSearchFormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import javax.swing.*;

import static kz.maks.core.front.ui.BtnCRUDPanel.Button.ADD;
import static kz.maks.core.front.ui.BtnCRUDPanel.Button.EDIT;

public class KvartiraRentView {
    public final JSplitPane ui;
    public final JFrame frame;
    public final KvartiraRentSearchForm searchForm;
    public final Table<KvartiraRentDto> table;
    public final BtnCRUDPanel btnCRUDPanel;
    public final BtnPgPanel btnPgPanel;
    public final FormDialog<KvartiraRentDto> formDialog;

    public KvartiraRentView(JFrame frame) {
        this.frame = frame;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(20);
        ui = splitPane;
        {
            searchForm = new KvartiraRentSearchForm(frame);
            splitPane.setTopComponent(new JScrollPane(searchForm.ui()));
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                Box hBox = Box.createHorizontalBox();
                {
                    table = new Table<>(KvartiraRentColumn.values());
                    table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane scrollPane = new JScrollPane(table.ui);
                    hBox.add(scrollPane);
                }
                {
                    btnCRUDPanel = new BtnCRUDPanel(ADD, EDIT);
                    hBox.add(btnCRUDPanel.ui);
                }
                {
                    KvartiraRentForm detailsForm = new KvartiraRentForm(frame);
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
