package currencyexchange2.persistance;

import java.util.Iterator;
import currencyexchange2.model.*;

public class CurrencyListReader implements Loader{
    
    private final Loader databaseReader = new DatabaseReader("currencies");
    
    private static final CurrencyListReader currencyListReader = new CurrencyListReader();
    
    private CurrencyListReader() {}
    
    public static CurrencyListReader getCurrencyListReaderInstance(){
        return currencyListReader;
    }
    
    
    @Override
    public Iterable<Currency> read() {
        return (Iterable<Currency>) () -> new Iterator<Currency>() {
            Iterator<String> reader = databaseReader.read().iterator();
            Currency nextCurrency = nextCurrency();
            
            
            @Override
            public boolean hasNext() {
                return nextCurrency != null;
            }
            
            @Override
            public Currency next() {
                Currency currency = nextCurrency;
                nextCurrency = nextCurrency();
                return currency;
            }
            
            private Currency nextCurrency() {
                String line;
                line = reader.next();
                if (line != null) return currencyCreator(line);
                return null;
            }
            
            private Currency currencyCreator(String line) {
                String[] splittedLine = line.split(", ");
                return new Currency(splittedLine[0], splittedLine[1], splittedLine[2]);
            }
        };
    }
    
}
