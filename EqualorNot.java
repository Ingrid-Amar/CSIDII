//import java.util.Scanner;

public class EqualorNot {
    public static void main(String[] args) {
        // for loop to run once
        for (int i = 0; i < 1; i++) {
            // names the 2 arguments
            String nums1 = args[0];
            String nums2 = args[1];
            // says if they equal or not with equal function built into jave
            String eqorno = (nums1.equals(nums2)) ? "Equal" : "Not Equal";
            // prints yes or no
            System.out.println(eqorno);
        }
    }

}