package gameOfLife;

public class Board {
    private final int[][] board;
    int yAxis;
    int xAxis;

    public Board(int x, int y) {
        xAxis = x;
        yAxis = y;
        board = new int[x][y];
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

    public String printable() {

        String printableBoard = "";
        for (int height = 0; height < yAxis; height++) {
            printableBoard = printableBoard.concat("|");
            for (int width = 0; width < xAxis; width++) {
                printableBoard = printableBoard.concat(board[height][width] + " ");
            }
            printableBoard = printableBoard.substring(0, printableBoard.length() - 1);
            printableBoard = printableBoard.concat("|\n");
        }
        return printableBoard;
    }

    public int countLiveNeighbors(int x, int y) {
        int neighbors = 0;
        for (int i = 0; i <= xAxis - 1; i++) {
            for (int j = 0; j <= yAxis - 1; j++) {
                if (i > x - 2 && i < x + 2 && j > y - 2 && j < y + 2) {
                    neighbors += board[i][j];
                }
            }
        }
        neighbors -= board[x][y];
        return neighbors;
    }

    public int getY() {
        return yAxis;
    }

    public int getX() {
        return xAxis;
    }
}
