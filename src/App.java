
public class App {
    public static void main(String[] args) throws Exception {
        TemperatureConverter converter = new TemperatureConverter();
        System.out.println(converter.celsiusToFahrenheit(100));
        System.out.println(converter.fahrenheitToCelsius(-40));
    }
}
