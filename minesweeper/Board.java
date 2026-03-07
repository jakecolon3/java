public class Board {
  private int boardHeight, boardWidth, boardMines;
  private int[][] boardMatrix;

  public static int[][] generateBoard(int height, int width) {
    int[][] board = new int[height][width];
    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        board[i][j] = 0;
      }
    }
    return board;
  }

  public Board(int height, int width, int mines) {
    boardHeight = height;
    boardWidth = width;
    boardMines = mines;
    boardMatrix = Board.generateBoard(height, width);
  }

  public void printBoard() {
    int height = this.boardMatrix.length;
    int width = this.boardMatrix[0].length;

    System.out.println("Board:");
    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        System.out.print(this.boardMatrix[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public int getHeight() {
    return boardHeight;
  }

  public int getWidth() {
    return boardWidth;
  }

  public int getMines() {
    return boardMines;
  }

  public int[][] getMatrix() {
    return boardMatrix;
  }

  public void updateMatrix(int y, int x, int v) {
    this.boardMatrix[y][x] = v;
  }

  public void populateBoard() {
    for (int i = 0; i < boardMines; ++i) {
      double randomY = Math.random() * boardHeight;
      double randomX = Math.random() * boardWidth;
      int y = (int) randomY;
      int x = (int) randomX;

      if (boardMatrix[y][x] == 1) {
        --i;
        continue;

      } else {
        boardMatrix[y][x] = 1;
      }
    }
  }

  public int[][] getNeighbors(int x, int y) {
    int[][] neighbors = {
        { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 },
        { x - 1, y }, { x + 1, y },
        { x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 }
    };

    return neighbors;
  }

  private int countNeighbors(int x, int y) {
    int count = 0;

    for (int[] coordinate : getNeighbors(x, y)) {
      int i = coordinate[0];
      int j = coordinate[1];

      if (i < 0 || j < 0 || (i >= boardWidth) || (j >= boardHeight)) {
        continue;
      } else if (boardMatrix[j][i] == 1) {
        count++;
      }
    }

    return count;
  }

  public void populateAdjacencyBoard(Board mainBoard) {
    int count;
    for (int j = 0; j < mainBoard.getHeight(); j++) {

      for (int i = 0; i < mainBoard.getWidth(); i++) {

        if (mainBoard.getMatrix()[j][i] == 1) {
          count = 9;
        } else {
          count = mainBoard.countNeighbors(i, j);
        }

        this.updateMatrix(j, i, count);
      }
    }
  }
}
