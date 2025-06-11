import javax.swing.*;

public class GFG {
    // main function
    public static void main(String[] args) {
        // Welcome Screen
        // JOptionPane.showMessageDialog(null, "Welcome to 42Calculator");

        // New GUI Calculator Window
        JFrame frame = new JFrame("42Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add padding around the main panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Create a vertical panel to hold the two horizontal rows
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // First row: labels
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
        labelPanel.add(new JLabel("Operand 1:"));
        labelPanel.add(Box.createHorizontalStrut(30));
        labelPanel.add(new JLabel("Operator:"));
        labelPanel.add(Box.createHorizontalStrut(30));
        labelPanel.add(new JLabel("Operand 2:"));

        // Second row: input fields
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.X_AXIS));
        JTextField operand1Field = new JTextField(6);
        String[] operators = {"+", "-", "*", "/", "%"};
        JComboBox<String> operatorBox = new JComboBox<>(operators);
        JTextField operand2Field = new JTextField(6);
        fieldsPanel.add(operand1Field);
        fieldsPanel.add(Box.createHorizontalStrut(30));
        fieldsPanel.add(operatorBox);
        fieldsPanel.add(Box.createHorizontalStrut(30));
        fieldsPanel.add(operand2Field);

        // Add both rows to the inputPanel
        inputPanel.add(labelPanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(fieldsPanel);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);
        resultPanel.add(new JLabel("Result: "));
        resultPanel.add(resultField);

        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(e -> {
            try {
                double op1 = Double.parseDouble(operand1Field.getText().trim());
                double op2 = Double.parseDouble(operand2Field.getText().trim());
                String op = (String) operatorBox.getSelectedItem();
                double res = 0;
                if ((op.equals("/") || op.equals("%")) && op2 == 0) {
                    resultField.setText("Division by 0 is not allowed");
                    return;
                }
                switch (op) {
                    case "+": res = op1 + op2; break;
                    case "-": res = op1 - op2; break;
                    case "*": res = op1 * op2; break;
                    case "/": res = op1 / op2; break;
                    case "%": res = op1 % op2; break;
                }
                resultField.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        calcButton.setAlignmentX(Box.CENTER_ALIGNMENT);
        panel.add(calcButton);
        panel.add(Box.createVerticalStrut(20)); // Less space at the top
        panel.add(inputPanel);
        panel.add(Box.createVerticalStrut(20)); // Less space between input and button
        panel.add(Box.createVerticalStrut(15)); // Less space between button and result
        panel.add(resultPanel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
