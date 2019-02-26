package coffee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        // Deciphering coffee.Espresso Drinks: https://www.thespruceeats.com/deciphering-local-coffeehouse-espresso-menu-765323
        //// coffee.Espresso
        Coffee espresso = new Espresso();
        System.out.println(toString(espresso));
        // {"name":"coffee.Espresso","content":"espresso","price":50}
        //// American
        Coffee americano = new Americano(espresso);
        System.out.println(toString(americano));
        // {"name":"coffee.Americano","content":"espresso + water","price":50}
        //// coffee.Latte
        Coffee latte = new Latte(espresso);
        System.out.println(toString(latte));
        // {"name":"coffee.Latte","content":"espresso + steamed milk + foam","price":70}
        //// coffee.Mocha
        Coffee mocha = new Mocha(latte);
        System.out.println(toString(mocha));
        // {"name":"coffee.Mocha","content":"espresso + steamed milk + foam + chocolate","price":75}
    }

    public static String toString(Object object) {
        if (object != null) {
            try {
                return objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
