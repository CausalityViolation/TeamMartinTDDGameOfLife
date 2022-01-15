package gameOfLife;

public class Engine {
    public void evolve(Board board) {

        int[][] nextGeneration = new int[board.getX()][board.getY()];
        for (int width = 0; width < board.getX(); width++) {
            for (int height = 0; height < board.getY(); height++) {
                nextGeneration[width][height] = board.countLiveNeighbors(width, height);
            }
        }

        for (int width = 0; width < board.getX(); width++) {
            for (int height = 0; height < board.getY(); height++) {
                if (nextGeneration[width][height]<2 || nextGeneration[width][height]>3) {
                    board.kill(width,height);
                }
                if (nextGeneration[width][height]==3) {
                    board.birth(width, height);
                }
            }
        }
    }
}
