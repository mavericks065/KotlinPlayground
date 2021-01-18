package au.com.nig.coffemachine;

import au.com.nig.coffemachine.CoffeeMachineFactory.DrinkSpecificity;

import java.math.BigDecimal;

public class CoffeeMachine {
    private final CoffeeMachineFactory coffeeMachineFactory = new CoffeeMachineFactory();

    public Response order(String input, BigDecimal amount) {
        String[] drink = input.split(":");

        String sugarAmount = drink.length == 1 ? String.valueOf(0) : drink[1];

        boolean hasStick = false;
        if (drink.length != 2 && Integer.parseInt(sugarAmount) > 0)
            hasStick = true;

        Response response = coffeeMachineFactory.getDrink(drink, sugarAmount, hasStick, amount);

        if (response instanceof Message)
            return response;
        else {
            return validateDrinkAmount(amount, response);
        }
    }

    private Response validateDrinkAmount(BigDecimal amount, Response response) {
        if ((response instanceof Coffee)
                && amount.compareTo(DrinkSpecificity.Coffee.getPrice()) < 0)
            return new Message("Missing Amount: " + DrinkSpecificity.Coffee.getPrice().subtract(amount));
        else if ((response instanceof Tea)
                && amount.compareTo(DrinkSpecificity.Tea.getPrice()) < 0)
            return new Message("Missing Amount: " + DrinkSpecificity.Tea.getPrice().subtract(amount));
        else if ((response instanceof Chocolate)
                && amount.compareTo(DrinkSpecificity.Chocolate.getPrice()) < 0)
            return new Message("Missing Amount: " + DrinkSpecificity.Chocolate.getPrice().subtract(amount));
        else
            return response;
    }
}
