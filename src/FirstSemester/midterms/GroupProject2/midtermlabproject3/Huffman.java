package midtermlabproject3;

import java.util.List;

/**
 * The {@code Huffman} interface defines the operations required for implementing
 * Huffman encoding and decoding, a compression algorithm that assigns variable-length
 * binary codes to characters based on their frequencies in the input text.
 */
public interface Huffman {
    TreeNode buildTree(String text);
    void generateCodes(List<HuffmanCode> codes, TreeNode root, String code);
    String convertToCode(String text);
    String convertToText(String code);
}
