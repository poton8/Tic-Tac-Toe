import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// class extends JFrame
public class Game extends JFrame {

    // Initialization the value of
    // current card is 1 .
    private int currentCard = 1;

    // Declaration of objects
    // of CardLayout class.
    private CardLayout cl;

    int alternate = 0;
    JButton buttons[] = new JButton[9];

    public Game()
    {

        // Function to set visibility of JFrame
        setTitle("Tic Tac Toe");

        // Function to set visibility of JFrame
        setSize(900, 700);

        // Creating Object of "Jpanel" class
        JPanel cardPanel = new JPanel();

        // Initialization of object "c1"
        // of CardLayout class.
        cl = new CardLayout();

        // set the layout
        cardPanel.setLayout(cl);


        // --------  Start Screen --------
        JPanel jp1 = new JPanel();

        // create a object of JTextField with 16 columns and a given initial text
        JTextField t = new JTextField(16);

        // create a label to display text
        JLabel l = new JLabel("nothing entered");

        // create a new button
        JButton submit = new JButton("submit");

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {

                // if condition apply
                if (currentCard < 2 && !t.getText().isEmpty())
                {

                    // increment the value of currentcard by 1
                    currentCard += 1;

                    // show the value of currentcard
                    cl.show(cardPanel, "" + (currentCard));
                }
            }
        });

        jp1.add(t);
        jp1.add(l);
        jp1.add(submit);

        // -------- Game Screen --------
        JPanel jp2 = new JPanel(new GridLayout());

        // Initialization of object

        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());

            jp2.add(buttons[i]);
        }

        // Adding the cardPanel on "jp1"
        cardPanel.add(jp1, "1");

        // Adding the cardPanel on "jp2"
        cardPanel.add(jp2, "2");

        getContentPane().add(cardPanel, BorderLayout.NORTH);

    }
    private class buttonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {

            JButton buttonClicked = (JButton)e.getSource();
            if(alternate%2 == 0)
                buttonClicked.setText("X");
            else
                buttonClicked.setText("O");

            if(checkForWin() == true)
            {
                if(alternate%2 == 0) {
                    JOptionPane.showConfirmDialog(null, "X Won.");
                    resetButtons();
                }
                else {
                    JOptionPane.showConfirmDialog(null, "O Won.");
                    resetButtons();
                }
            }
            if(alternate == 9)
            {
                JOptionPane.showConfirmDialog(null, "Tied.");
                resetButtons();
            }
            alternate++;

        }
        //Check if anyone won
        public boolean checkForWin()
        {
            //horizontal win check
            if( checkAdjacent(0,1) && checkAdjacent(1,2) )
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;

            //vertical win check
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;

            //diagonal win check
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else
                return false;
        }

        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }

    }

    //Reset the screen
    public void resetButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }

    // Main Method
    public static void main(String[] args)
    {
        Game cl = new Game();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
