/**
 * MALASAN, Edison M.
 * CS211L - 9344B
 * 10/7/2024
 */
package Exercise_2_Stack_Data_Structure;

import java.io.*;
import java.util.Stack;
import java.util.Scanner;

/**
 * Sample Mouse Maze Puzzle.
 * The mouse (M) is positioned in a cell of the maze.
 * The mouse sequentially moves to open cells until the mouse reaches the exit cell (E).
 * An open cell is marked by '0'.
 * A closed cell is marked by '1'.
 *
 * by: MALASAN, Edison M.
 *
 * ALGORITHM:
 * 1. Begin by Initializing the maze with (M) as entry and (E) as exit cells.
 * 2. Next, Locate the entry and exit cells in the maze.
 * 3. display the maze and prompt the user to continue until the mouse finds the exit.
 * 4. Start from the entry cell:
 *    - Mark the current cell as visited.
 *    - Check if the current cell is the exit:
 *        1. If yes, display the message success and exit.
 *        2. If no, explore the neighboring cells (up, down, left, right) to find open paths.
 * 5. Will use a stack to backtrack if there are no available paths.
 * 6. Repeat the process until the exit is found or all paths are exhausted.
 * 7. If the stack is empty and the exit is not found, display a failure message.
 *
 */
public class MouseMaze {

    private char[][] myMaze = {
            {'1', '1', '1', '1', '1', '1'},
            {'1', '1', '0', '0', 'E', '1'},
            {'1', '0', '0', '1', '1', '1'},
            {'1', '0', '0', '0', '0', '1'},
            {'1', '1', '0', '0', 'M', '1'},
            {'1', '0', '1', '1', '1', '1'}
    };

    private int rows = myMaze.length;
    private int cols = myMaze[0].length;
    private MazeCell currentCell = null;
    private MazeCell exitCell = new MazeCell();
    private MazeCell entryCell = new MazeCell();
    private final char EXIT_MARKER = 'E';
    private final char ENTRY_MARKER = 'M';
    private final char VISITED = '.';
    private final char PASSAGE = '0';
    private final char WALL = '1';
    private Stack<MazeCell> mazeStack = new Stack<MazeCell>();
    private Scanner keyboard = new Scanner(System.in);

    // constructor to find the entry and exit cells in the maze
    public MouseMaze() {
        boolean foundEntryCell = false;
        boolean foundExitCell = false;

        // nested for loop locate the entry cell (M)
        for (int row = 0; row < myMaze.length && !foundEntryCell; row++)
            for (int col = 0; col < myMaze[row].length && !foundEntryCell; col++) {
                if (myMaze[row][col] == ENTRY_MARKER) {
                    entryCell.setRow(row);
                    entryCell.setColumn(col);
                    foundEntryCell = true;
                }
            }

        // nested for loop to locate the exit cell (E)
        for (int row = 0; row < myMaze.length && !foundExitCell; row++)
            for (int col = 0; col < myMaze[row].length && !foundExitCell; col++) {
                if (myMaze[row][col] == EXIT_MARKER) {
                    exitCell.setRow(row);
                    exitCell.setColumn(col);
                    foundExitCell = true;
                }
            }
    } // end of Maze constructor

    /**
     *  display the maze with the current path followed by the mouse if any.
     */
    private void display(char[][] myMaze) {
        for (int row = 0; row < myMaze.length; row++) {
            for (int col = 0; col < myMaze[row].length; col++)
                System.out.print(myMaze[row][col]);
            System.out.println();
        }
        System.out.println();
    }

    /**
     * pushes a cell with the given row and column index into the stack
     * if the cell is marked as an open cell or exit cell.
     */
    private void pushUnvisited(int row, int col) {
        if (myMaze[row][col] == PASSAGE || myMaze[row][col] == EXIT_MARKER)
            mazeStack.push(new MazeCell(row, col));
    }

    /**
     * let the mouse find its way to the exit cell.
     */
    public void findWayOut() {
        int row = 0;
        int col = 0;

        // the mouse start from the entry cell, where the mouse is initially placed
        currentCell = entryCell;
        System.out.println();
        display(myMaze);
        System.out.println("The above figure shows a maze where a mouse (M) is in.");
        System.out.println("The Mouse (M) should move to exhaustively find the Exit cell (E).");
        System.out.println("A cell marked '0' is an open cell, a cell marked by '1' is a closed cell.");
        System.out.println("Keep pressing the enter key until success or failure is reached.");

        System.out.println("Find the way out.");
        keyboard.nextLine();

        while (!currentCell.sameAs(exitCell)) {
            row = currentCell.getRow();
            col = currentCell.getColumn();

            // check if the current cell is the exit
            if (currentCell.sameAs(exitCell)) {
                display(myMaze);
                System.out.println("Success! Exit found");
                break;
            }

            // mark the current cell as visited if it's not the entry cell
            if (!currentCell.sameAs(entryCell)) {
                myMaze[row][col] = VISITED;
                display(myMaze);
                System.out.println("Find the way out.");
                keyboard.nextLine();
            }

            // push unvisited neighboring cells onto the stack
            pushUnvisited(row - 1, col); // Up
            pushUnvisited(row + 1, col); // Down
            pushUnvisited(row, col - 1); // Left
            pushUnvisited(row, col + 1); // Right

            // if there are no unvisited cells left, display "Failure: Exit cannot be reached"
            if (mazeStack.isEmpty()) {
                display(myMaze);
                System.out.println("Failure: Exit cannot be reached");
                return;
            } else {
                // else move to a reachable cell
                currentCell = mazeStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        MouseMaze solver;
        try {
            solver = new MouseMaze();
            solver.findWayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    } // end of main
} // end of MouseMaze class
