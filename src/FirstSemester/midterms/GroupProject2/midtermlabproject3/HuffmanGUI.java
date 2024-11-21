package midtermlabproject3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * A graphical user interface (GUI) for Huffman Coding that allows users to encode text into Huffman codes
 * and decode Huffman codes back into text.
 *
 * The application includes two main operations:
 * <ul>
 *     <li>Encoding text into Huffman code</li>
 *     <li>Decoding Huffman code back into text</li>
 * </ul>
 * Users interact with the application through a simple and intuitive interface.
 * This GUI is built using the Swing framework and integrates with the HuffmanCoding class for encoding and decoding operations.
 */
public class HuffmanGUI extends JFrame {
    private static final Font font = new Font("Times New Roman", Font.BOLD, 16);

    private JPanel menuPanel;

    private JFrame choiceOneFrame;
    private HuffmanCoding huffmanCoding;
    /**
     * Constructor for the HuffmanGUI class.
     * Sets up the main GUI window with a menu panel for user interaction.
     */
    public HuffmanGUI() {
        setTitle("Huffman Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        menuPanel = setMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    /**
     * Creates the main menu panel with buttons for encoding, decoding, and exiting the application.
     *
     * @return The menu panel as a JPanel.
     */
    private JPanel setMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));  // Vertically align buttons
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create buttons for each choice
        JButton encodeButton = new JButton("Encode text to Huffman code");
        JButton decodeButton = new JButton("Decode Huffman code to text");
        JButton exitButton = new JButton("Exit");

        // Make buttons the same size
        encodeButton.setPreferredSize(new Dimension(250, 50));
        decodeButton.setPreferredSize(new Dimension(250, 50));
        exitButton.setPreferredSize(new Dimension(250, 50));

        // Action listeners for each button
        encodeButton.addActionListener(e -> {
            choiceOneFrame();
        });

