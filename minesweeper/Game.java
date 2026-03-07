public class Game {
  private Board mainBoard, adjacencyBoard, actionBoard;

  public Game(int width, int height, int mines) {
    this.gameInit(width, height, mines);
  }

  public Game(int difficulty) {
    this.gameInit(difficulty);
  }

  public void gameInit(int width, int height, int mines) {
    this.mainBoard = new Board(height, width, mines);
    this.mainBoard.populateBoard();

    this.adjacencyBoard = new Board(height, width, mines);
    this.adjacencyBoard.populateAdjacencyBoard(this.mainBoard);

    this.actionBoard = new Board(height, width, mines);
  }

  public void gameInit(int difficulty) {
    switch (difficulty) {
      case 0:
        gameInit(9, 9, 10);
        break;

      case 1:
        gameInit(16, 16, 25);
        break;

      case 2:
        gameInit(30, 16, 99);
        break;

      default:
        System.out.println("Invalid difficulty");
        break;
    }
  }

  public Board getMainBoard() {
    return this.mainBoard;
  }

  public Board getAdjacencyBoard() {
    return this.adjacencyBoard;
  }

  public Board getActionBoard() {
    return this.actionBoard;
  }

  private void actionSweep(int x, int y) {
    this.actionBoard.updateMatrix(y, x, 1);

    if (this.adjacencyBoard.getMatrix()[y][x] == 0) {

      int[][] neighbors = this.adjacencyBoard.getNeighbors(x, y);

      for (int[] cell : neighbors) {
        if (cell[0] < 0
            | cell[1] < 0
            | cell[0] >= this.mainBoard.getWidth()
            | cell[1] >= this.mainBoard.getHeight()) {
          continue;
        }

        if (this.adjacencyBoard.getMatrix()[y][x] == 0
            && this.actionBoard.getMatrix()[cell[1]][cell[0]] == 0) {
          this.actionSweep(cell[0], cell[1]);
        }
      }
    }
  }

  private void actionFlag(int x, int y) {
    this.actionBoard.updateMatrix(y, x, 2);
  }

  private void actionUnsure(int x, int y) {
    this.actionBoard.updateMatrix(y, x, 3);

  }

  public void doAction(int x, int y, int action) {
    switch (action) {
      case 1:
        this.actionSweep(x, y);
        break;

      case 2:
        this.actionFlag(x, y);
        break;

      case 3:
        this.actionUnsure(x, y);
        break;

      default:
        System.out.println("Invalid action");
        break;
    }
  }

  public void updateBoard() {

  }
}
