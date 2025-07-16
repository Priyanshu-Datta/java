package java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stopwatch extends JFrame {
    private JLabel hourLabel, minLabel, secLabel, milliLabel;
    private JButton startButton, stopButton, resetButton;
    private boolean running = false;
    private long startTime, elapsedTime;
    private Timer timer;

    public stopwatch() {
        setTitle("Stopwatch");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        JPanel displayPanel = new JPanel();
        hourLabel = new JLabel("00");
        minLabel = new JLabel("00");
        secLabel = new JLabel("00");
        milliLabel = new JLabel("000");
        
        displayPanel.add(new JLabel("Hours:"));
        displayPanel.add(hourLabel);
        displayPanel.add(new JLabel("Minutes:"));
        displayPanel.add(minLabel);
        displayPanel.add(new JLabel("Seconds:"));
        displayPanel.add(secLabel);
        displayPanel.add(new JLabel("Milliseconds:"));
        displayPanel.add(milliLabel);
        
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        
        add(displayPanel);
        add(buttonPanel);
        
        startButton.addActionListener(new StartAction());
        stopButton.addActionListener(new StopAction());
        resetButton.addActionListener(new ResetAction());
        
        timer = new Timer(1, new TimerListener());
    }

    private class StartAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!running) {
                running = true;
                startTime = System.currentTimeMillis() - elapsedTime;
                timer.start();
            }
        }
    }

    private class StopAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            running = false;
            elapsedTime = System.currentTimeMillis() - startTime;
            timer.stop();
        }
    }

    private class ResetAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            running = false;
            timer.stop();
            elapsedTime = 0;
            updateLabels(0);
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            long timePassed = System.currentTimeMillis() - startTime;
            updateLabels(timePassed);
        }
    }

    private void updateLabels(long time) {
        int millis = (int) (time % 1000);
        int seconds = (int) (time / 1000) % 60;
        int minutes = (int) ((time / 1000) / 60) % 60;
        int hours = (int) (((time / 1000) / 60) / 60);
        
        hourLabel.setText(String.format("%02d", hours));
        minLabel.setText(String.format("%02d", minutes));
        secLabel.setText(String.format("%02d", seconds));
        milliLabel.setText(String.format("%03d", millis));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new stopwatch().setVisible(true);
        });
    }
}
