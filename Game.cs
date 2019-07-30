using System;

namespace Tic_Tac_Toe{
    class Game
    {
        private String[,] board = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        private String aiLetter;
        private int turns;
        Random rand = new Random();
        public bool isFirst(){
            bool isFirst = Convert.ToBoolean(rand.Next(0,2));
            return isFirst;
        }

        public void userTurn(){
            Console.WriteLine("Enter your move");
            String choice = Console.ReadLine();
            for(int i =0;i<3;i++){
                for(int j =0;j<3;j++){
                    if(choice==board[i,j]){
                        board[i,j] = "X";
                    }
                }
            }
        }

        public void aiTurn(){
            while(true){
                int i = rand.Next(0,3);
                int j = rand.Next(0,3);
                if(board[i,j] != "X" && board[i,j] != "O"){
                    board[i,j] = "O";
                    break;
                }
            }
        }

        

        public bool isGameDone(){
            bool isDone;
            turns++;
            if(turns == 9){
                isDone = true;
            }
            else{
                isDone = false;
            }
            return isDone;
        }

 
        public void printBoard(){
            for(int i =0;i<3;i++){
                for(int j =0;j<3;j++){
                    Console.Write(board[i,j]);
                }
                Console.WriteLine();
            }
        } 
    } 
} 