package java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RGBColorChooser extends JFrame {
    private JComboBox<Integer> redBox, greenBox, blueBox;
    private JPanel colorPanel;

    public RGBColorChooser() {
        setTitle("My Frame");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        JLabel redLabel = new JLabel("Red");
        JLabel greenLabel = new JLabel("Green");
        JLabel blueLabel = new JLabel("Blue");
        
        redBox = createColorComboBox();
        greenBox = createColorComboBox();
        blueBox = createColorComboBox();
        
        JButton showButton = new JButton("Show Output");
        showButton.addActionListener(new ColorChanger());
        
        controlPanel.add(redLabel);
        controlPanel.add(redBox);
        controlPanel.add(greenLabel);
        controlPanel.add(greenBox);
        controlPanel.add(blueLabel);
        controlPanel.add(blueBox);
        controlPanel.add(showButton);
        
        colorPanel = new JPanel();
        colorPanel.setBackground(new Color(255, 255, 255));
        
        add(controlPanel, BorderLayout.NORTH);
        add(colorPanel, BorderLayout.CENTER);
    }

    private JComboBox<Integer> createColorComboBox() {
        JComboBox<Integer> comboBox = new JComboBox<>();
        for (int i = 0; i <= 255; i++) {
            comboBox.addItem(i);
        }
        return comboBox;
    }

    private class ColorChanger implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int red = (int) redBox.getSelectedItem();
            int green = (int) greenBox.getSelectedItem();
            int blue = (int) blueBox.getSelectedItem();
            colorPanel.setBackground(new Color(red, green, blue));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RGBColorChooser().setVisible(true));
        System.out.println("hello");
    }
}
