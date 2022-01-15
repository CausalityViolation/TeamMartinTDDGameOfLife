package gameOfLife;

public class Board {
    private int[][] board;

    public Board(int x, int y) {
        board= new int[x][y];
    }

    public int[][] getBoard() {
        return board;
    }
}
