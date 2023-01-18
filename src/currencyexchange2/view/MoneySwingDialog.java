package currencyexchange2.view;

import currencyexchange2.model.Currency;
import currencyexchange2.model.CurrencyList;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneySwingDialog extends JPanel {
    
    private final CurrencyList currencyList;
    public JTextField sellAmount;
    public JComboBox sellCurrency;
    public JComboBox buyCurrency;
    
    
    public MoneySwingDialog(CurrencyList currencyList){
        setLayout(new FlowLayout());
        this.currencyList = currencyList;
        this.add(sellCurrency());
        this.add(sellAmount());
        this.add(buyCurrency());
        

    }

    private Component sellAmount() {
        this.add(new JLabel("Amount:"));
        sellAmount = new JTextField("0.00");
        sellAmount.setColumns(10);
        return sellAmount;
    }

    private Component sellCurrency() {
        this.add(new JLabel("From:"));
        sellCurrency = new JComboBox();
        for (Currency currency : currencyList.getCurrencyList()) {
            sellCurrency.addItem(currency.getType());
        }
        
        return sellCurrency;
    }

    private Component buyCurrency() {
        this.add(new JLabel("To:"));
        buyCurrency = new JComboBox();
        for (Currency currency : currencyList.getCurrencyList()) {
            buyCurrency.addItem(currency.getType());
        }
        
        return buyCurrency;
    }
    
   
}
