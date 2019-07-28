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
            while(isGameDone != true)
            if(isTurn){
                game.printBoard();
                game.userTurn();
                game.aiTurn();
                isTurn = false;
            }

            else{
                game.aiTurn();
                game.printBoard();
                game.userTurn();
                isTurn = true;
            }

        }

    }
}
