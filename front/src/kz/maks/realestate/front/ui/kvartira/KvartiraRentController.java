package kz.maks.realestate.front.ui.kvartira;

import com.google.common.base.Joiner;
import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.front.ui.dom.DomSaleForm;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static kz.maks.realestate.front.services.asyncs.Asyncs.DOM_SALE_ASYNC;
import static kz.maks.realestate.front.services.asyncs.Asyncs.KVARTIRA_RENT_ASYNC;
import static kz.maks.realestate.front.services.asyncs.Asyncs.REALTOR_ASYNC;

public class KvartiraRentController {
    private final KvartiraRentView view;
    private final KvartiraRentForm form;
    private boolean needLoadHistory;

    public KvartiraRentController(KvartiraRentView view) {
        this.view = view;

        CRUD<KvartiraRentSearchParams, KvartiraRentDto, KvartiraRentDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(KvartiraRentSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.KVARTIRA_RENT_ASYNC
        );

        form = (KvartiraRentForm) view.formDialog.form;

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
        KVARTIRA_RENT_ASYNC.listHistory(id, new ProgressDialogCallback<List<KvartiraRentDto>>(view.formDialog.ui) {
            @Override
            public void onSuccess(List<KvartiraRentDto> kvartiraRentDtos) {
                form.table.set(kvartiraRentDtos);
                needLoadHistory = false;
            }
        });
    }
}
