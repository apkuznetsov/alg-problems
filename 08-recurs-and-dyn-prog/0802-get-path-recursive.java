/* 8.2. Робот стоит в левом верхнем углу сетки,
 * состоящей из r строк и c столбцов.
 * Робот может перемещаться в двух направлениях:
 * вправо и вниз, но некоторые ячейки сетки заблокированы,
 * т.е. робот через них прохдить не может.
 * Разработайте алгоритм построения маршрута от левого верхнего
 * до правого нижнего угла.*/

package ssau.kuznetsov;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (col < 0 || row < 0 || !maze[row][col])
            return false;

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin
                || getPath(maze, row, col - 1, path)
                || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0)
            return null;

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path))
            return path;

        return null;
    }
}
