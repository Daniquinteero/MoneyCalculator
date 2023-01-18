package currencyexchange2;

import currencyexchange2.persistance.CurrencyListReader;
import currencyexchange2.model.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CurrencyExchange2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        CurrencyList currencyList = new CurrencyList(CurrencyListReader.getCurrencyListReaderInstance().read());
        
        MainFrame mainFrame = new MainFrame(currencyList);
        
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay()));
        
    }
    
}
