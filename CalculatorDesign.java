//CalculatorDesign.java [VIEW]
import javax.swing.*;
import java.awt.*;

public class CalculatorDesign extends JFrame {
    JTextField displayField;
    JButton[] numberButtons;
    JButton[] operatorButtons;
    JButton clearButton, equalsButton;
    JPanel numberPanel, operatorPanel;

    public CalculatorDesign() {
        //"View" creates the interface and displays information
        setTitle("Creative Calculator");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Display field at the top
        displayField = new JTextField();
        displayField.setFont(new Font("Roboto", Font.ITALIC, 32));
        displayField.setEditable(false);
        displayField.setBackground(Color.BLACK);
        displayField.setForeground(new Color (204, 255, 0));
        displayField.setPreferredSize(new Dimension(900, 100));
        add(displayField, BorderLayout.NORTH);
        
        //Panel for numbers and operators
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        
        //Number panel with grid Layout
        JPanel numberPanel = new JPanel(new GridLayout(4, 3, 5, 5)); // 4 rows, 3 columns
        numberPanel.setBackground(Color.DARK_GRAY);
        mainPanel.add(numberPanel, BorderLayout.CENTER); //Adding to main panel

        // Number buttons with customised colors
        numberButtons = new JButton[10];
        Color[] customColors = {
            new Color(255, 190, 163), // 0
            new Color(236, 114, 114),  // 1
            new Color(171, 147, 201),   // 2
            new Color(117, 121, 231), // 3
            new Color(247, 167, 108), // 4
            new Color(214, 152, 185),   // 5
            new Color(154, 179, 245), // 6
            new Color(224, 217, 140), // 7
            new Color(237, 161, 171),  // 8
            new Color(163, 216, 244),  // 9
        };

        for (int i = 1; i < 10; i++) { //Add numbers 1-9
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 42));
            numberButtons[i].setBackground(customColors[i]); // Set independent color for each button
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBorderPainted(false);
            numberPanel.add(numberButtons[i]);
        }
        
        //Add Clear (CLR) button below 7
        clearButton = new JButton("CLR");
        clearButton.setFont(new Font("Times New Roman", Font.ITALIC, 56));
        clearButton.setBackground(new Color(0, 106, 103));
        clearButton.setForeground(new Color(255, 244, 183));
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);
        numberPanel.add(clearButton);

        //Add number 0 below 8
        numberButtons[0] = new JButton("0");
        numberButtons[0].setFont(new Font("Arial", Font.BOLD, 42));
        numberButtons[0].setBackground(customColors[0]); // Set independent color for each button
        numberButtons[0].setForeground(Color.BLACK);
        numberButtons[0].setOpaque(true);
        numberButtons[0].setBorderPainted(false);
        numberPanel.add(numberButtons[0]);
        
        //Add equals button
        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Times New Roman", Font.BOLD, 70));
        equalsButton.setBackground(new Color(180, 254, 152)); // Set independent color for each button
        equalsButton.setForeground(new Color(105, 36, 124));
        equalsButton.setOpaque(true);
        equalsButton.setBorderPainted(false);
        numberPanel.add(equalsButton);
        
        //To create a space between number panel and operator panel (vertical gap)
        JPanel verticalGapPanel = new JPanel(); //Empty panel to create space
        verticalGapPanel.setPreferredSize(new Dimension(20, 30)); //Vertical gap size
        mainPanel.add(verticalGapPanel, BorderLayout.SOUTH); //Adding vertical panel to main panel
        
        
        //Operator panel with grid layout
        operatorPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // 4 rows, 1 column
        operatorPanel.setBackground(Color.DARK_GRAY);
        mainPanel.add(operatorPanel, BorderLayout.EAST); //Adding operator panel to main panel
        
        //Operator buttons with colors
        String[] operators = {"+", "-", "*", "/"};
        operatorButtons = new JButton[operators.length];
        Color[] operatorColors = {
            new Color(0, 121, 255), // +
            new Color(0, 223, 162), // -
            new Color(249, 228, 0), // *
            new Color(255, 0, 96) // /  
        };
        
        // Operator buttons
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setFont(new Font("Georgia", Font.ITALIC, 50));
            operatorButtons[i].setBackground(operatorColors[i]);
            operatorButtons[i].setForeground(Color.WHITE);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setBorderPainted(false);
            operatorPanel.add(operatorButtons[i]);
        }
        
        //To make sure the frame is Visible
        setVisible(true);
    }
    public static void main(String[] args) {
        new CalculatorDesign();
    }
}
