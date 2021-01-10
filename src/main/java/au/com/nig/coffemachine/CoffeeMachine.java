package au.com.nig.coffemachine;

import java.math.BigDecimal;
import java.util.Objects;

public class CoffeeMachine {
    public Response order(String input, BigDecimal price) {
        String[] drink = input.split(":");

        String sugarAmount = drink.length == 1 ? String.valueOf(0) : drink[1];

        boolean hasStick = false;
        if (drink.length != 2 && Integer.parseInt(sugarAmount) > 0)
            hasStick = true;

        CoffeeMachineFactory coffeeMachineFactory = new CoffeeMachineFactory();
        return coffeeMachineFactory.getResponse(drink, sugarAmount, hasStick, price);
    }
}

class CoffeeMachineFactory {
    public Response getResponse(String[] responseType, String sugarAmount, boolean hasStick, BigDecimal price) {
        switch (responseType[0]) {
            case "T":
//                if (correctprice)
                    return new Tea(Integer.valueOf(sugarAmount), hasStick);
//                else
//                    return Message("Missing amount:")
            case "C":
                return new Coffee(Integer.valueOf(sugarAmount), hasStick);
            case "H":
                return new Chocolate(Integer.valueOf(sugarAmount), hasStick);
            default:
                return new Message(responseType[1]);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
