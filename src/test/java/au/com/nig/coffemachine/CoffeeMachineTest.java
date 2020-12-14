package au.com.nig.coffemachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMachineTest {
    @Test
    public void shouldReceiveCorrectInstructionToMakeTea(){
        // Given
        String input = "T:1:0";

        // When
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String result = coffeeMachine.order(input);

        // Then
        assertEquals("Tea", result);
    }

    @Test
    public void shouldReceiveCorrectInstructionToMakeChocolate(){
        // Given
        String input = "H::";

        // When
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String result = coffeeMachine.order(input);

        // Then
        assertEquals("Chocolate", result);
    }

    @Test
    public void shouldReceiveCorrectInstructionToMakeCoffee(){
        // Given
        String input = "C:2:0";

        // When
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String result = coffeeMachine.order(input);

        // Then
        assertEquals("Coffee", result);
    }

    @Test
    @DisplayName("return the given message")
    public void shouldReceiveMessageAndReturnMessage(){
        // Given
        String input = "M:Messages";

        // When
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String result = coffeeMachine.order(input);

        // Then
        assertEquals("Messages", result);
    }
}

//    The drink maker receives string commands from your code to make the drinks. It can also deliver info messages to the customer if ordered so. The instructions it receives follow this format:
//
//        "T:1:0" (Drink maker makes 1 tea with 1 sugar and a stick)
//        "H::" (Drink maker makes 1 chocolate with no sugar -
//        and therefore no stick)
//        "C:2:0" (Drink maker makes 1 coffee with 2 sugars and a stick)
//        "M:message-content" (Drink maker forwards any message received
//        onto the coffee machine interface
//				for the customer to see)
