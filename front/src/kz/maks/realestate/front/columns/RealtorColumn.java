package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.RealtorDto;

public enum RealtorColumn implements IColumn<RealtorDto> {
    name("Имя"),
    vidDeyatelnosti("Вид деятельности"),
    company("Компания"),
    telNumbers("Тел. номер")
    ;

    private final String title;

    RealtorColumn(String title) {
        this.title = title;
    }

    @Override
    public Class<RealtorDto> tableClass() {
        return RealtorDto.class;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public int width() {
        return IColumn.DEFAULT_WIDTH;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
