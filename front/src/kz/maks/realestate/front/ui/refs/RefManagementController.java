package kz.maks.realestate.front.ui.refs;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.front.services.asyncs.Asyncs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RefManagementController {

    private final RefManagementView view;

    public RefManagementController(final RefManagementView view) {
        this.view = view;

        view.btnCRUDPanel.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        view.btnCRUDPanel.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.table.addEmptyRow();
            }
        });

        view.btnCRUDPanel.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }

    private void save() {
        Asyncs.REF_ASYNC.save(view.ref, view.table.get(), new ProgressDialogCallback<Void>(view.parent) {
            @Override
            public void onSuccess(Void aVoid) {
                JOptionPane.showMessageDialog(view.parent, "Изменения сохранены", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void refresh() {
        Asyncs.REF_ASYNC.list(view.ref, new ProgressDialogCallback<List<RefDto>>(view.parent) {
            @Override
            public void onSuccess(List<RefDto> refDtos) {
                view.table.set(refDtos);
            }
        });
    }

}
