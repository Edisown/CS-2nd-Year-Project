/**
 * MALASAN, Edison M.
 * CS211L - 9344B
 * 10/7/2024
 */
package Exercise_2_Stack_Data_Structure;

import java.io.*;
import java.lang.*;
import java.util.Stack;
import java.util.Scanner;

public class MouseMaze {
        private char[][] myMaze =
                {{'1','1','1','1','1','1'},
                {'1','1','0','0','E','1'},
                {'1','0','0','1','1','1'},
                {'1','0','0','0','0','1'},
                {'1','1','0','0','M','1'},
                {'1','0','1','1','1','1'}};

        private int rows = myMaze.length;
        private int column = myMaze[0].length;
        private MazeCell currentCell = null;
        private MazeCell exitCell = new Mazecell();
        private MazeCell entryCell = new MazeCell();
        private final char EXIT_MARKER = 'E';
        private final char ENTRY_MARKER = 'M';
        private final char VISITED = '.';
        private final char PASSAGE = '0';
        private final char WALL = '1';

        private Stack<MazeCell> mazeStackk = new Stack<MazeCell>();

        private FileReader fileReader;
        private BufferedReader bufferedReader;
        private Scanner keyboard = new Scanner(System.in);

        public MouseMaze(){
            boolean foundEntryCell = false;
            boolean foundExitCell = false;

            for (int row = 0; row < myMaze.length && !foundEntryCell; row++) {
                    for (int col = 0; col < myMaze[row].length && !foundEntryCell; col++) {

                    }
            }
    }
}