package gameOfLife;

public class Engine {
    public void evolve(Board board) {

        int[][] nextGeneration = new int[board.getX()][board.getY()];
        for (int i = 0; i < board.getX(); i++) {
            for (int j = 0; j < board.getY(); j++) {
                nextGeneration[i][j] = board.countLiveNeighbors(i, j);
            }
        }

        for (int i = 0; i < board.getX(); i++) {
            for (int j = 0; j < board.getY(); j++) {
                if (nextGeneration[i][j]<2) {
                    board.kill(i,j);
                }
            }
        }

    }
}
