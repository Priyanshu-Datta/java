package java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame {
    private JTextField nameField, mobileField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> dayBox, monthBox, yearBox;
    private JTextArea addressArea;
    private JCheckBox termsCheckBox;
    private JButton submitButton, resetButton;

    public StudentRegistrationForm() {
        setTitle("Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        addLabel("Name", 1);
        nameField = addTextField(1);
        
        addLabel("Mobile", 2);
        mobileField = addTextField(2);
        
        addLabel("Gender", 3);
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        gbc.gridx = 1; gbc.gridy = 3;
        add(maleButton, gbc);
        gbc.gridx = 2;
        add(femaleButton, gbc);
        
        addLabel("DOB", 4);
        dayBox = new JComboBox<>(generateNumbers(1, 31));
        monthBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        yearBox = new JComboBox<>(generateNumbers(1900, 2023));
        gbc.gridx = 1; gbc.gridy = 4;
        add(dayBox, gbc);
        gbc.gridx = 2;
        add(monthBox, gbc);
        gbc.gridx = 3;
        add(yearBox, gbc);
        
        addLabel("Address", 5);
        addressArea = new JTextArea(3, 20);
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2;
        add(new JScrollPane(addressArea), gbc);
        
        termsCheckBox = new JCheckBox("Accept Terms And Conditions.");
        gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 2;
        add(termsCheckBox, gbc);
        
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        submitButton.addActionListener(new SubmitAction());
        resetButton.addActionListener(e -> resetForm());
        
        gbc.gridx = 1; gbc.gridy = 7; gbc.gridwidth = 1;
        add(submitButton, gbc);
        gbc.gridx = 2;
        add(resetButton, gbc);
    }

    private void addLabel(String text, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = row; gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel(text), gbc);
    }

    private JTextField addTextField(int row) {
        JTextField field = new JTextField(15);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = row;
        add(field, gbc);
        return field;
    }
    
    private String[] generateNumbers(int start, int end) {
        String[] numbers = new String[end - start + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(start + i);
        }
        return numbers;
    }
    
    private class SubmitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!termsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept the terms and conditions.");
                return;
            }
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not Selected";
            String dob = dayBox.getSelectedItem() + " " + monthBox.getSelectedItem() + " " + yearBox.getSelectedItem();
            String message = "Name: " + nameField.getText() + "\n" +
                             "Mobile: " + mobileField.getText() + "\n" +
                             "Gender: " + gender + "\n" +
                             "DOB: " + dob + "\n" +
                             "Address: " + addressArea.getText();
            JOptionPane.showMessageDialog(null, message, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void resetForm() {
        nameField.setText("");
        mobileField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
        dayBox.setSelectedIndex(0);
        monthBox.setSelectedIndex(0);
        yearBox.setSelectedIndex(0);
        addressArea.setText("");
        termsCheckBox.setSelected(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm().setVisible(true));
    }
}
