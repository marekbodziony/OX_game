package src;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private char[] xo = new char[9];
    private char actSymbol = 'o';
    private boolean weHaveWinner = false;

    public void start() {
        for (int i = 0; i < 9; i++) {
            xo[i] = ' ';
        }

        while (!weHaveWinner) {
//            displayMenu();        // choose option from menu
            displayGame();
            askForSymbol();
        }
    }

    private void askForSymbol() {
        System.out.print("Put your symbol (" + actSymbol + "): ");
        String input = scanner.nextLine();

        if (input.length() == 2 && input.matches("[1-9][oxOX]")) {
            int pos = Integer.parseInt(input.substring(0, 1));
            char symbol = input.charAt(1);

            if (symbol == actSymbol && xo[pos - 1] == ' ') {
                xo[pos - 1] = symbol;
                checkIfWin();
                if (actSymbol == 'x') actSymbol = 'o';
                else actSymbol = 'x';
            } else {
                askForSymbol();
            }
        }
//        else if (input.length() == 2 && input.matches("[-][h]")){
//            // show help
//        }
 //        else if (input.length() == 2 && input.matches("[-][e]")){
//            // exit game
//        }
        else {
            askForSymbol();
        }
    }

    private void checkIfWin() {
        if ((xo[0] == actSymbol && xo[1] == actSymbol && xo[2] == actSymbol) ||
            (xo[3] == actSymbol && xo[4] == actSymbol && xo[5] == actSymbol) ||
            (xo[6] == actSymbol && xo[7] == actSymbol && xo[8] == actSymbol) ||
            (xo[0] == actSymbol && xo[4] == actSymbol && xo[7] == actSymbol) ||
            (xo[1] == actSymbol && xo[3] == actSymbol && xo[6] == actSymbol) ||
            (xo[1] == actSymbol && xo[4] == actSymbol && xo[7] == actSymbol) ||
            (xo[2] == actSymbol && xo[5] == actSymbol && xo[8] == actSymbol) ||
            (xo[0] == actSymbol && xo[4] == actSymbol && xo[8] == actSymbol) ||
            (xo[2] == actSymbol && xo[4] == actSymbol && xo[6] == actSymbol)){
            weHaveWinner = true;
            displayGame();
            System.out.println("Player '" + actSymbol + "' wins the Game!");
        }
    }

    private void displayGame() {
        System.out.println();
        System.out.println(" " + xo[0] + " | " + xo[1] + " | " + xo[2]);
        System.out.println("---+---+---");
        System.out.println(" " + xo[3] + " | " + xo[4] + " | " + xo[5]);
        System.out.println("---+---+---");
        System.out.println(" " + xo[6] + " | " + xo[7] + " | " + xo[8]);
        System.out.println();
    }

//    private void displayMenu(){
//        //choose human vs. human or human vs. AI
//    }
//    private void checkIfFinish(){
//        //check if game is finished (no one wins), ask to play again
//    }

}
