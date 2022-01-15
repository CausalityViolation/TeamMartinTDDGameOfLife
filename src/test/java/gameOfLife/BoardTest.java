package gameOfLife;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {


    Board board = new Board(3, 3);

    @Test
    public void doesBoardExist() {
        assertArrayEquals(board.getBoard(), new int[3][3]);
    }

    @Test
    public void createDifferentBoard() {
        Board testBoard = new Board(5, 5);
        assertArrayEquals(testBoard.getBoard(), new int[5][5]);
    }

    @Test
    public void cellsCanBeBornAndKilled() {


        assertEquals(board.getBoard()[1][1], 0);
        board.birth(1, 1);
        assertEquals(board.getBoard()[1][1], 1);
        board.kill(1, 1);
        assertEquals(board.getBoard()[1][1], 0);

    }
}





/*

Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

 */
