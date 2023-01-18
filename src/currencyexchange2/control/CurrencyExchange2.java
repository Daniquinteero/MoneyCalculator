package currencyexchange2.control;

import currencyexchange2.modell.CurrencyList;
import currencyexchange2.persistancee.CurrencyListReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CurrencyExchange2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        CurrencyList currencyList = new CurrencyList(CurrencyListReader.getCurrencyListReaderInstance().read());
        
        MainFrame mainFrame = new MainFrame(currencyList);
        
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay()));
        
    }
    
}
