package currencyexchange2.persistancee;

import com.google.gson.Gson;
import currencyexchange2.vieww.ExchangeBoardPojo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static java.util.stream.Collectors.joining;

public class Webservice {
    public static double getRateFromWebservice(String sellCurrency, String buyCurrency) throws IOException{
        String url = "https://api.exchangerate.host/convert?from=" + sellCurrency + "&to=" + buyCurrency;
        String json = read(url);
        Gson gson = new Gson();
        ExchangeBoardPojo exchangeBoard = gson.fromJson(json, ExchangeBoardPojo.class);
        return exchangeBoard.info.rate;
    }
    
    private static String read(String url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(joining(" "));
        }
    }
}
