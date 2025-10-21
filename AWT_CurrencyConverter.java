import java.awt.*;
import java.awt.event.*;

public class AWT_CurrencyConverter extends Frame implements ActionListener {

    Label amountLabel, fromLabel, toLabel, resultLabel;
    TextField amountField;
    Choice fromCurrency, toCurrency;
    Button convertButton;

    // Exchange rates (example values)
    final double USD_TO_INR = 83.12;
    final double EUR_TO_INR = 90.34;
    final double GBP_TO_INR = 105.58;

    public AWT_CurrencyConverter() {
        // Frame setup
        setTitle("Currency Converter (AWT)");
        setSize(400, 250);
        setLayout(null);
        setBackground(new Color(230, 240, 255));

        // Labels
        amountLabel = new Label("Enter Amount:");
        amountLabel.setBounds(50, 60, 100, 30);
        add(amountLabel);

        fromLabel = new Label("From:");
        fromLabel.setBounds(50, 100, 100, 30);
        add(fromLabel);

        toLabel = new Label("To:");
        toLabel.setBounds(50, 140, 100, 30);
        add(toLabel);

        // Text field
        amountField = new TextField();
        amountField.setBounds(170, 60, 150, 25);
        add(amountField);

        // Choices (like dropdown)
        fromCurrency = new Choice();
        fromCurrency.add("INR");
        fromCurrency.add("USD");
        fromCurrency.add("EUR");
        fromCurrency.add("GBP");
        fromCurrency.setBounds(170, 100, 100, 25);
        add(fromCurrency);

        toCurrency = new Choice();
        toCurrency.add("INR");
        toCurrency.add("USD");
        toCurrency.add("EUR");
        toCurrency.add("GBP");
        toCurrency.setBounds(170, 140, 100, 25);
        add(toCurrency);

        // Button
        convertButton = new Button("Convert");
        convertButton.setBounds(150, 180, 80, 30);
        add(convertButton);

        // Result label
        resultLabel = new Label("Result: ");
        resultLabel.setBounds(250, 180, 150, 30);
        add(resultLabel);

        // Add Action Listener
        convertButton.addActionListener(this);

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getSelectedItem();
            String to = toCurrency.getSelectedItem();

            double inINR = 0.0, converted = 0.0;

            // Convert from source currency to INR
            switch (from) {
                case "USD":
                    inINR = amount * USD_TO_INR;
                    break;
                case "EUR":
                    inINR = amount * EUR_TO_INR;
                    break;
                case "GBP":
                    inINR = amount * GBP_TO_INR;
                    break;
                default:
                    inINR = amount; // INR
            }

            // Convert INR to target currency
            switch (to) {
                case "USD":
                    converted = inINR / USD_TO_INR;
                    break;
                case "EUR":
                    converted = inINR / EUR_TO_INR;
                    break;
                case "GBP":
                    converted = inINR / GBP_TO_INR;
                    break;
                default:
                    converted = inINR; // INR
            }

            resultLabel.setText(String.format("Result: %.2f %s", converted, to));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid amount!");
        }
    }

    public static void main(String[] args) {
        new AWT_CurrencyConverter();
    }

}