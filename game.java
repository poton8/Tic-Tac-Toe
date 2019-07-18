import java.util.*;
import java.util.Random;
class Game{
  
  String board[] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
  Scanner sc = new Scanner(System.in);
  Random rand = new Random();
  String name;
  boolean isPlayerTurn;

  public void getName(){
    System.out.println("Please Enter Name");
    name = sc.nextLine();
    System.out.println(name);
  }
  public void printBoard(){
    int counter = 0;
    for(String element: board){
      System.out.print(element + "  ");
      counter++;
      if(counter==3){
        System.out.println("");
        counter =0;
      }
    }
  }
  public void randomize(){
    int number = rand.nextInt(2);
    if(number ==0){
      isPlayerTurn=false;
    }
    else{
      isPlayerTurn=true;
    }
    System.out.println(isPlayerTurn);
  }

  public void playerTurn(){
    System.out.println("Please enter number that you would like to place the X in");
    int index = sc.nextInt();
    board[index - 1] = "X";
  }

  public void aiTurn(){
    int choice;
    choice = rand.nextInt(9);
    if(board[choice].equals("X")){
      aiTurn();
    }
    else{
      board[choice] = "O";
    }
  }
}
