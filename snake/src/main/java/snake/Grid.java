/**
 * Grid
 */
package snake;
public class Grid {

        String[][] grid;
        int nRows;
        int nCols;
        int[][] intGrid;

        public Grid(int nRows, int nCols) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.grid = new String[nRows][nCols];
            this.intGrid = genIntGrid();
            for (int r = 0; r < nRows; r++) {
                for (int c = 0; c < nCols; c++) {
                    grid[r][c] = " ";
                }
            }
        }
        
        public String[][] getGrid() {
            return this.grid;        
        }
        
        public int getNRows() {
            return this.nRows;
        }

        public int getNCols() {
            return this.nCols;
        }

        public String toString() {
            String out = "";
            out += "+ ".repeat(this.nCols + 2) + "\n";
            for (int r = 0; r < this.nRows; r++) {
                out += "+ ";
                for (int c = 0; c < this.nCols; c++) {
                    out += grid[r][c] + " ";
                }
                out += "+ \n";
            }
            out += "+ ".repeat(this.nCols + 2) + "\n";
            return out;
        }

        public boolean pointInsideGrid(int y, int x) {
            return 0 <= y && y <= this.nRows && 0 <= x && x <= this.nCols;    
        }

        public void placeObject(int y, int x, String o) {
            this.grid[y][x] = o;
        }

        public void dropBlock(int y, int x) {
            placeObject(y, x, "#");
        }

        public void dropFood(int y, int x) {
            placeObject(y, x, "o");
        }

        public void updateGrid(Snake snake) {
            for (int r = 0; r < nRows; r++) {
                for (int c = 0; c < nCols; c++) {
                    if (this.grid[r][c].equals("*")) {
                        this.grid[r][c] = " ";
                    }
                }
            }
            int y = snake.getPos()[0];
            int x = snake.getPos()[1];

            if (snake.isAlive()) {
                this.grid[y][x] = "*";
            }

        }

        public int[][] genIntGrid() {
            int[][] arr = new int[this.nRows][this.nCols];
            for (int r = 0; r < this.nRows; r++) {
                for (int c = 0; c < this.nCols; c++) {
                    arr[r][c] = 0;
                }
            }
            return arr;

        }

        public void decrIntGrid() {
            for (int r = 0; r < this.nRows; r++) {
                for (int c = 0; c < this.nCols; c++) {
                    if (this.intGrid[r][c] > 0){
                        this.intGrid[r][c] -= 1;
                    }
                }   
            }
        }

        public void updateGrids(Snake snake) {
            for (int r = 0; r < this.nRows; r++) {
                for (int c = 0; c < this.nCols; c++) {
                    if (this.grid[r][c].equals("*")) {
                        this.grid[r][c] = " ";
                    }
                }
            }
            if (snake.isAlive() == true) {
                int[] pos = snake.getPos();
                this.intGrid[pos[0]][pos[1]] = snake.getSize();
            }
            for (int r = 0; r < this.nRows; r++) {
                for (int c = 0; c < this.nCols; c++) {
                    if (this.intGrid[r][c] > 0) {
                        this.grid[r][c] = "*";
                    }
                }
            }
            decrIntGrid();
        }

        public String getCell(int y, int x) {
            return "" + this.grid[y][x];
        }

    
}