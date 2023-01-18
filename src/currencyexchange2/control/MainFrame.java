package currencyexchange2.control;

import currencyexchange2.model.CurrencyList;
import currencyexchange2.view.MoneySwingDialog;
import currencyexchange2.view.MoneySwingDisplay;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    private Map<String,Command> commands = new HashMap<>();
    private final CurrencyList currencyList;
    private MoneySwingDialog moneyDialog;
    private MoneySwingDisplay moneyDisplay;
    
    
    
    public MainFrame(CurrencyList currencyList){
        this.currencyList = currencyList;
        setLayout(new FlowLayout());
        this.setTitle("Money Calculator");
        this.setSize(500, 130);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog());
        this.add(calculateButton());
        this.add(moneyDisplay());
        this.setVisible(true);
    }
    
    public void add(Command command){
        commands.put(command.name(), command);
    }

    public MoneySwingDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneySwingDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    private JPanel moneyDialog(){
        MoneySwingDialog dialog = new MoneySwingDialog(currencyList);
        moneyDialog = dialog;
        return dialog;
    }
        
    private JPanel moneyDisplay(){
        MoneySwingDisplay display = new MoneySwingDisplay();
        moneyDisplay = display;
        return display;
    }
    
    private Component calculateButton(){
        JButton button = new JButton("calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }
    
}
