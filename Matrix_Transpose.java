import java.util.Scanner;
public class Matrix_Transpose {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the number of Rows in the Matrix: ");
        int r = sc.nextInt ();
        System.out.print ("Enter the number of Columns in the Matrix: ");
        int c = sc.nextInt ();
        int [] [] m = new int [r] [c];
        System.out.println ("\nEnter the Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                m [i] [j] = sc.nextInt ();
        } System.out.println ("\nTranspose:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++)
                System.out.print (m [j] [i] + " ");
            System.out.println ();
        }
    }
}