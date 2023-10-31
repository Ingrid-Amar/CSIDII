public class LeapYear {
    public static void main(String[] args) {
        // makes a year input for user
        int y = Integer.parseInt(args[0]);

        // make a if statement with or which is || to find if it is a leap year if not
        // prints not a leap year
        if ((y % 400 == 0) || (y % 100 == 0) || (y % 4 == 0)) {
            System.out.println("Yes, " + y + " is a Leap Year.");
        } else {
            System.out.println("No, " + y + " is not a Leap Year.");
        }
    }
}
// java LeapYear.java 2023

// I googled how to do if else statements online and how to do or/and in if line
// Sources
// https://stackoverflow.com/questions/1795808/and-and-or-in-if-statements
// https://www.w3schools.com/java/java_conditions.asp