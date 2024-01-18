package crackingCodingInterview;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;


/**
 *
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right
 *
 * public Arraylist<Pair> getPath(boolean[][] field)
 *
 *
 * Example:
 *
 * for the following grid the path is available:
 *
 * {
 * {true, true, true, false, true},
 * {true, false, false, false, true},
 * {true, true, true, false, true},
 * {true, true, true, true, true},
 * }
 *
 */
public class RobotPath {

    public static void main(String[] args) {
        boolean[][] field = new boolean[][]{
                {true, true, true, true, true},
                {false, false, false, false, true},
                {true, true, true, false, true},
                {true, true, true, true, true},

        };
        RobotPath robotPath = new RobotPath();
        printPairs(robotPath.getPath(field));
    }

    private static void printPairs(ArrayList<Pair> path) {
        if (path == null)
            System.out.println("No root");
        else {
            for (Pair p : path) {
                System.out.println("[" + p.getFirst() + ", " + p.getSecond() + " ]");
            }
        }
    }

    ArrayList<Pair> getPath(boolean[][] field) {
        if (field == null || field.length == 0) {
            return null;
        }
        ArrayList<Pair> path = new ArrayList<>();
        HashSet<Pair> failedPoints = new HashSet<>();
        if (getPath(field, field.length - 1, field[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] field, int row, int column, ArrayList<Pair> path, HashSet<Pair> failedPoints) {
        if (row < 0 || column < 0 || !field[row][column]) {
            return false;
        }

        Pair<Integer, Integer> point = new Pair<>(row, column);
        if (failedPoints.contains(point)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (column == 0);

        if (isAtOrigin || getPath(field, row -1, column, path, failedPoints) || getPath(field, row, column - 1, path, failedPoints)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point);
        return false;
    }
}
