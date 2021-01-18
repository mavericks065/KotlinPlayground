package au.com.nig.coffemachine;

import java.util.Objects;

public class Drink implements Response {
    private Integer sugar;
    private Boolean hasStick;

    public Drink(Integer sugar, Boolean hasStick) {
        this.sugar = sugar;
        this.hasStick = hasStick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;
        Drink drink = (Drink) o;
        return Objects.equals(sugar, drink.sugar) &&
                Objects.equals(hasStick, drink.hasStick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sugar, hasStick);
    }
}
