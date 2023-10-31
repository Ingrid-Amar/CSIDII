
/*Extend DoWhile.java (from class today) to print out the number entered into
 the command line as 2^x + r where x is the number of powers of 2 in the number
  and r is the remainder.*/

public class ExtendedDoWhile {
    public static void main(String[] args) {
        // takes number
        int m = Integer.parseInt(args[0]);
        // turns int to string
        double num1 = m;
        // square root of number
        double squroot = Math.sqrt(num1);
        // rounds number up
        double trt = Math.ceil(squroot);
        // turns number to right number
        int change = (int) (trt - 1);
        // gets the remainder
        int remainder = (int) (m - Math.pow(change, 2));
        // int randomNumber = (int) (r * n) + offset;
        int runs = (int) (Math.pow(2, change) + remainder);
        // starting number
        int milesRun = 0;
        // gives a max
        double runningThreshold = 26.2;
        // says number input
        System.out.println("You entered the number " + m);
        do { // says to add milesrun and runs till you hit the threshold with the while
             // statement
            milesRun += runs;
            System.out.println("Running " + runs + " today.");
        } while (milesRun <= runningThreshold);
        System.out.println("I ran " + milesRun);
        System.out.println(change);
    }
}