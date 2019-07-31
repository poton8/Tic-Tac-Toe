using System;

namespace Tic_Tac_Toe{
    class Game
    {
        private int turns = 0;
        private String[,] board = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        private int[,,] winPositions = {{{0,0}, {0,1}, {0,2}}, 
                                        {{0,0}, {1,0}, {2,0}},
                                        {{0,0}, {1,1}, {2,2}},
                                        {{0,1}, {1,1}, {2,1}},
                                        {{0,2}, {1,2}, {2,2}},
                                        {{1,0}, {1,1}, {1,2}},
                                        {{2,0}, {2,1}, {2,2}},
                                        {{2,0}, {1,1}, {0,2}}};

        private String aiLetter;

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
            if(turns==9){
                return true;
            }
            else{
                for(int i=0;i<8;i++){
                String letter = board[winPositions[i,0,0], winPositions[i,0,1]];
                int threeInRow = 0;
                    for(int j=0;j<3;j++){
                        if(letter == board[winPositions[i,j,0],winPositions[i,j,1]]){
                            threeInRow++;
                        }
                        if(threeInRow==3){
                            return true;
                        }
                    }
                }
            }
            return false;

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