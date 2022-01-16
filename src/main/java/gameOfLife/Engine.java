package gameOfLife;

public class Engine {

    static final int TWO_LIVE_NEIGHBORS = 2;
    static final int THREE_LIVE_NEIGHBORS = 3;

    public void evolve(Board board) {

        int[][] nextGeneration = getAllNeighbors(board);

        for (int width = 0; width < board.getX(); width++) {
            for (int height = 0; height < board.getY(); height++) {
                if (nextGeneration[width][height]<TWO_LIVE_NEIGHBORS || nextGeneration[width][height]>THREE_LIVE_NEIGHBORS) {
                    board.kill(width,height);
                }
                if (nextGeneration[width][height]==THREE_LIVE_NEIGHBORS) {
                    board.birth(width, height);
                }
            }
        }
    }

    private int[][] getAllNeighbors(Board board) {
        int[][] nextGen = new int[board.getX()][board.getY()];

        for (int width = 0; width < board.getX(); width++) {
            for (int height = 0; height < board.getY(); height++) {
                nextGen[width][height] = board.countLiveNeighbors(width, height);
            }
        }

        return nextGen;
    }
}
