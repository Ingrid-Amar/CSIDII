public class MaxMin {
    public static void main(String[] args) {
        // calls to number for the choice of person and holder
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        // takes the given number to make 2 numbers for max and min
        int d = Math.max(a, b);
        int e = Math.max(b, c);

        int f = Math.min(a, b);
        int g = Math.min(b, c);
        // takes the max and min of every choose in if else statement to the one that is
        // true so that the known NOT max and min in the middle
        if (((a == Math.max(d, e)) || (a == Math.min(f, g))) && ((b == Math.min(f, g)) || (b == Math.max(d, e)))) {
            System.out.print(Math.max(d, e) + " " + c + " " + Math.min(f, g));
        } else if (((a == Math.max(d, e)) || (a == Math.min(f, g)))
                && ((c == Math.min(f, g)) || (c == Math.max(d, e)))) {
            System.out.print(Math.max(d, e) + " " + b + " " + Math.min(f, g));
        } else {
            System.out.print(Math.max(d, e) + " " + a + " " + Math.min(f, g));
        }
    }
}

// java MaxMin.java 57 37 9