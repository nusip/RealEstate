package kz.maks.realestate.front.ui.dom;

import com.google.common.base.Joiner;
import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static kz.maks.realestate.front.services.asyncs.Asyncs.DOM_RENT_ASYNC;
import static kz.maks.realestate.front.services.asyncs.Asyncs.DOM_SALE_ASYNC;
import static kz.maks.realestate.front.services.asyncs.Asyncs.REALTOR_ASYNC;

public class DomRentController {
    private final DomRentView view;
    private final DomRentForm form;
    private boolean needLoadHistory;

    public DomRentController(DomRentView view) {
        this.view = view;

        new CRUD<>(
                view.frame,
                new SearchPanel<>(DomRentSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.DOM_RENT_ASYNC
        );

        form = (DomRentForm) view.formDialog.form;

        form.tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (form.tabs.getSelectedComponent() == form.historyPanel && needLoadHistory) {
                    loadHistory(form.get().getId());
                }
            }
        });

        view.btnCRUDPanel.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.table.clean();
                form.tabs.setSelectedIndex(0);
                needLoadHistory = false;
            }
        });

        view.btnCRUDPanel.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.tabs.setSelectedIndex(0);
                needLoadHistory = true;
            }
        });

        form.telNumbersField().tableField.table.tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    checkNumbers();
                }
            }
        });
    }

    private void checkNumbers() {
        REALTOR_ASYNC.listRealtorsNumbers(form.telNumbersField().get(), new ProgressDialogCallback<List<String>>(view.formDialog.ui) {
            @Override
            public void onSuccess(List<String> numbers) {
                if (!numbers.isEmpty()) {
                    String message = "Следующие номера принадлежат риэлторам: \n";
                    message += Joiner.on("\n").join(numbers);
                    JOptionPane.showMessageDialog(null, message, "Внимание!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void loadHistory(Long id) {
        DOM_RENT_ASYNC.listHistory(id, new ProgressDialogCallback<List<DomRentDto>>(view.formDialog.ui) {
            @Override
            public void onSuccess(List<DomRentDto> domRentDtos) {
                form.table.set(domRentDtos);
                needLoadHistory = false;
            }
        });
    }
}
