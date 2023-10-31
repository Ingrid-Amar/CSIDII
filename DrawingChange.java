
import java.awt.Font;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.*;

public class DrawingChange {
    public static void main(String[] args) {
        // set the scale of the coordinate system
        StdDraw.setXscale(-1, 1.0);
        StdDraw.setYscale(-1, 1);
        Font font = new Font("Edwardian Script ITC", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdAudio.play("cats-meow-81221.wav");
        StdDraw.enableDoubleBuffering();
        /*
         * while (StdDraw.hasNextKeyTyped() == true) {
         * StdDraw.nextKeyTyped();
         * if (StdDraw.isKeyPressed(87)) { // this is h
         * StdDraw.picture(0, -.25, "kitten.jpg");
         * StdDraw.setPenColor(StdDraw.ORANGE);
         * StdDraw.text(0, .5, "Happy Kitty!");
         * StdAudio.play("cat-89108.wav");
         * StdDraw.clear();
         * 
         * } else if (StdDraw.isKeyPressed(65)) { // this is a
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("cat-98721.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(68)) { // this is p
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("cat-meow-6336.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(83)) { // this is y
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("cat-meow-14536.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(32)) { // this is space
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("cat-meow-99835.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(75)) { // this is k
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("cat-purring-and-meow-5928.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(73)) { // this is i
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("kitten-meow-85182.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(84)) { // this is t
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("fiji-meow-01-86859.wav");
         * StdDraw.clear();
         * } else if (StdDraw.isKeyPressed(89)) { // this is y
         * StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         * StdAudio.play("sleepy-cat-putting-and-meowing-39248.wav");
         * StdDraw.clear();
         * }
         * // mouse location
         * double x = StdDraw.mouseX();
         * double y = StdDraw.mouseY();
         * StdDraw.filledCircle(x, y, 0.05);
         * StdDraw.show();
         * StdDraw.pause(1);
         * }
         */

    }
}
