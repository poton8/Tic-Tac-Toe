using System;

namespace Tic_Tac_Toe{
    class Game
    {
        private String[] board = {"1","2","3","4","5","6","7","8","9"};
        Random rand = new Random();
        public bool isFirst(){
            bool isFirst = Convert.ToBoolean(rand.Next(0,2));
            return isFirst;
        }

        public void userTurn(){
            Console.WriteLine("Enter your move");
            int index = Convert.ToInt16(Console.ReadLine());
            board[index - 1]  = "X";
        }

        public void aiTurn(){

        }

        public minimax(newBoard, Player){
            int[] indexes = {};
            foreach(String element in board){
                if (element != "X" || element != "O"){
                    indexes[Convert.ToInt16(element) - 1] = Convert.ToInt16(element);
                }
            }

        }

        public bool isGameDone(){
            bool isContinue;
            isContinue = true;
            return isContinue;
        }

 
        public void printBoard(){
            int count = 0;
            foreach(String element in board){
                if(count==3){
                    Console.WriteLine();
                    count = 0;
                }
                Console.Write(element);
                count++;
            }
            Console.WriteLine();
        } 
    } 
} 