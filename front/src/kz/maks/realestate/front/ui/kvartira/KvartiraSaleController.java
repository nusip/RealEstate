package kz.maks.realestate.front.ui.kvartira;

import com.google.common.base.Joiner;
import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static kz.maks.realestate.front.services.asyncs.Asyncs.KVARTIRA_SALE_ASYNC;
import static kz.maks.realestate.front.services.asyncs.Asyncs.REALTOR_ASYNC;

public class KvartiraSaleController {
    private final KvartiraSaleView view;
    private final KvartiraSaleForm form;
    private boolean historyLoaded = false;

    public KvartiraSaleController(KvartiraSaleView view) {
        this.view = view;

        CRUD<KvartiraSaleSearchParams, KvartiraSaleDto, KvartiraSaleDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(KvartiraSaleSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                KVARTIRA_SALE_ASYNC
        );

        form = (KvartiraSaleForm) view.formDialog.form;

        form.tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (form.tabs.getSelectedComponent() == form.historyPanel
                        && !historyLoaded && form.get().getId() != null) {
                    loadHistory(form.get().getId());
                }
            }
        });

        view.btnCRUDPanel.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.tabs.setSelectedIndex(0);
                historyLoaded = false;
            }
        });

        view.btnCRUDPanel.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.tabs.setSelectedIndex(0);
                historyLoaded = false;
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
        KVARTIRA_SALE_ASYNC.listHistory(id, new ProgressDialogCallback<List<KvartiraSaleDto>>(view.frame) {
            @Override
            public void onSuccess(List<KvartiraSaleDto> kvartiraSaleDtos) {
                form.table.set(kvartiraSaleDtos);
                historyLoaded = true;
            }
        });
    }

}
