package au.com.nig.coffemachine;

import java.math.BigDecimal;

public class CoffeeMachineFactory {
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

    public Response getDrink(String[] responseType, String sugarAmount, boolean hasStick, BigDecimal amount) {
        switch (responseType[0]) {
            case "T":
                return new Tea(Integer.valueOf(sugarAmount), hasStick);
            case "C":
                return new Coffee(Integer.valueOf(sugarAmount), hasStick);
            case "H":
                return new Chocolate(Integer.valueOf(sugarAmount), hasStick);
            default:
                return new Message(responseType[1]);
        }
    }
}
