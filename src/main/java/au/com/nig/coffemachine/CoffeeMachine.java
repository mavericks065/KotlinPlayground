package au.com.nig.coffemachine;

import java.math.BigDecimal;
import java.util.Objects;

public class CoffeeMachine {
    public Response order(String input, BigDecimal amount) {
        String[] drink = input.split(":");

        String sugarAmount = drink.length == 1 ? String.valueOf(0) : drink[1];

        boolean hasStick = false;
        if (drink.length != 2 && Integer.parseInt(sugarAmount) > 0)
            hasStick = true;

        CoffeeMachineFactory coffeeMachineFactory = new CoffeeMachineFactory();
        return coffeeMachineFactory.getResponse(drink, sugarAmount, hasStick, amount);
    }
}

class CoffeeMachineFactory {
    enum DrinkSpecificity {
        Tea(BigDecimal.valueOf(0.4)),
        Coffee(BigDecimal.valueOf(0.6)),
        Chocolate(BigDecimal.valueOf(0.5));

        private final BigDecimal price;
        DrinkSpecificity(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    public Response getResponse(String[] responseType, String sugarAmount, boolean hasStick, BigDecimal amount) {
        switch (responseType[0]) {
            case "T":
                if (amount.compareTo(DrinkSpecificity.Tea.getPrice()) >= 0 )
                    return new Tea(Integer.valueOf(sugarAmount), hasStick);
                else {
                    BigDecimal diff = DrinkSpecificity.Tea.getPrice().subtract(amount);
                    return new Message("Missing Amount: " + diff.toString());
                }
            case "C":
                if (amount.compareTo(DrinkSpecificity.Coffee.getPrice()) >= 0 )
                    return new Coffee(Integer.valueOf(sugarAmount), hasStick);
                else {
                    BigDecimal diff = DrinkSpecificity.Coffee.getPrice().subtract(amount);
                    return new Message("Missing Amount: " + diff.toString());
                }
            case "H":
                if (amount.compareTo(DrinkSpecificity.Chocolate.getPrice()) >= 0 )
                    return new Chocolate(Integer.valueOf(sugarAmount), hasStick);
                else {
                    BigDecimal diff = DrinkSpecificity.Chocolate.getPrice().subtract(amount);
                    return new Message("Missing Amount: " + diff.toString());
                }
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

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
