package gameOfLife;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    static final int TWO_LIVE_NEIGHBORS = 2;
    static final int THREE_LIVE_NEIGHBORS = 3;
    public int iterationNumber = 1;

    public void gameLoop(Board board, Engine engine) {

        Scanner input = new Scanner(System.in);

        System.out.println("Press ENTER to Iterate. Input EXIT to exit program.");
        if (!input.nextLine().equalsIgnoreCase("exit")) {

            System.out.println("===================");
            System.out.println("Iteration " + iterationNumber);
            System.out.println(board.printable());
            System.out.println("===================");
            engine.evolve(board);

            iterationNumber++;

        } else {
            System.exit(0);
        }
    }

    public Board createRandomBoard(int xAxis, int yAxis) {
        Random rand = new Random();
        Board board = new Board(xAxis, yAxis);
        for (int width = 0; width < xAxis; width++) {
            for (int height = 0; height < yAxis; height++) {
                boolean alive = rand.nextBoolean();
                if (alive) {
                    board.birth(width, height);
                }
            }
        }
        return board;
    }

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
