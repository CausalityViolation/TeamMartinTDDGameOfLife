package gameOfLife;

public class Game {

    public static void main(String[] args) {

        Engine engine = new Engine();

        Board board = engine.userInputForTheBoardSize();

        //noinspection InfiniteLoopStatement
        while (true) {
            engine.gameLoop(board, engine);
        }
    }

}
