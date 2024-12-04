import java.util.Scanner;
public class Matrix_Multiplication {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter number of rows in 1st Matrix: ");
        int l = sc.nextInt ();
        System.out.print ("Enter number of columns in 1st Matrix: ");
        int m = sc.nextInt ();
        System.out.print ("\nEnter number of rows in 2nd Matrix: ");
        int n = sc.nextInt ();
        System.out.print("Enter number of columns in 2nd Matrix: ");
        int o = sc.nextInt ();
        int [] [] a = new int [l] [m], b = new int [n] [o];
        if (m != n)
            System.out.println ("\n--------------------\nMatrices of given order cannot be multiplied.");
        else {
            System.out.println ("\nEnter 1st Matrix:");
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < m; j++)
                    a [i] [j] = sc.nextInt ();
            } System.out.println ("\nEnter 2nd Matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < o; j++)
                    b [i] [j] = sc.nextInt ();
            } System.out.println ("\n--------------------\nMultiplied Matrix:");
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < o; j++) {
                    int s = 0;
                    for (int k = 0; k < m; k++)
                        s += (a [i] [k]) * (b [k] [j]);
                    System.out.print (s + "   ");
                } System.out.println ();
            }
        }
    }
}