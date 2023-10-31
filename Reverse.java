public class Reverse {
    public static void main(String[] args) {
        // makes a reverse placer string
        String reversee = "";
        // takes in a string from command named original in for loop and everthing stays
        // inside
        for (String original : args) {
            // for loop run the length of string with charAt which is index peice thing
            for (int i = 0; i < original.length(); i++) {
                reversee = original.charAt(i) + reversee;
            }
            // prints results
            System.out.println("The Original string is : " + original);
            System.out.println("The Reverse string is : " + reversee);

        }

    }
}