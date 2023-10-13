import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    String model = "Civic";

    @Test
    public void testCelciusSameAsFahrenheit() {
        System.out.println("Testando -40 Celsius para Fahrenheit");
        Assertions.assertEquals(converter.celsiusToFahrenheit(-40), -40,
                "Esperava que fossem iguais quando um deles eh -40");
    }

    @Test
    public void testZero() {
        System.out.println("Testando 0 Celsius para Fahrenheit");
        Assertions.assertEquals(converter.celsiusToFahrenheit(0), 32,
                "Esperava que Fahrenheit seja 32 quando Celsius eh 0");
    }

    @Test
    public void testHundred() {
        System.out.println("Testando 100 Celsius para Fahrenheit");
        Assertions.assertEquals(converter.celsiusToFahrenheit(100), 212,
                "Esperava que Fahrenheit seja 212 quando Celsius eh 100");
    }

}
