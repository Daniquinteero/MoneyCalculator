package currencyexchange2.vieww;

import currencyexchange2.persistancee.Webservice;
import java.io.IOException;

public class Rate {
    
    public double getRate(String sellCurrency, String buyCurrency) throws IOException{
        return Webservice.getRateFromWebservice(sellCurrency, buyCurrency);
    }
    

}
