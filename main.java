class Main {
  
  public static void main(String[] args) {
    Game game = new Game();
    game.getName();
    game.printBoard();
    game.randomize();
    game.printBoard();
    while(true){
      if (game.isPlayerTurn){
        game.playerTurn();
        game.isPlayerTurn = false;
      }
      else{
        game.aiTurn();
        game.isPlayerTurn = true;
      }
      System.out.println("");
    }
  }
}