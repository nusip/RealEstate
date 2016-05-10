package kz.maks.realestate.center_ui.columns;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.DeviceDto;

public enum DeviceColumn implements IColumn<DeviceDto> {
    @Hidden
    id("ID"),
    clientName("Имя/Наименование", 250),
    number("MAC", 250),
    isActive("Активный", 50),
    ;

    private final String title;
    private final int width;

    DeviceColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    DeviceColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public Class<DeviceDto> tableClass() {
        return DeviceDto.class;
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
