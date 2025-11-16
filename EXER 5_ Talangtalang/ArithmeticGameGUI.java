// File: ArithmeticGameGUI_FinalLayout_LevelEnabled.java
// Language: Java (Swing)
// Description: A graphical user interface for an Arithmetic Game,
// with simplified, larger controls on the left and a new layout for the bottom panel,
// NOW INCLUDING FUNCTIONAL LEVEL SELECTION.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArithmeticGameGUI extends JFrame {

    // --- Font & Size Constants ---
    private static final Font LARGE_MATH_FONT = new Font("SansSerif", Font.BOLD, 80); 
    private static final Dimension LARGE_BOX_SIZE = new Dimension(150, 110); 

    private static final Font CONTROL_FONT = new Font("Dialog", Font.BOLD, 22); 
    private static final Font CONTROL_TITLE_FONT = new Font("Dialog", Font.BOLD, 18);
    private static final Dimension CONTROL_PANEL_SIZE = new Dimension(280, 0); 
    private static final Font SCORE_FONT = new Font("Dialog", Font.BOLD, 28); 

    // Core Components
    private JTextField answerField;
    private JLabel num1Label, operatorLabel, num2Label, countLabel, feedbackLabel;
    private JButton submitButton;
    
    // Game State
    private int correctCount = 0; 
    private int wrongCount = 0;   
    private int correctResult;
    private int maxRange = 10; // <<-- NEW: Tracks the maximum number for the current level
    private String currentOperator = "+"; 
    private Random random = new Random();

    public ArithmeticGameGUI() {
        // --- 1. Basic Frame Setup (JFrame) ---
        super("Arithmetic Game - Level Enabled");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15)); 
        
        // --- 2. Title Header ---
        JLabel headerLabel = new JLabel("Arithmetic Game Challenge", JLabel.CENTER);
        headerLabel.setFont(new Font("Inter", Font.BOLD, 28));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        // --- 3. Left Control Panel (WEST) ---
        JPanel controlsPanel = createControlsPanel();
        add(controlsPanel, BorderLayout.WEST);

        // --- 4. Main Game Area (CENTER) ---
        JPanel gameAreaPanel = createGameAreaPanel();
        add(gameAreaPanel, BorderLayout.CENTER);
        
        // --- 5. Initial Game Setup ---
        generateNewProblem();
        updateCountsDisplay(); 
        
        // --- 6. Finalizing the Frame ---
        pack(); 
        setMinimumSize(new Dimension(1000, 650)); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    // --- Helper Methods to Create Sub-Panels ---

    private JPanel createControlsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 15, 30)); 
        panel.setPreferredSize(CONTROL_PANEL_SIZE); 
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.DARK_GRAY, 2), 
            "SETTINGS", 
            0, 0, CONTROL_TITLE_FONT));
        
        // --- Operations Group ---
        JPanel operationPanel = new JPanel(new GridLayout(5, 1, 8, 8));
        operationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            "Operation Select",
            0, 0, CONTROL_TITLE_FONT));
        ButtonGroup operationGroup = new ButtonGroup();
        
        String[] ops = {"+", "-", "*", "/", "%"};
        String[] opNames = {"+ Addition", "- Subtraction", "* Multiplication", "/ Division", "% Modulo"};

        for (int i = 0; i < ops.length; i++) {
            JRadioButton opButton = new JRadioButton(opNames[i]);
            opButton.setFont(CONTROL_FONT); 
            if (ops[i].equals("+")) {
                opButton.setSelected(true);
            }
            opButton.setActionCommand(ops[i]);
            opButton.addActionListener(e -> {
                currentOperator = e.getActionCommand();
                generateNewProblem();
            });
            operationGroup.add(opButton);
            operationPanel.add(opButton);
        }
        
        // --- Level Group ---
        JPanel levelPanel = new JPanel(new GridLayout(3, 1, 8, 8)); 
        levelPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            "Level Range",
            0, 0, CONTROL_TITLE_FONT));
        ButtonGroup levelGroup = new ButtonGroup();

        String[] levels = {"Level 1 (0-10)", "Level 2 (11-100)", "Level 3 (101-999)"};
        int[] ranges = {10, 100, 999}; // Map levels to maximum values
        
        for (int i = 0; i < levels.length; i++) {
            JRadioButton levelButton = new JRadioButton(levels[i]);
            levelButton.setFont(CONTROL_FONT.deriveFont(18f)); 
            
            if (i == 0) levelButton.setSelected(true);
            
            // *** LEVEL ENABLING LOGIC ***
            final int rangeValue = ranges[i];
            levelButton.addActionListener(e -> {
                maxRange = rangeValue; // Update the maxRange state variable
                generateNewProblem(); // Generate a new problem with the new range
            });
            // ***************************
            
            levelGroup.add(levelButton);
            levelPanel.add(levelButton);
        }
        
        panel.add(operationPanel);
        panel.add(levelPanel);
        return panel;
    }

    private JPanel createGameAreaPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // --- A. Question Panel (CENTER of mainPanel) ---
        JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50)); 
        
        num1Label = createMathLabel("0", LARGE_MATH_FONT);
        operatorLabel = createMathLabel("+", LARGE_MATH_FONT);
        num2Label = createMathLabel("0", LARGE_MATH_FONT);
        JLabel equalsLabel = createMathLabel("=", LARGE_MATH_FONT);
        
        answerField = new JTextField(3);
        answerField.setFont(LARGE_MATH_FONT); 
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setPreferredSize(LARGE_BOX_SIZE); 
        answerField.addActionListener(this::checkAnswer); 
        
        questionPanel.add(num1Label);
        questionPanel.add(operatorLabel);
        questionPanel.add(num2Label);
        questionPanel.add(equalsLabel);
        questionPanel.add(answerField);
        
        mainPanel.add(questionPanel, BorderLayout.CENTER); 
        
        // --- B. Bottom Panel (SOUTH of mainPanel) ---
        JPanel bottomPanel = new JPanel(new BorderLayout(20, 10)); 
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JPanel topBottomSection = new JPanel(new BorderLayout(20, 10));

        // 1. Control Buttons (WEST)
        JPanel controlButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        
        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("Inter", Font.BOLD, 20));
        continueButton.setPreferredSize(new Dimension(160, 55));
        continueButton.setBackground(new Color(60, 179, 113)); 
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> generateNewProblem());
        controlButtonsPanel.add(continueButton);

        JButton exitButton = new JButton("EXIT GAME");
        exitButton.setFont(new Font("Inter", Font.BOLD, 20));
        exitButton.setPreferredSize(new Dimension(160, 55));
        exitButton.setBackground(new Color(220, 20, 60)); 
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0)); 
        controlButtonsPanel.add(exitButton);
        
        topBottomSection.add(controlButtonsPanel, BorderLayout.WEST);

        // 2. Submit Button (EAST)
        submitButton = new JButton("SUBMIT ANSWER");
        submitButton.setFont(new Font("Inter", Font.BOLD, 28)); 
        submitButton.setPreferredSize(new Dimension(280, 65));
        submitButton.addActionListener(this::checkAnswer); 
        
        JPanel submitWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        submitWrapper.add(submitButton);
        topBottomSection.add(submitWrapper, BorderLayout.EAST);
        
        bottomPanel.add(topBottomSection, BorderLayout.NORTH); 

        // 3. Counts Display (CENTER)
        countLabel = new JLabel("", JLabel.CENTER);
        countLabel.setFont(SCORE_FONT); 
        bottomPanel.add(countLabel, BorderLayout.CENTER); 

        // 4. Feedback label (SOUTH)
        feedbackLabel = new JLabel("Ready to play!", JLabel.CENTER);
        feedbackLabel.setFont(new Font("Inter", Font.ITALIC, 20)); 
        bottomPanel.add(feedbackLabel, BorderLayout.SOUTH); 

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }
    
    private JLabel createMathLabel(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        label.setPreferredSize(LARGE_BOX_SIZE); 
        return label;
    }

    // --- Game Logic (UPDATED) ---

    private void generateNewProblem() {
        // Calculate the starting point of the range (1 for 0-10, 11 for 11-100, etc.)
        int minRange = maxRange > 10 ? (maxRange / 10) + 1 : 1;
        
        // Generate numbers within the current maxRange
        int num1 = random.nextInt(maxRange - minRange + 1) + minRange; 
        int num2 = random.nextInt(maxRange - minRange + 1) + minRange;
        
        // Handle division and modulo: Ensure num2 is a factor of num1, and num2 > 0
        if (currentOperator.equals("/") || currentOperator.equals("%")) {
            // Ensure num2 is not zero and creates an integer result
            if (num2 == 0) num2 = 1;
            // Recalculate num1 to be a multiple of num2 within the range
            int maxFactor = (maxRange / num2) - 1;
            if (maxFactor < 1) maxFactor = 1; // Prevent issues for large num2
            num1 = num2 * (random.nextInt(maxFactor) + 1); 
        }

        // Handle subtraction: Ensure result is non-negative
        if (currentOperator.equals("-") && num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        num1Label.setText(String.valueOf(num1));
        operatorLabel.setText(currentOperator);
        num2Label.setText(String.valueOf(num2));

        switch (currentOperator) {
            case "+": correctResult = num1 + num2; break;
            case "-": correctResult = num1 - num2; break;
            case "*": correctResult = num1 * num2; break;
            case "/": correctResult = num1 / num2; break;
            case "%": correctResult = num1 % num2; break;
            default: correctResult = 0; break;
        }

        answerField.setText("");
        feedbackLabel.setForeground(Color.GRAY);
        feedbackLabel.setText("Solve the problem!");
        answerField.requestFocusInWindow();
    }
    
    private void updateCountsDisplay() {
        countLabel.setText(String.format(
            "<html><div style='text-align: center;'><b>Correct:</b> <font color='green'>%d</font> | <b>Wrong:</b> <font color='red'>%d</font></div></html>", 
            correctCount, wrongCount));
    }

    private void checkAnswer(ActionEvent e) {
        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            
            if (userAnswer == correctResult) {
                correctCount++; 
                feedbackLabel.setForeground(new Color(0, 100, 0)); 
                feedbackLabel.setText("🎉 CONGRATULATIONS! Correct! 🎉");
            } else {
                wrongCount++; 
                feedbackLabel.setForeground(new Color(220, 20, 60)); 
                feedbackLabel.setText("Incorrect. The correct answer was " + correctResult);
            }
            
            updateCountsDisplay(); 

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    generateNewProblem();
                    ((Timer)evt.getSource()).stop(); 
                }
            });
            timer.setRepeats(false);
            timer.start();
            
        } catch (NumberFormatException ex) {
            feedbackLabel.setForeground(Color.ORANGE);
            feedbackLabel.setText("Please enter a valid number.");
            answerField.setText("");
        }
    }

    // --- Main Entry Point ---

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArithmeticGameGUI();
        });
    }
}