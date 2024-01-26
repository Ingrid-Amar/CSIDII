public class CustomString {

    // instance variables (declare here).
    private char[] value;

    // Default constructor.
    public CustomString() {
    }

    // Constructor with arguments.
    public CustomString(char[] value) {
        this.value = value;
    }

    // Constructor with arguments.
    public CustomString(String value) {
        this.value = new char[value.length()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = value.charAt(i);
        }
    }

    // Instance method.
    public int length() {
        return this.value.length;
    }

    // Instance method.
    public char randomChar() {
        int randomIndex = this.randomNumber(); // calling a private method within our class.
        return this.value[randomIndex];
    }

    // Instance method.
    public char charAt(int i) {
        return this.value[i];
    }

    public CustomString substring(int i, int j) {

        char[] substring = new char[j - i];
        for (int start = i; start < j; start++) {
            substring[start - i] = this.value[start];
        }

        return new CustomString(substring);
    }

    // Private instance method (used internally to the class).
    private int randomNumber() {
        return (int) (Math.random() * this.value.length);
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < this.value.length; i++) {
            returnString += this.value[i];
        }
        return returnString;
    }

    public boolean contains(String substring, String substring2) {
        substring = substring == null ? "" : substring;
        substring2 = substring2 == null ? "" : substring2;
        return substring.toLowerCase().contains(substring2.toLowerCase());
    }

    public boolean startsWith(String word) {
        word = "Icecream";
        if (word.startsWith("Ice")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean endsWith(String word) {
        word = "Icecream";
        if (word.startsWith("cream")) {
            return true;
        } else {
            return false;
        }
    }

    public int indexof(String pattern) {
        pattern = "sassy words go here";
        return pattern.indexOf('s');
    }

    public int indexof(String pattern, int i) {
        pattern = "sassy words go here";
        return pattern.indexOf('s', 4);
    }

    public String concat(String t) {
        int words = t.length();
        if (words == 0) {
            return this;
        } else {
            String temp = "Addition" + t;
            return temp;
        }

    }

    public int compareTo(String t) {
        int k = value.length;
        int h = t.value.length;
        if (k > h) {
            return k - h;
        } else if (h > k) {
            return h - k;
        } else {
            return 0;
        }
    }

    public String toLowerCase() {
        String txt = "Why do I have to come up with strings";
        return txt.toLowerCase();

    }

    public String toUpperCase() {
        String txt = "Why do I have to come up with strings";
        return txt.toUpperCase();
    }

    public String replace(String a, String b) {
        String phrase = "Winter Wonder Land Soon";
        return phrase.replace(a, b);
    }

    public String trim() {
        String phrase = "       Winter Wonder Land Soon      ";
        return phrase.trim();
    }

    public String[] split(String delimiter) {
        String[] splits = string.split("\\|\\|");
        return splits;
    }

    public boolean equals(Object t) {

    }

}