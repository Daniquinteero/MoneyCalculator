package currencyexchange2.model;


public class Currency {
    private final String type;
    private final String description;
    private final String symbol;

    public Currency(String type, String description, String symbol) {
        this.type = type;
        this.description = description;
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString(){
        return this.type + this.description + this.symbol;
    }
}
