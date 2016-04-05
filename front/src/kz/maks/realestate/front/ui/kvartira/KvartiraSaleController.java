package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                Asyncs.KVARTIRA_SALE_ASYNC
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

    }

    public void loadHistory(Long id) {
        Asyncs.KVARTIRA_SALE_ASYNC.listHistory(id, new ProgressDialogCallback<List<KvartiraSaleDto>>(view.frame) {
            @Override
            public void onSuccess(List<KvartiraSaleDto> kvartiraSaleDtos) {
                form.table.set(kvartiraSaleDtos);
                historyLoaded = true;
            }
        });
    }

}
