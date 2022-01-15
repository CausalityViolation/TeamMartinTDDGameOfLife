package gameOfLife;

import java.util.Random;
import java.util.Scanner;

public class Game {

    static int iterationNumber = 1;

    public static void main(String[] args) {
        Board board = createRandomBoard(10, 10);
        Engine engine = new Engine();

        //noinspection InfiniteLoopStatement
        while (true) {
            gameLoop(board, engine);
        }
    }

    private static void gameLoop(Board board, Engine engine) {

        Scanner input = new Scanner(System.in);

        System.out.println("Press ENTER to Iterate.");
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

    private static Board createRandomBoard(int x, int y) {
        Random rand = new Random();
        Board board = new Board(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                boolean alive = rand.nextBoolean();
                if (alive) {
                    board.birth(i, j);
                }
            }
        }
        return board;
    }
}
