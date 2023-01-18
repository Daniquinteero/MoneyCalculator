package currencyexchange2.control;

import currencyexchange2.view.Rate;
import currencyexchange2.view.MoneyDisplay;
import currencyexchange2.view.MoneySwingDialog;
import currencyexchange2.view.MoneySwingDisplay;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculateCommand implements Command {

    private final MoneySwingDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private Rate rate = new Rate();

    public CalculateCommand(MoneySwingDialog moneyDialog, MoneySwingDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
    }
    
    @Override
    public String name() {
        return "Calculate";
    }

    @Override
    public void execute() {
        
        double exchangeRate;
        try {
            exchangeRate = rate.getRate(moneyDialog.sellCurrency.getSelectedItem().toString(), moneyDialog.buyCurrency.getSelectedItem().toString()); //moneyDisplay.display(moneyDialog.get());
            double calculation = exchangeRate * Double.parseDouble(moneyDialog.sellAmount.getText());
            moneyDisplay.display(calculation);
        } catch (IOException ex) {
            Logger.getLogger(CalculateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
