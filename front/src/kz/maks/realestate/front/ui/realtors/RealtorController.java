package kz.maks.realestate.front.ui.realtors;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static kz.maks.core.front.ui.CRUD.PAGE_SIZE;
import static kz.maks.realestate.front.services.asyncs.Asyncs.REALTOR_ASYNC;

public class RealtorController {
    private RealtorSearchParams lastParams;
    private final RealtorView view;
    private boolean hasNextPage;

    public RealtorController(final RealtorView view) {
        this.view = view;

        resetPgButtons();

        view.searchForm.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastParams = view.searchForm.get();
                lastParams.setPage(1);
                search();
            }
        });

        view.btnPgPanel.btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastParams.setPage(lastParams.getPage() + 1);
                search();
            }
        });

        view.btnPgPanel.btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastParams.setPage(lastParams.getPage() - 1);
                search();
            }
        });
    }

    private void search() {
        lastParams.setPageSize(PAGE_SIZE);

        REALTOR_ASYNC.list(lastParams, new ProgressDialogCallback<ListResponse<RealtorDto>>(view.rootFrame) {
            @Override
            public void onSuccess(ListResponse<RealtorDto> listResponse) {
                view.table.set(listResponse.getList());
                hasNextPage = listResponse.isHasNext();
                resetPgButtons();
            }
        });
    }

    private void resetPgButtons() {
        view.btnPgPanel.btnPrev.setEnabled(lastParams != null ? lastParams.getPage() > 1 : false);
        view.btnPgPanel.btnNext.setEnabled(hasNextPage);
    }

}
