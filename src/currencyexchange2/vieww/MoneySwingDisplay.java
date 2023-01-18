package currencyexchange2.vieww;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneySwingDisplay extends JPanel implements MoneyDisplay {

    public JTextField buyAmount;
    
    public MoneySwingDisplay() {
        setLayout(new FlowLayout());
        this.add(buyAmount());
    }
    
    @Override
    public void display(double amount){
        buyAmount.setText(Double.toString(amount));
        this.updateUI();
    }
    
    

    private Component buyAmount() {
        this.add(new JLabel("Output:"));
        buyAmount = new JTextField("0.00");
        buyAmount.setColumns(10);
        buyAmount.setEditable(false);
        return buyAmount;
    }


    
}
