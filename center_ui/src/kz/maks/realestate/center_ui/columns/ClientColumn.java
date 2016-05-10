package kz.maks.realestate.center_ui.columns;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.ClientDto;

public enum ClientColumn implements IColumn<ClientDto> {
    @Hidden
    id("ID"),
    name("Имя/Наименование", 250),
    isActive("Активный", 50),
    deviceNumbers("Устройства", 500),
    ;

    private final String title;
    private final int width;

    ClientColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    ClientColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public Class<ClientDto> tableClass() {
        return ClientDto.class;
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
