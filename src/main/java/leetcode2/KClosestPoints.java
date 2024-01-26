package leetcode2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 *
 * Given an array of points where points[i] = [x, y] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0)
 *
 * For example given array {1,3} {-2,2} and k=1, method should return {-2,2}
 *
 */
public class KClosestPoints {

    private static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public double distance;

        public Point(int[] coordinates) {
            this.x = coordinates[0];
            this.y = coordinates[1];
            distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }

        @Override
        public int compareTo(Point o) {
            return (int) Math.ceil(this.distance - o.distance);
        }

        @Override
        public String toString() {
            return String.format("%d : %d (%.2f)", x, y, distance);
        }
    }


    public List<Point>closestPoints(Point[] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(k + 1, Comparator.reverseOrder());
//        PriorityQueue<Point> queue =
//                new PriorityQueue<>(k + 1, (a, b) -> (int) Math.ceil(b.distance - a.distance));

        for (Point p : points) {
            queue.add(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return StreamSupport
                .stream(queue.spliterator(), true)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        KClosestPoints kClosestPoints = new KClosestPoints();
        int[][] points = new int[][]{{1, 3}, {-2, 2}, {5, 1}, {2, 0}};
        Point[] pointsArr = Arrays
                .stream(points)
                .map(Point::new)
                .collect(Collectors.toList())
                .toArray(new Point[0]);

        List<Point> result = kClosestPoints.closestPoints(pointsArr, 3 );
        for (Point p : result) {
            System.out.println(p);
        }
    }
}
