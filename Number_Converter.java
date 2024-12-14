import java.util.Scanner;
import java.lang.Math;
public class Number_Converter {
    public static int toDecimal (String n, int c) {
        switch (c) {
            case 2:
                int m = n.length (), s = 0;
                for (int i = 0; i < m; i++)
                    if (n.charAt (m - i - 1) == '1')
                        s += (int) Math.pow (2, i);
                return s;
            case 3:
                m = n.length (); s = 0;
                for (int i = 0; i < m; i++) {
                    int u = Integer.parseInt (n.substring (m - i - 1, m - i));
                    if (u != 0)
                        s += (int) (u * Math.pow (8, i));
                } return s;
            case 4:
                String M = "ABCDEF";
                m = n.length (); s = 0;
                for (int i = 0; i < m; i++) {
                    try {
                        int u = Integer.parseInt (n.substring (m - i - 1, m - i));
                        if (u != 0)
                            s += (int) (u * Math.pow (16, i));
                    } catch (Exception NumberFormatException) {
                        s += (int) ((M.indexOf (n.charAt (m - i - 1)) + 10) * (Math.pow (16, i)));
                    }
                } return s;
        } return 0;
    } public static void toBinary (String n, int c) {
        switch (c) {
            case 1:
                int m = Math.abs (Integer.parseInt (n));
                StringBuilder S = new StringBuilder ();
                while (m >= 1) {
                    S.append (m % 2);
                    m = m/2;
                } System.out.println ("\n--------------------\nBinary equivalent = " + S.reverse ());
                break;
            case 3:
                StringBuilder BS = new StringBuilder (); S = new StringBuilder ();
                for (int i = 0; i < n.length (); i++) {
                    int u = Integer.parseInt (n.substring (i, i + 1)), C = 0;
                    while (C != 3) {
                        S.append (u % 2);
                        u = u/2;
                        C++;
                    } S.reverse ();
                    BS.append (S);
                    S = new StringBuilder ();
                } while (BS.charAt (0) == '0')
                    BS.deleteCharAt (0);
                System.out.println ("Binary equivalent = " + BS);
                break;
            case 4:
                BS = new StringBuilder (); S = new StringBuilder ();
                String M = "ABCDEF";
                for (int i = 0; i < n.length (); i++) {
                    int C = 0;
                    try {
                        int u = Integer.parseInt (n.substring (i, i + 1));
                        while (C != 4) {
                            S.append (u % 2);
                            u = u/2;
                            C++;
                        } S.reverse ();
                        BS.append (S);
                        S = new StringBuilder ();
                    } catch (Exception NumberFormatException) {
                        int u = M.indexOf (n.substring (i, i + 1)) + 10;
                        C = 0;
                        while (C != 4) {
                            S.append (u % 2);
                            u = u/2;
                            C++;
                        } S.reverse ();
                        BS.append (S);
                        S = new StringBuilder ();
                    }
                } while (BS.charAt (0) == '0')
                    BS.deleteCharAt (0);
                System.out.println ("Binary equivalent = " + BS);
                break;
        }
    } public static void toOctal (String n, int c) {
        switch (c) {
            case 1:
                int m = Math.abs (Integer.parseInt (n));
                StringBuilder S = new StringBuilder ();
                while (m >= 1) {
                    S.append (m % 8);
                    m = m/8;
                } System.out.println ("Octal equivalent = " + S.reverse ());
                break;
            case 2:
                S = new StringBuilder ();
                int s = 0, C = 0; m = n.length ();
                for (int i = 0; i < m; i++) {
                    if (n.charAt (m - i - 1) == '1')
                        s += (int) Math.pow (2, C);
                    C++;
                    if (C == 3 || i == n.length () - 1) {
                        S.append (s);
                        s = 0; C = 0;
                    }
                } System.out.println ("Octal equivalent = " + S.reverse ());
                break;
            case 4:
                int r = toDecimal (n, 4);
                toOctal (Integer.toString (r), 1);
                break;
        }
    } public static void toHexadecimal (String n, int c) {
        switch (c) {
            case 1:
                int m = Math.abs (Integer.parseInt (n));
                StringBuilder S = new StringBuilder ();
                String u = "ABCDEF";
                while (m >= 1) {
                    int r = m % 16;
                    if (r < 10)
                        S.append (r);
                    else
                        S.append (u.charAt (r - 10));
                    m = m/16;
                } System.out.println ("Hexadecimal equivalent = " + S.reverse ());
                break;
            case 2:
                S = new StringBuilder (); u = "ABCDEF"; m = n.length ();
                int s = 0, C = 0;
                for (int i = 0; i < m; i++) {
                    if (n.charAt (m - i - 1) == '1')
                        s += (int) Math.pow (2, C);
                    C++;
                    if (C == 4 || i == m - 1) {
                        if (s < 10)
                            S.append (s);
                        else
                            S.append (u.charAt (s - 10));
                        s = 0; C = 0;
                    }
                } System.out.println ("Hexadecimal equivalent = " + S.reverse ());
                break;
            case 3:
                int r = toDecimal (n, 3);
                toHexadecimal (Integer.toString (r), 1);
        }
    } public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("\nYou are now using 'NUMBER CONVERTER'.");
        System.out.print ("\nYou will be required to choose the base of your input from the menu using corresponding choice codes, and enter an integer thereafter.");
        System.out.print ("\nThis program considers only absolute values, and will print the equivalent numbers in the other three bases.");
        System.out.println ("\n\nMenu:\n1=> DECIMAL            2=> BINARY            3=> OCTAL            4=> HEXADECIMAL");
        System.out.print ("\nChoose your input base from the codes '1, 2, 3, 4': ");
        while (true) {
            try {
                int c = sc.nextInt ();
                if (c == 1) {
                    System.out.print ("\nEnter the number in Decimal: ");
                    String n = sc.next ();
                    toBinary (n, c);
                    toOctal (n, c);
                    toHexadecimal (n, c);
                    System.out.println ("--------------------");
                    break;
                } else if (c == 2) {
                    System.out.print ("\nEnter the number in Binary: ");
                    String n = sc.next ();
                    if (n.charAt (0) == '-')
                        n = n.substring (1);
                    while (((n.split ("0", -1)).length + (n.split ("1", -1)).length) - 2 < n.length ()) {
                        System.out.print ("\nInvalid entry!\nEnter a valid number in Binary: ");
                        n = sc.next ();
                        if (n.charAt (0) == '-')
                            n = n.substring (1);
                    } System.out.println ("\n--------------------\nDecimal equivalent = " + toDecimal (n, c));
                    toOctal (n, c);
                    toHexadecimal (n, c);
                    System.out.println ("--------------------");
                    break;
                } else if (c == 3) {
                    System.out.print ("\nEnter the number in Octal: ");
                    String n = sc.next ();
                    if (n.charAt (0) == '-')
                        n = n.substring (1);
                    while (n.contains ("8") || n.contains ("9")) {
                        System.out.print ("\nInvalid entry!\nEnter a valid number in Octal: ");
                        n = sc.next ();
                        if (n.charAt (0) == '-')
                            n = n.substring (1);
                    } System.out.println ("\n--------------------\nDecimal equivalent = " + toDecimal (n, c));
                    toBinary (n, c);
                    toHexadecimal (n, c);
                    System.out.println ("--------------------");
                    break;
                } else if (c == 4) {
                    System.out.print ("\nEnter the number in Hexadecimal: ");
                    String n = sc.next ();
                    n = n.toUpperCase ();
                    int x = 0;
                    if (n.charAt (0) == '-')
                        n = n.substring (1);
                    for (int i = 0; i <= 9; i++)
                        x += (n.split (Integer.toString (i), -1)).length - 1;
                    for (int i = 65; i <= 70; i++)
                        x += (n.split (Character.toString ((char) i), -1)).length - 1;
                    while (x < n.length ()) {
                        System.out.print ("\nInvalid entry!\nEnter a valid number in Hexadecimal: ");
                        n = sc.next ();
                        n = n.toUpperCase ();
                        x = 0;
                        if (n.charAt (0) == '-')
                            n = n.substring (1);
                        for (int i = 0; i <= 9; i++)
                            x += (n.split (Integer.toString (i), -1)).length - 1;
                        for (int i = 65; i <= 70; i++)
                            x += (n.split (Character.toString ((char) i), -1)).length - 1;
                    } System.out.println ("\n--------------------\nDecimal equivalent = " + toDecimal (n, c));
                    toBinary (n, c);
                    toOctal (n, c);
                    System.out.println ("--------------------");
                    break;
                } else
                    System.out.print ("\nInvalid entry!\nEnter a valid code (1, 2, 3 or 4): ");
            } catch (Exception NumberFormatException) {
                System.out.println ("\n--------------------\nInvalid entry! Run the program again and enter a valid code.");
                break;
            }
        }
    }
}
/* Variable Notations:

* sc -> Scanner object
* c -> Choice code
* n -> Input string
* i -> For tracking 'for loop' iterations
* x -> Count of valid hexadecimal digits/characters
* m -> Length of 'n' OR Integer equivalent of 'n'
* s -> Sum
* u -> Integer equivalent of a character in 'n'
* M -> "ABCDEF"
* S -> StringBuilder
* BS (Big S) -> Main StringBuilder
* C -> Count of 'while loop' iterations
*/