package gameOfLife;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BoardTest {


    Board board = new Board(3, 3);

    @Test
    public void doesBoardExist() {
        assertArrayEquals(board.getBoard(), new int[3][3]);
    }

    @Test
    public void createDifferentBoard() {
        Board testBoard = new Board(5,5);
        assertArrayEquals(testBoard.getBoard(), new int[5][5]);
    }


}
