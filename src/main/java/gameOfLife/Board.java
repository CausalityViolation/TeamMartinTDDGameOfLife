package gameOfLife;

public class Board {

    private final int[][] board;
    private final int yAxis;
    private final int xAxis;

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

        int verticalLength = xAxis - 1;
        int horizontalLength = yAxis - 1;

        int horizontalSpanStart = x - 2;
        int horizontalSpanEnd = x + 2;

        int verticalSpanStart = y - 2;
        int verticalSpanEnd = y + 2;

        for (int width = 0; width <= verticalLength; width++) {
            for (int height = 0; height <= horizontalLength; height++) {
                if (width > horizontalSpanStart && width < horizontalSpanEnd && height > verticalSpanStart && height < verticalSpanEnd) {
                    neighbors += board[width][height];
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