        decodeButton.addActionListener(e -> {
            choiceTwoFrame();
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Create a container panel for the buttons to center them
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the buttons
        buttonPanel.add(encodeButton);
        buttonPanel.add(decodeButton);
        buttonPanel.add(exitButton);

        menuPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing between the label and buttons
        menuPanel.add(buttonPanel); // Add the button container panel

        return menuPanel;
    }
    /**
     * Opens the encoding frame where users can input text to encode into Huffman code.
     * Displays the Huffman tree structure, encoded text, and memory savings.
     */
    private void choiceOneFrame() {
        this.setVisible(false);

        choiceOneFrame = new JFrame("Huffman Encode");
        choiceOneFrame.setSize(800, 600);
        choiceOneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        choiceOneFrame.setResizable(false);

        JPanel encodePanel = new JPanel();
        encodePanel.setLayout(new GridBagLayout());

        // Set a preferred size for the JTabbedPane
        JTabbedPane codesAndTree = new JTabbedPane();
        codesAndTree.setPreferredSize(new Dimension(300, 200)); // Adjust the size as needed

        JTextArea treeStructureArea = new JTextArea(10, 30);
        treeStructureArea.setEditable(false);
        treeStructureArea.setLineWrap(true);
        treeStructureArea.setWrapStyleWord(true);
        JScrollPane treeScrollPane = new JScrollPane(treeStructureArea);
        codesAndTree.addTab("Tree Structure", treeScrollPane);

        JTable frequencyTable = new JTable();
        JScrollPane frequencyTableScrollPane = new JScrollPane(frequencyTable);
        codesAndTree.addTab("Frequency Table", frequencyTableScrollPane);

        // Encoding input and result fields
        JTextField encodedCodeField = new JTextField(30);
        encodedCodeField.setEditable(false);

        JTextField memorySavingsField = new JTextField(30);
        memorySavingsField.setPreferredSize(new Dimension(150, 50));
        memorySavingsField.setEditable(false);

        JTextField encodeField = new JTextField(null);
        encodeField.setPreferredSize(new Dimension(300, 30));

        JButton encodeButton = new JButton("Encode");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        encodeButton.addActionListener(e -> {
            String inputText = encodeField.getText();

            if (inputText.isEmpty()) {
                showError("Please enter some text to encode.");
                return;
            }

            try {
                huffmanCoding = new HuffmanCoding();
                huffmanCoding.root = huffmanCoding.buildTree(inputText);

                String encodedText = huffmanCoding.convertToCode(inputText);
                StringBuilder treeStructure = new StringBuilder();
                huffmanCoding.displayTree(huffmanCoding.root, "", true, treeStructure);

                String memorySavings = String.format("%.2f%%", huffmanCoding.computeMemorySavings(inputText, huffmanCoding.getHuffmanCodes()));

                treeStructureArea.setText(treeStructure.toString());
                encodedCodeField.setText(encodedText);
                memorySavingsField.setText(memorySavings);

                char[] chars = huffmanCoding.getUniqueCharacters(inputText);
                String[] headers = {"Character", "Huffman Code"};
                Object[][] tableData = new Object[chars.length][2];

                for (int i = 0; i < chars.length; i++) {
                    tableData[i][0] = chars[i];
                    tableData[i][1] = huffmanCoding.findCode(chars[i], HuffmanCoding.codes);
                }

                DefaultTableModel tableModel = new DefaultTableModel(tableData, headers){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                frequencyTable.setModel(tableModel);
                frequencyTable.getTableHeader().setReorderingAllowed(false);
            } catch (Exception ex) {
                showError("Error encoding the text: " + ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            encodeField.setText(null);
            treeStructureArea.setText(null);
            encodedCodeField.setText(null);
            memorySavingsField.setText(null);
        });

        backButton.addActionListener(e -> {
            choiceOneFrame.setVisible(false);
            this.setVisible(true);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel treeStructureLabel = new JLabel("Huffman Tree Structure");
        treeStructureLabel.setFont(font);
        treeStructureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        encodePanel.add(treeStructureLabel, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.3;
        encodePanel.add(codesAndTree, gbc);

        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel encodedCodeLabel = new JLabel("Encoded Huffman Code");
        encodedCodeLabel.setFont(font);
        encodedCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        encodePanel.add(encodedCodeLabel, gbc);

        gbc.gridy = 3;
        encodePanel.add(encodedCodeField, gbc);

        gbc.gridy = 4;
        JLabel memorySavingsLabel = new JLabel("Memory Savings");
        memorySavingsLabel.setFont(font);
        memorySavingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        encodePanel.add(memorySavingsLabel, gbc);

        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        memorySavingsField.setHorizontalAlignment(SwingConstants.CENTER);
        encodePanel.add(memorySavingsField, gbc);

        gbc.gridy = 6;
        JLabel enterTextLabel = new JLabel("Enter text to encode:");
        enterTextLabel.setFont(font);
        encodePanel.add(enterTextLabel, gbc);

        gbc.gridy = 7;
        encodePanel.add(encodeField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(encodeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        gbc.gridy = 8;
        encodePanel.add(buttonPanel, gbc);

        choiceOneFrame.add(encodePanel, BorderLayout.CENTER);
        choiceOneFrame.setSize(800, 600);
        choiceOneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceOneFrame.setVisible(true);
    }

    /**
     * Opens the decoding frame where users can input a Huffman code to decode into plain text.
     * Displays the Huffman tree structure and the decoded text.
     */
    private void choiceTwoFrame() {
        this.setVisible(false);

        JFrame choiceTwoFrame = new JFrame("Huffman Decode");
        choiceTwoFrame.setSize(600, 800);
        choiceTwoFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        choiceTwoFrame.setResizable(false);

        JPanel encodePanel = new JPanel();
        encodePanel.setLayout(new GridBagLayout());

        JTextArea treeStructureArea = new JTextArea(10, 30);
        treeStructureArea.setEditable(false);
        treeStructureArea.setLineWrap(true);
        treeStructureArea.setWrapStyleWord(true);

        JTextField decodedTextField = new JTextField(30);
        decodedTextField.setEditable(false);

        JTextField encodeField = new JTextField(null);
        encodeField.setPreferredSize(new Dimension(300, 30));

        JButton decodeButton = new JButton("Decode");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        decodeButton.addActionListener(e -> {
            String inputCode = encodeField.getText();

            if (inputCode.isEmpty()) {
                showError("Please enter a valid Huffman code to decode.");
                return;
            }

            try {
                if (huffmanCoding == null || huffmanCoding.root == null) {
                    showError("Please encode text first.");
                    return;
                }

                String decodedText = huffmanCoding.convertToText(inputCode);
                StringBuilder treeStructure = new StringBuilder();
                huffmanCoding.displayTree(huffmanCoding.root, "", true, treeStructure);

                treeStructureArea.setText(treeStructure.toString());
                decodedTextField.setText(decodedText);
            } catch (Exception ex) {
                showError("Error decoding the Huffman code: " + ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            encodeField.setText(null);
            treeStructureArea.setText(null);
            decodedTextField.setText(null);
        });

        backButton.addActionListener(e -> {
            choiceTwoFrame.setVisible(false);
            this.setVisible(true);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel treeStructureLabel = new JLabel("                        Huffman Tree Structure");
        treeStructureLabel.setFont(font);
        encodePanel.add(treeStructureLabel, gbc);

        gbc.gridy = 1;
        encodePanel.add(new JScrollPane(treeStructureArea), gbc);

        gbc.gridy = 2;
        JLabel decodedTextLabel = new JLabel("                               Decoded Text");
        decodedTextLabel.setFont(font);
        encodePanel.add(decodedTextLabel, gbc);

        gbc.gridy = 3;
        encodePanel.add(decodedTextField, gbc);

        gbc.gridy = 6;
        JLabel enterCodeLabel = new JLabel("Enter Huffman code to decode:");
        enterCodeLabel.setFont(font);
        encodePanel.add(enterCodeLabel, gbc);

        gbc.gridy = 7;
        encodePanel.add(encodeField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(decodeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        gbc.gridy = 8;
        encodePanel.add(buttonPanel, gbc);

        choiceTwoFrame.add(encodePanel, BorderLayout.CENTER);
        choiceTwoFrame.setSize(800, 600);
        choiceTwoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceTwoFrame.setVisible(true);
    }
    /**
     * Displays an error message to the user in a pop-up dialog.
     *
     * @param message The error message to display.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Main method to launch the Huffman GUI application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new HuffmanGUI();
    }
}
