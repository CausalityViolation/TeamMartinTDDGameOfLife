package gameOfLife;

public class Board {
    private int[][] board;

    public Board(int x, int y) {
        board= new int[x][y];
    }

    public int[][] getBoard() {
        return board;
    }

    public void birth(int x, int y) {
        board[x][y] = 1;
    }

    public void kill(int x, int y) {
        board[x][y] = 0;
    }
}
