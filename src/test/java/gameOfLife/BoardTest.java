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

    @Test
    public void boardIsPrintable() {

        String expected = """
                |0 0 0|
                |0 0 0|
                |0 0 0|
                """;
        assertEquals(expected, board.printable());
    }

    @Test
    public void howManyLiveNeighbors() {
        board.birth(0, 0);
        board.birth(0, 1);
        board.birth(1, 0);
        assertEquals(2, board.countLiveNeighbors(1, 0));

    }

    @Test
    public void howManyLiveNeighborsWhenInCorner() {
        board.birth(2, 2);
        board.birth(2, 1);
        board.birth(1, 2);

        assertEquals(2, board.countLiveNeighbors(2, 2));
    }

    @Test
    public void countLiveNeighborsFromCenter() {
        board.birth(0, 1);
        board.birth(1, 0);
        board.birth(1, 2);
        board.birth(2, 1);

        assertEquals(4, board.countLiveNeighbors(1, 1));
    }
}





/*

Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

 */
