package midtermlabproject3;
/**
 * Represents a node in a binary tree used for Huffman coding.
 * Each node contains a character symbol, a count (frequency of the symbol),
 * and references to its left and right child nodes.
 *
 * Implements the {@link Comparable} interface to allow comparison of nodes based on their counts.
 */
public class TreeNode implements Comparable<TreeNode>{
    private char symbol;
    private TreeNode left;
    private TreeNode right;
    private int count;
    /**
     * Private default constructor to initialize a placeholder node.
     * Sets the symbol to 'x', count to 0, and left and right children to null.
     */
    private TreeNode(){
        symbol = 'x';
        left = null;
        right = null;
        count = 0;
    }
    /**
     * Constructs a TreeNode with specified values.
     *
     * @param symbol The character symbol stored in the node.
     * @param count  The frequency count of the character.
     * @param left   The left child of the node.
     * @param right  The right child of the node.
     */
    public TreeNode(char symbol, int count, TreeNode left, TreeNode right) {
        this.symbol = symbol;
        this.left = left;
        this.right = right;
        this.count = count;
    }
    /**
     * Gets the character symbol of this node.
     *
     * @return The character stored in the node.
     */
    public char getSymbol() {
        return symbol;
    }
    /**
     * Sets the character symbol of this node.
     *
     * @param symbol The character to set.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    /**
     * Gets the left child of this node.
     *
     * @return The left child node.
     */
    public TreeNode getLeft() {
        return left;
    }
    /**
     * Sets the left child of this node.
     *
     * @param left The left child node to set.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    /**
     * Gets the right child of this node.
     *
     * @return The right child node.
     */
    public TreeNode getRight() {
        return right;
    }
    /**
     * Sets the right child of this node.
     *
     * @param right The right child node to set.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
    /**
     * Gets the frequency count of this node.
     *
     * @return The count stored in this node.
     */
    public int getCount() {
        return count;
    }
    /**
     * Sets the frequency count of this node.
     *
     * @param count The frequency count to set.
     */
    public void setCount(int count) {
        this.count = count;
    }
    /**
     * Checks if this node is a leaf node (i.e., has no children).
     *
     * @return {@code true} if the node is a leaf, {@code false} otherwise.
     */
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
    /**
     * Compares this node to another node based on their frequency counts.
     *
     * @param other The other node to compare to.
     * @return A negative integer, zero, or a positive integer as this node's count
     *         is less than, equal to, or greater than the other node's count.
     */
    @Override
    public int compareTo(TreeNode other){
        return Integer.compare(this.count, other.getCount());
    }
}
