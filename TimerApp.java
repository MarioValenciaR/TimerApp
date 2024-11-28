import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Timer application using Swing, using "Start" and "Stop" buttons.
 * Author: Mario Valencia
 * Date: November 2024
 */
public class TimerApp {

    private long startTimestamp; // Stores the time when the Start button is clicked
    private long stopTimestamp;  // Stores the time when the Stop button is clicked

    /**
     * The main method to launch the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimerApp().initializeAndDisplayGUI());
    }

    /**
     * Initializes and displays the graphical user interface for the timer application.
     */
    public void initializeAndDisplayGUI() {
        // Create the main application window
        JFrame mainFrame = new JFrame("Elapsed Time Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for "Start" and "Stop"
        JButton startButton = new JButton("Start Timer");
        JButton stopButton = new JButton("Stop Timer");

        // Action listener for the "Start Timer" button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimestamp = System.currentTimeMillis(); // Record the start time in milliseconds
                JOptionPane.showMessageDialog(mainFrame, "Start time recorded!"); // Notify the user
            }
        });

        // Action listener for the "Stop Timer" button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTimestamp == 0) { // Ensure the "Start Timer" button was clicked first
                    JOptionPane.showMessageDialog(mainFrame, "Please click 'Start Timer' before 'Stop Timer'.");
                    return;
                }
                stopTimestamp = System.currentTimeMillis(); // Record the stop time in milliseconds
                long elapsedMilliseconds = stopTimestamp - startTimestamp; // Calculate the elapsed time
                JOptionPane.showMessageDialog(mainFrame, "Elapsed time: " + elapsedMilliseconds + " ms"); // Show result
            }
        });

        // Create a panel and add buttons to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        // Add the panel to the main application frame
        mainFrame.add(buttonPanel);
        mainFrame.setSize(400, 200); // window size
        mainFrame.setVisible(true);  // Make the window visible
    }
}
