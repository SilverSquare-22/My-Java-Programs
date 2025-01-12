import java.util.Scanner;
public class Pascals_Triangle {
    public static int fact (int x) {
        if (x == 0 || x == 1)
            return 1;
        else
            return x * fact (x - 1);
    } public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter the number of rows: ");
        int n = sc.nextInt ();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++)
                System.out.print (" ");
            for (int j = 0; j <= i; j++)
                System.out.print ((fact (i)/(fact (i - j) * fact (j))) + " ");
            System.out.println ();
        }
    }
}