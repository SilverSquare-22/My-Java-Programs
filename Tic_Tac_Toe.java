import java.util.Scanner;
public class Tic_Tac_Toe {
    public static void main (String [] args) {
        System.out.println ("\nYou are now playing TIC-TAC-TOE!\n\nRules and Instructions:");
        System.out.println ("1=> This is a 3 × 3 grid game wherein two players take turns marking the grid with 'X' or 'O'.");
        System.out.println ("2=> The game always starts with 'X'.");
        System.out.println ("3=> The first player to get three of her/his marks in a single row, column or diagonal wins the game.");
        System.out.println ("4=> In case, the whole grid is filled without any three continuous marks, the game concludes to a tie.");
        System.out.println ("\nTo insert 'X' or 'O', the players can type out the position of the grid where they wish to insert. The position of each grid is given below:");
        Scanner sc = new Scanner (System.in);
        String [] [] T = new String [3] [3];
        String p1 = "", p2 = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                T [i] [j] = (i + 1) + "  " + (j + 1);
                System.out.print (T [i] [j] + "\t\t");
            } System.out.println ();
        } System.out.println ("------------------------------\n");
        while (true) {
            System.out.print ("Enter name of player 1: ");
            p1 = sc.next ();
            System.out.print ("Enter name of player 2: ");
            p2 = sc.next ();
            if (p1.equals (p2))
                System.out.println ("Two players cannot have the same name. Enter the correct names.\n");
            else
                break;
        } int pc = 1, s = 0;
        String e = "";
        System.out.println ("------------------------------");
        while ((!T [0] [0].equals (T [0] [1]) || !T [0] [1].equals (T [0] [2])) &&
                (!T [1] [0].equals (T [1] [1]) || !T [1] [1].equals (T [1] [2])) &&
                (!T [2] [0].equals(T [2] [1]) || !T [2] [1].equals(T [2] [2])) &&
                (!T [0] [0].equals(T [1] [0]) || !T [1] [0].equals(T [2] [0])) &&
                (!T [0] [1].equals(T [1] [1]) || !T [1] [1].equals(T [2] [1])) &&
                (!T [0] [2].equals(T [1] [2]) || !T [1] [2].equals(T [2] [2])) &&
                (!T [0] [0].equals(T [1] [1]) || !T [1] [1].equals(T [2] [2])) &&
                (!T [0] [2].equals(T [1] [1]) || !T [1] [1].equals(T [2] [0]))) {
            s++;
            if (s == 10)
                break;
            if (pc == 1) {
                System.out.print ("\n" + p1 + "'s turn:\nEnter the position of 'X': ");
                e = "X";
            } else {
                System.out.print ("\n" + p2 + "'s turn:\nEnter the position of 'O': ");
                e = "O";
            }
            while (true) {
                try {
                    int r = sc.nextInt (), c = sc.nextInt ();
                    if (r < 1 || r > 3 || c < 1 || c > 3)
                        System.out.print ("Invalid entry! Enter correct position: ");
                    else if (T [r - 1] [c - 1].equals ("X") || T [r - 1] [c - 1].equals ("O"))
                        System.out.print ("Grid already occupied! Enter another position: ");
                    else {
                        T [r - 1] [c - 1] = e;
                        pc = switch (pc) {
                            case 1 -> 2;
                            case 2 -> 1;
                            default -> pc;
                        };
                        break;
                    }
                } catch (Exception NumberFormatException) {
                    System.out.println ("\nIncompatible entry! Re-run the program and enter correct position.");
                    T [0] [0] = T [1] [1] = T [2] [2];
                    s = 0;
                    break;
                }
            } if (s != 0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (T [i] [j].equals ("X") || T [i] [j].equals ("O"))
                            System.out.print (T [i] [j] + "     ");
                        else
                            System.out.print ("       ");
                    } System.out.println ();
                }
            }
        } if (s != 0) {
            System.out.println ("------------------------------\n");
            if (s == 10)
                System.out.println ("It's a TIE!");
            else if (s % 2 == 0)
                System.out.println (p2.toUpperCase () + " is the WINNER!!!");
            else
                System.out.println (p1.toUpperCase () + " is the WINNER!!!");
        } System.out.println ("\n× ----- ×");
    }
}