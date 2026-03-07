public class Main {
  public static void main(String[] args) {
    int height = Integer.parseInt(args[1]);
    int width = Integer.parseInt(args[0]);
    int mines = Integer.parseInt(args[2]);
    Game game = new Game(width, height, mines);
    game.getMainBoard().printBoard();
    game.getAdjacencyBoard().printBoard();
    game.doAction(1, 1, 1);
    game.getActionBoard().printBoard();
  }
}
