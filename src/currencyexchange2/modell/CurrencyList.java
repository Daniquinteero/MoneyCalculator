package currencyexchange2.modell;

public class CurrencyList {
    
    private final Iterable<Currency> currencyList;
    
    public CurrencyList(Iterable<Currency> currencyList){
        this.currencyList = currencyList;
    }
    
    public Iterable<Currency> getCurrencyList() {
        return currencyList;
    }
    
    public Currency getCurrency(String type){
        for (Currency currency : currencyList) {
            if (currency.getType().equals(type)) return currency;
        }
        return null;
    }
}
