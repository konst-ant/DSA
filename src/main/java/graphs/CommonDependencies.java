package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * You have jar package dependencies represented as a list List<Package> with the following package data structure:
 * <p>
 * class Package {
 * public String name;
 * public List<Package> dependencies;
 * }
 * <p>
 * write a method, which given the name of the package, returns the list of all packages that depend on given package.
 * public List<String> getDependants(String packageName, List<Package> dependencies);
 * <p>
 * For example, given a list of two elements and package "B", should return list of:
 * "A", "D", "E"
 * <p>
 * D ---
 * ^    |
 * |    v
 * A -> B -> C -> D
 * <p>
 * E -> D
 */
public class CommonDependencies {

    private static class Package {
        public String name;
        public List<Package> dependencies;

        public Package(String name, List<Package> dependencies) {
            this.name = name;
            this.dependencies = dependencies;
        }

        public Package(String name) {
            this.name = name;
            this.dependencies = new ArrayList<>();
        }
    }

    public List<String> getDependants(String packageName, List<Package> dependencies) {
        return null;
    }

    public static void main(String[] args) {

    }
}
