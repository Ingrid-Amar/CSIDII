public class SwapIn {
    public static void main(String[] args) {
        // calls to number for the choice of person and holder
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // swaps the numbers
        int c = a;
        a = b;
        b = c;

        // prints out the swap
        System.out.println(a + " " + b);

    }
}
// java SwapIn.java 12 3