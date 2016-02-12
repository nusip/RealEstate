package kz.maks.realestate.shared.models;

import kz.maks.core.shared.models.IntRange;

public enum RoomRange implements IntRange {
    ANY(null, null),
    ONE(1, 1),
    ONE_TWO(1, 2),
    TWO(2, 2),
    TWO_THREE(2, 3),
    THREE(3, 3),
    THREE_FOUR(3, 4),
    FOUR(4, 4),
    FOUR_FIVE(4, 5),
    FIVE_MORE(5, null);

    private Integer min;
    private Integer max;

    RoomRange(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer min() {
        return min;
    }

    @Override
    public Integer max() {
        return max;
    }

    @Override
    public String toString() {
        String suffix = " комн.";

        if (min == null && max == null) {
            return "Не важно";
        } else if (min == max && min != null) {
            return min + suffix;
        } else if (min != null && max != null) {
            return min + "-" + max + suffix;
        } else if (min == null) {
            return max + " и менее" + suffix;
        } else if (max == null) {
            return min + " и более" + suffix;
        } else {
            throw new RuntimeException("Unexpected case");
        }

    }
}
