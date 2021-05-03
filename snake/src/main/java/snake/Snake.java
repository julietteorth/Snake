/**
 * Snake
 */
package snake;
public class Snake {

    public int[] pos = new int[2];
    public int[] speed = new int[2];
    public String color;
    public boolean alive;
    public int size;

    public Snake(int[] pos, int[] speed, String color) {
        this.pos = pos;
        this.speed = speed;
        this.color = color;
        this.size = 1;
        this.alive = true;
    }

    public int[] getPos() {
        return this.pos;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isAlive() {
        return alive;
    }

    public void killSnake() {
        this.alive = false;
    }

    public int[] getNextPosition() {
        int[] nextPostiton = {this.pos[0] + this.speed[0], this.pos[1] + this.speed[1]};
        return nextPostiton;
    }

    public void turnRight() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = 1;
            this.speed[1] = 0;
        }
        else if (this.speed[0] == 1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = -1;
        }
        else if (this.speed[0] == 0 && this.speed[1] == -1) {
            this.speed[0] = -1;
            this.speed[1] = 0;
        }
        else {
            this.speed[0] = 0;
            this.speed[1] = 1;
        }
    }

    public void turnLeft() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = -1;
            this.speed[1] = 0;
        }
        else if (this.speed[0] == 1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = 1;
        }
        else if (this.speed[0] == 0 && this.speed[1] == -1) {
            this.speed[0] = 1;
            this.speed[1] = 0;
        }
        else {
            this.speed[0] = 0;
            this.speed[1] = -1;
        }
    }

    public void moveOn(Grid grid) {
        int[] nextpos = getNextPosition();
        
        if (nextpos[1] > grid.getNCols()) {
            nextpos[1] = ((nextpos[1]) % grid.getNCols() + grid.getNCols()) % grid.getNCols();
        }
        else if(nextpos[0] < grid.getNRows()) {
            nextpos[0] = ((nextpos[0]) % grid.getNRows() + grid.getNRows()) % grid.getNRows();
        }
        String cell = grid.getCell(nextpos[0], nextpos[1]);
        
        if (cell.equals("#") || cell.equals("*")) {
            killSnake();
        }
        else {
            this.pos[1] = nextpos[1];
            this.pos[0] = nextpos[0];
            if (grid.getCell(this.pos[0], this.pos[1]).equals("o")) {
                this.size += 1;
            }
        }
    }


    public String toString() {
        // TODO Auto-generated method stub
        return "position: " + this.pos + ", speed: " + this.speed + ", color: " + this.color + ", size: " + this.size;
    }

    
}