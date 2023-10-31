public class ArrayHelper {
    public static void main(String[] args) {
        int[] myArray = { 8, 6, 7, 5, 3, 0, 9 };
        int[] baseArray = { 6, 5, 9, 2, 1, 8 };
        int[] my2Darray = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
        //the index
        int num = 7;
        int ind = indexOf(num, int[] myArray);
        //the concat
        int[] con = concat(int[] myArray, int[] baseArray);
        //the average
        double average = avg(int[] myArray);
        //the maximum
        int maximum = max(int[] myArray);
        //the minimum
        int minimum = min(int[] myArray);
        //the shuffle function
        void shuf = shuffle(int[] myArray);
        //the print funciton
        void prin = print(int[] myArray);
        //the initalize 
        int[] init = initalize(num, int 8);
        //flattening a array
        int[] flat = flatten(int[][] my2Darray);

    }
}