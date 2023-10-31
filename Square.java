public class Square {
    public static void main(String[] args) {
        int s = Integer.parseInt(args[0]);
        int l = s;

        if (s >= 25) {
            System.out.println("Number to big");
        } else if (s >= 1) {
            for (int i = 1; i <= s; i++) {
                for (int j = 1; j <= l; j++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
            System.out.println("The Power is of " + s + " is " + Math.pow(s, 2));
        } else {
            System.out.println("Not a valid number");
        }

    }
}
