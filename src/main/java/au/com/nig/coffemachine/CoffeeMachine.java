package au.com.nig.coffemachine;

import java.util.Objects;

public class CoffeeMachine {
    public Response order(String input) {
        String[] drink = input.split(":");

        switch (drink[0]) {
            case "T":
                return new Tea(0, false);
            case "C":
                return new Coffee(0, false);
            case "H":
                return  new Chocolate(0, false);
            default:
                return new Message(drink[1]);
        }
    }
}

class Drink implements Response {
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


class Tea extends Drink {
    public Tea(Integer sugar, Boolean hasStick) {
        super(sugar, hasStick);
    }
}
class Coffee extends Drink {
    public Coffee(Integer sugar, Boolean hasStick) {
        super(sugar, hasStick);
    }
}
class Chocolate extends Drink {
    public Chocolate(Integer sugar, Boolean hasStick) {
        super(sugar, hasStick);
    }
}

interface Response {

}

class Message implements Response {
    private String message;

    public Message(String message) {
        this.message = message;
    }
}
