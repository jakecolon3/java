public class Main {
  private static int[] parseInts(String[] arguments) {
    int[] parsedArgs = new int[arguments.length];
    for (int i = 0; i < arguments.length; ++i) {
      parsedArgs[i] = Integer.parseInt(arguments[i].trim());
    }
    return parsedArgs;
  }

  public static Game createGameObject(int[] params) {
    Game game;
    if (params.length == 1) {
      game = new Game(params[0]);
    } else {
      game = new Game(params[0],
                      params[1],
                      params[2]);
    }

    return game;
  }

  public static void main(String[] args) {
    int[] parsedArgs = parseInts(args);
    Game game = createGameObject(parsedArgs);

    game.getActionBoard().printBoard();
    while (game.getGameState() == 0) {
      System.out.println("input action in the format <x, y, (1-3)>:");

      String input = System.console().readLine();
      String[] inputAction = input.split(",");
      int[] parsedAction = parseInts(inputAction);
      int x = parsedAction[0], y = parsedAction[1], a = parsedAction[2];

      game.doAction(x, y, a);
      game.getActionBoard().printBoard();
    }
    // System.out.println("type:");
    // String input = System.console().readLine();
    // System.out.println(input);
  }
}
