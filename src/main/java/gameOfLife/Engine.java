package gameOfLife;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    static final int TWO_LIVE_NEIGHBORS = 2;
    static final int THREE_LIVE_NEIGHBORS = 3;
    public int iterationNumber = 1;
    static Scanner input = new Scanner(System.in);

    public void gameLoop(Board board, Engine engine) {

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

    public Board userInputForTheBoardSize() {

        int height;
        int width;

        System.out.println("Input board parameters.");
        System.out.print("X-axis: ");
        width = scanInt();
        System.out.println();

        System.out.print("Y-axis: ");
        height = scanInt();
        System.out.println();

        return createRandomBoard(width, height);
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
                if (nextGeneration[width][height] < TWO_LIVE_NEIGHBORS || nextGeneration[width][height] > THREE_LIVE_NEIGHBORS) {
                    board.kill(width, height);
                }
                if (nextGeneration[width][height] == THREE_LIVE_NEIGHBORS) {
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

    private int scanInt() {
        int scanned;

        while (true) {
            try {
                scanned = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input numerical data");
                input.nextLine();
            }
        }
        input.nextLine();
        return scanned;
    }
}
