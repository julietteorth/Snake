import snake.Snake;
import snake.Grid;
import java.lang.*;
/**
 * Main
 */

import snake.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("hello word");
        Grid g = new Grid(10, 20);
        int[] pos = {0, 0};
        int[] speed = {0, 1};
        Snake s = new Snake(pos, speed, "red");
        g.dropBlock(8, 8);
        int[][] foodpos =  {
                            {5, 4}, {6, 4},
                            {7, 4}, {8, 4}, 
                            {8, 5}, {8, 6}, 
                            {8, 7}
                            };
        for (int[] i : foodpos) {
            g.dropFood(i[0], i[1]); 
        }
        

        while (s.isAlive() == true) {
            for (int i = 0; s.isAlive() == true; i++) {
                if (i == 3 || i == 20 || i == 22 || i == 24 || i == 26) {
                    s.turnRight();
                }
                else if (i == 11 || i == 14 || i == 16 || i == 18 || i == 28) {
                    s.turnLeft();
                }
                s.moveOn(g);
                g.updateGrids(s);
                System.out.println(g);
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(s.getSize());
        }
    }
}