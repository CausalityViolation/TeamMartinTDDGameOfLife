package gameOfLife;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTest {

    Engine engine = new Engine();
    Board board = new Board(3, 3);

    @Test
    public void cellsWithFewerThanTwoLiveNeighborsDies() {
        board.birth(0, 0);
        board.birth(0, 1);
        board.countLiveNeighbors(0, 0);

        engine.evolve(board);

        assertEquals(0, board.getBoard()[0][0]);

    }

    @Test
    public void cellWithTwoOrThreeLiveNeighborsSurvive() {

        board.birth(0, 0);
        board.birth(0, 1);
        board.birth(1, 1);
        board.countLiveNeighbors(0, 0);

        engine.evolve(board);

        assertEquals(1, board.getBoard()[0][0]);

    }

    @Test
    public void cellWithMoreThanThreeLiveNeighborsDie() {

        board.birth(0, 0);
        board.birth(0, 1);
        board.birth(1, 1);
        board.birth(2, 2);
        board.birth(0, 2);

        engine.evolve(board);

        board.countLiveNeighbors(0, 0);

        assertEquals(0, board.getBoard()[1][1]);

    }

    @Test
    public void cellWithExactlyThreeLiveNeighborsResurrect() {

        board.birth(0, 0);
        board.birth(0, 1);
        board.birth(2, 2);

        engine.evolve(board);

        board.countLiveNeighbors(0, 0);

        assertEquals(1, board.getBoard()[1][1]);

    }
}

/*

Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

 */