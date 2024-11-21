package midtermlabproject3;

/**
 * The {@code HuffmanCode} class represents a single character and its corresponding Huffman code
 * as part of the Huffman encoding algorithm. Huffman encoding is a compression algorithm that
 * assigns variable-length binary codes to characters based on their frequencies. This class
 * encapsulates a character and its unique binary Huffman code.
 */
public class HuffmanCode {

    /**
     * The character symbol represented by this Huffman code.
     */
    private char symbol;

    /**
     * The Huffman code as a binary string for the character symbol.
     */
    private String code;

    /**
     * Default constructor that initializes the {@code HuffmanCode} object with a default
     * symbol '-' and an empty string as the code. This can be useful as a placeholder
     * until a symbol and code are explicitly set.
     */
    public HuffmanCode() {
        this.symbol = '-';
        this.code = "";
    }

    /**
     * Overloaded constructor that initializes the {@code HuffmanCode} object with a specific
     * symbol and its corresponding Huffman code.
     *
     * @param symbol the character symbol to be encoded
     * @param code the Huffman binary string representing the code for the symbol
     */
    public HuffmanCode(char symbol, String code) {
        this.symbol = symbol;
        this.code = code;
    }

    /**
     * Gets the character symbol of this {@code HuffmanCode} object.
     *
     * @return the character symbol encoded by this Huffman code
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the character symbol of this {@code HuffmanCode} object.
     *
     * @param symbol the character to set as the symbol for this Huffman code
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the binary string representing the Huffman code for the symbol.
     *
     * @return the Huffman code as a binary string for the character symbol
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the Huffman code for the character symbol as a binary string.
     *
     * @param code the binary string to set as the Huffman code for the symbol
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns a string representation of this {@code HuffmanCode} object, showing the
     * character symbol and its associated Huffman code in a readable format.
     *
     * @return a string in the format "Character: {symbol} | Code: {code}"
     */
    @Override
    public String toString() {
        return "Character: " + symbol + " | Code: " + code;
    }
}
