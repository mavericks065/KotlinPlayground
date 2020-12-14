package au.com.nig.coffemachine;

public class CoffeeMachine {
    public String order(String input) {
        if (input.startsWith("T"))
            return "Tea";
        else if (input.startsWith("C"))
            return "Coffee";
        else return "Chocolate";
    }
}
