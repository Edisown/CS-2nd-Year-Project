package midtermlabproject3;

import java.util.*;
/**
 * The {@code HuffmanCoding} class provides functionality for encoding and decoding text using
 * Huffman coding, a compression algorithm that uses variable-length binary codes for characters
 * based on their frequencies in the input text.
 * Features:
 *   Interactive menu for encoding and decoding operations.
 *   Construction of a Huffman tree for text encoding.
 *   Visualization of the Huffman tree structure.
 *   Calculation of memory savings achieved by Huffman coding.
 */
public class HuffmanCoding {
    /** The root node of the Huffman tree. */
    public TreeNode root;
    public static List<HuffmanCode> codes;
    /**
     * The main entry point for the program.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        HuffmanCoding program;
        try {
            program = new HuffmanCoding();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Executes the main program logic with a menu for user interaction.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            if (choice == 3) {
                System.out.println("Exiting program.");
                break;
            }
            doChoice(choice);
        }
    }
    /**
     * Processes the user's menu choice.
     *
     * @param choice the menu option chosen by the user.
     */
    public void doChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1 -> encodeText(scanner);
            case 2 -> decodeText(scanner);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
    /**
     * Displays the main menu of the program.
     */
    public void showMenu() {
        System.out.println("==============================");
        System.out.println("    Huffman Coding Menu:");
        System.out.println("==============================");
        System.out.println("1. Encode text to Huffman code");
        System.out.println("2. Decode Huffman code to text");
        System.out.println("3. Exit");
        System.out.println("==============================");
    }
    /**
     * Encodes a given text into Huffman binary code.
     *
     * @param scanner the {@code Scanner} object to receive user input.
     */
    public void encodeText(Scanner scanner) {
        System.out.print("Enter text to encode: ");
        String text = scanner.nextLine();
        try {
            // Build the Huffman tree and set the root for decoding
            root = buildTree(text);
            String encodedText = convertToCode(text);

            System.out.println("Huffman Tree Structure after encoding:");
            StringBuilder treeStructure = new StringBuilder();
            displayTree(root, "", false, treeStructure);
            System.out.println(treeStructure);

            System.out.println("Encoded Huffman Code: " + encodedText);
            System.out.println("\nMemory Savings: " + computeMemorySavings(text, getHuffmanCodes()) + "%\n");
        } catch (Exception e) {
            System.out.println("Error during encoding: " + e.getMessage());
        }
    }
    /**
     * Decodes a Huffman binary code into text.
     *
     * @param scanner the {@code Scanner} object to receive user input.
     */
    public void decodeText(Scanner scanner) {
        if (root == null) {
            System.out.println("Error: Huffman tree is not built. Please encode text first.");
            return;
        }

        System.out.print("Enter Huffman code to decode: ");
        String code = scanner.nextLine();
        try {
            String decodedText = convertToText(code);

            System.out.println("Huffman Tree Structure used for decoding:");
            StringBuilder treeStructure = new StringBuilder();
            displayTree(root, "", false, treeStructure);
            System.out.println(treeStructure);

            System.out.println("Decoded Text: " + decodedText + "\n");
        } catch (Exception e) {
            System.out.println("Error during decoding: " + e.getMessage() + "\n");
        }
    }
    /**
     * Converts a Huffman binary code back to the original text.
     *
     * @param code the binary code to decode.
     * @return the decoded text.
     * @throws IllegalStateException if the Huffman tree is not initialized.
     */
    public String convertToText(String code) {
        if (root == null) {
            throw new IllegalStateException("Huffman tree is not initialized.");
        }

        StringBuilder decodedText = new StringBuilder();
        TreeNode current = root;

        for (char bit : code.toCharArray()) {
            if (bit == '0') {
                current = current.getLeft();
            } else if (bit == '1') {
                current = current.getRight();
            } else {
                throw new IllegalArgumentException("Invalid bit in Huffman code: " + bit);
            }

            if (current == null) {
                throw new IllegalStateException("Huffman code does not match the tree structure.");
            }

            if (current.isLeaf()) {
                decodedText.append(current.getSymbol());
                current = root;
            }
        }
        return decodedText.toString();
    }
    /**
     * Builds a Huffman tree from the given text.
     *
     * @param text the input text to encode.
     * @return the root of the Huffman tree.
     */
    public TreeNode buildTree(String text) {
        PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
        char[] uniqueLetters = getUniqueCharacters(text);

        for (char c : uniqueLetters) {
            int freq = countOccurrence(text, c);
            huffmanTree.add(new TreeNode(c, freq, null, null));
        }

        while (huffmanTree.size() > 1) {
            TreeNode left = huffmanTree.poll();
            TreeNode right = huffmanTree.poll();
            int newCount = left.getCount() + right.getCount();
            huffmanTree.add(new TreeNode('*', newCount, left, right));
        }
        return huffmanTree.poll();
    }
    /**
     * Generates the Huffman codes from the tree.
     *
     * @return a list of {@code HuffmanCode} objects representing the codes for each character.
     */
    public List<HuffmanCode> getHuffmanCodes() {
        codes = new ArrayList<>();
        generateCodes(codes, root, "");
        return codes;
    }
    /**
     * Generates Huffman codes for the characters in the tree.
     *
     * @param codes the list to store the generated codes.
     * @param node the current node in the tree.
     * @param code the code generated so far for the current path.
     */
    public void generateCodes(List<HuffmanCode> codes, TreeNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            codes.add(new HuffmanCode(node.getSymbol(), code));
        } else {
            generateCodes(codes, node.getLeft(), code + "0");
            generateCodes(codes, node.getRight(), code + "1");
        }
    }
    /**
     * Converts a given text into its Huffman binary representation.
     *
     * @param text the text to encode.
     * @return a string representing the Huffman binary code for the input text.
     */
    public String convertToCode(String text) {
        List<HuffmanCode> codes = getHuffmanCodes();
        StringBuilder convertedCode = new StringBuilder();

        for (char c : text.toCharArray()) {
            convertedCode.append(findCode(c, codes));
        }
        return convertedCode.toString();
    }
    /**
     * Finds the Huffman binary code for a specific character.
     *
     * @param letter the character for which the Huffman code is needed.
     * @param codes a list of {@code HuffmanCode} objects containing character-code mappings.
     * @return the Huffman binary code for the specified character.
     * @throws IllegalStateException if the character is not found in the code mappings.
     */
    public String findCode(char letter, List<HuffmanCode> codes) {
        return codes.stream()
                .filter(hc -> hc.getSymbol() == letter)
                .map(HuffmanCode::getCode)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No Huffman code found for character: " + letter));
    }
    /**
     * Computes the percentage of memory saved by using Huffman coding compared to 8-bit fixed encoding.
     *
     * @param text the original text to encode.
     * @param codes a list of {@code HuffmanCode} objects representing the Huffman codes.
     * @return the percentage of memory saved as a double.
     */
    public double computeMemorySavings(String text, List<HuffmanCode> codes) {
        double totalBitsInEightBits = text.length() * 8;
        double totalBitsInHuffman = 0;

        for (char c : text.toCharArray()) {
            totalBitsInHuffman += findCode(c, codes).length();
        }

        double memorySaved = totalBitsInEightBits - totalBitsInHuffman;
        return (memorySaved / totalBitsInEightBits) * 100;
    }
    /**
     * Extracts unique characters from a string.
     *
     * @param input the input string.
     * @return an array of unique characters from the input string.
     */
    public char[] getUniqueCharacters(String input) {
        TreeSet<Character> uniqueLetters = new TreeSet<>();
        for (char c : input.toCharArray()) {
            uniqueLetters.add(c);
        }

        char[] result = new char[uniqueLetters.size()];
        int i = 0;
        for (char c : uniqueLetters) {
            result[i++] = c;
        }
        return result;
    }
    /**
     * Counts the occurrences of a specific character in a string.
     *
     * @param text the string to search.
     * @param c the character to count.
     * @return the number of occurrences of the character in the string.
     */
    private int countOccurrence(String text, char c) {
        return (int) text.chars().filter(ch -> ch == c).count();
    }
    /**
     * Displays the structure of the Huffman tree in a readable format.
     *
     * @param root the root node of the tree.
     * @param indent the current level of indentation for displaying the tree.
     * @param isLeft a flag indicating if the current node is a left child.
     * @param treeStructure a {@code StringBuilder} to accumulate the tree structure.
     */
    public void displayTree(TreeNode root, String indent, boolean isLeft, StringBuilder treeStructure) {
        if (root == null) return;

        String symbol = root.getSymbol() != '*' ? String.valueOf(root.getSymbol()) : "*";
        String count = "(" + root.getCount() + ")";
        treeStructure.append(indent).append(isLeft ? "├──" : "└──").append("[").append(symbol).append(": ").append(count).append("]\n");

        displayTree(root.getLeft(), indent + (isLeft ? "|   " : "    "), true, treeStructure);
        displayTree(root.getRight(), indent + (isLeft ? "|   " : "    "), false, treeStructure);
    }
}
