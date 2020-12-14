package au.com.nig.coffemachine;

public class CoffeeMachine {
    public String order(String input) {
        String[] drink = input.split(":");

        if (drink[0].equals("T"))
            return "Tea";
        else if (drink[0].equals("C"))
            return "Coffee";
        else if (drink[0].equals("H"))
            return "Chocolate";
        else
            return drink[1];
    }
}
