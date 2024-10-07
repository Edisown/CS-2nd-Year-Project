/**
 * MALASAN, Edison M.
 * CS211L - 9344B
 * 10/7/2024
 */
    package Exercise_2_Stack_Data_Structure;

/**
 *
 */
public class MazeCell {
    private int row;
    private int column;

    public MazeCell(){
        row = 0;
        column = 0;
    }

    public MazeCell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean sameAs(MazeCell another) {
        return (row == another.getRow() && column == another.getColumn());
    }
}