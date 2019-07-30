using System;

namespace Tic_Tac_Toe
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please Enter Name");
            String name = Console.ReadLine();
            User one = new User(name);
            Game game = new Game();
            bool isTurn = game.isFirst();
            bool isGameDone = false;
            while(!isGameDone){
                if(isTurn){
                    game.printBoard();
                    game.userTurn();
                    isGameDone = game.isGameDone();
                    game.aiTurn();
                    isGameDone = game.isGameDone();
                }

                else{
                    game.aiTurn();
                    isGameDone = game.isGameDone();
                    game.printBoard();
                    game.userTurn();
                    isGameDone = game.isGameDone();
                }

            }

        }
    }
}
