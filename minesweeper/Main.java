public class Main {
  public static void main(String[] args) {
    int height = Integer.parseInt(args[1]);
    int width = Integer.parseInt(args[0]);
    int mines = Integer.parseInt(args[2]);
    Game game = new Game(width, height, mines);
    game.getMainBoard().printBoard();
    game.getAdjacencyBoard().printBoard();
    game.doAction(0, 0, 2);
    game.doAction(0, 9, 2);
    game.doAction(9, 0, 2);
    game.doAction(9, 9, 2);
    game.getActionBoard().printBoard();
    System.out.println(game.getGameState());

    while (game.getGameState() == 0) {
      // TODO: actual game loop
      break;
    }
  }
}
