import com.google.gson.JsonObject;
import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateService service = new ExchangeRateService();

    public double convert(String fromCurrency, String toCurrency, double amount)
            throws IOException, InterruptedException {
        JsonObject json = service.getRates(fromCurrency);
        JsonObject rates = json.getAsJsonObject("conversion_rates");

        double rate = rates.get(toCurrency).getAsDouble();
        return amount * rate;
    }
}
