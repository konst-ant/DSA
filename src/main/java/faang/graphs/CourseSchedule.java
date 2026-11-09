package faang.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC 207: Course Schedule.
 * Determines whether all courses can be finished given prerequisite pairs,
 * detecting cycles via Kahn's topological sort (BFS on in-degrees).
 * Precondition: numCourses must not be negative and prerequisites must not be null.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            throw new IllegalArgumentException("numCourses must not be negative");
        }
        if (prerequisites == null) {
            throw new IllegalArgumentException("prerequisites must not be null");
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            for (int next : graph.get(course)) {
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return visited == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solver = new CourseSchedule();
        System.out.println(solver.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(solver.canFinish(2, new int[][]{{1, 0}, {0, 1}}));

        // Edge case: disconnected courses with no prerequisites at all can always finish.
        System.out.println(solver.canFinish(4, new int[][]{}));
    }
}
