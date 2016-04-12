package kz.maks.realestate.front.ui.realtors;

import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.columns.RealtorColumn;
import kz.maks.realestate.front.forms.realtors.RealtorSearchFormField;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import javax.swing.*;

public class RealtorView {

    public final JSplitPane ui = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    public final Table<RealtorDto> table;
    public final BtnPgPanel btnPgPanel;
    public final RealtorSearchForm searchForm;
    public final JFrame rootFrame;

    public RealtorView(JFrame rootFrame) {
        this.rootFrame = rootFrame;
        ui.setOneTouchExpandable(true);
        ui.setDividerSize(20);
        {
            searchForm = new RealtorSearchForm(rootFrame);
            ui.setTopComponent(searchForm.ui);
        }
        {
            Box vBox = Box.createVerticalBox();
            {
                table = new Table<>(RealtorColumn.values());
                JScrollPane scrollPane = new JScrollPane(table.ui);
                vBox.add(scrollPane);
            }
            {
                btnPgPanel = new BtnPgPanel();
                vBox.add(btnPgPanel.ui);
            }
            ui.setBottomComponent(vBox);
        }
    }

}
