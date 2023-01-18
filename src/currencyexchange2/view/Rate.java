package currencyexchange2.view;

import currencyexchange2.persistance.Webservice;
import java.io.IOException;

public class Rate {
    
    public double getRate(String sellCurrency, String buyCurrency) throws IOException{
        return Webservice.getRateFromWebservice(sellCurrency, buyCurrency);
    }
    

}
