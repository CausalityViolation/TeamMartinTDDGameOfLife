package gameOfLife;

import java.util.Scanner;

public class Game {

    static int iterationNumber = 1;
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        Board board = new Board(3, 3);
        Engine engine = new Engine();
        board.birth(2, 1);
        board.birth(2, 2);
        board.birth(0, 1);
        board.birth(1, 1);
        board.birth(0, 2);


        while (true) {

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
    }
}
