package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.RealtorDto;

public enum RealtorColumn implements IColumn<RealtorDto> {
    name("Имя", 250),
    vidDeyatelnosti("Вид деятельности", 250),
    company("Компания", 250),
    telNumbers("Тел. номер", 500)
    ;

    private final String title;
    private final int width;

    RealtorColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    RealtorColumn(String title, int width) {
        this.title = title;
        this.width = width;
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
        return width;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
