package recursion;

import lombok.Getter;

import java.util.Stack;

/**
 *
 * Calculate the number of steps required to move a stack of disks from one peg to
 * the other on a Hanoi Tower, having three pegs (A, B, C).
 *
 * Number of disks is N, and initially they are stacked on one peg in decreasing size order
 * (bottom-top)
 *
 * - you can move only one disk at a time from peg to peg
 * - you can not lay bigger disk on top of a smaller disk
 *
 *
 * @author Konstantin Antipin
 */
public class HanoiTower {


    private int height;

    private Stack<Integer> pegA = new Stack<>();
    private Stack<Integer> pegB = new Stack<>();
    private Stack<Integer> pegC = new Stack<>();

    private boolean verbose;

    @Getter
    private int diskMovesTotal=0;

    public HanoiTower(int height, boolean verbose) {
        this.height = height;
        this.verbose = verbose;
        for (int i = height-1; i >= 0; i--) {
            pegA.push(i+1);
        }

    }

    public void solve() {
        printPegs();
        moveTower(height, Peg.A, Peg.B, Peg.C);
    }

    public void moveTower(int height, Peg fromPeg, Peg toPeg, Peg withPeg) {
        if (height >= 1) {
            if (verbose && height -1 > 1)
                System.out.println("Moving tower of size: " + (height-1) + " from: " + fromPeg + " to: " + withPeg + " using: " + toPeg);
            moveTower(height - 1, fromPeg, withPeg, toPeg);
            if (verbose && height -1 > 1)
                System.out.println("Tower moved");

            moveDisk(fromPeg, toPeg);

            if (verbose && height -1 > 1)
                System.out.println("Moving tower of size: " + (height-1) + " from: " + withPeg + " to: " + toPeg + " using: " + fromPeg);
            moveTower(height - 1, withPeg, toPeg, fromPeg);
            if (verbose && height -1 > 1)
                System.out.println("Tower moved");
        }
    }

    private void moveDisk(Peg fromPeg, Peg toPeg) {
        diskMovesTotal++;
        int disk = -1;
        switch (fromPeg) {
            case A:
                disk = pegA.pop();
                break;
            case B:
                disk = pegB.pop();
                break;
            case C:
                disk = pegC.pop();
                break;
            default:
                break;
        }

        switch (toPeg) {
            case A:
                pegA.push(disk);
                break;
            case B:
                pegB.push(disk);
                break;
            case C:
                pegC.push(disk);
                break;
            default:
                break;
        }
//        if (verbose)
//            System.out.println("Moving disk from: " + fromPeg + " to: " + toPeg);
        printPegs();
    }

    private void printPegs() {
        int lines = Math.max(pegA.size(), pegB.size());
        lines = Math.max(lines, pegC.size());

        StringBuilder line = new StringBuilder();
        System.out.println();
        for (int i = lines-1; i >= 0 ; i--) {
            String aSymbol = i < pegA.size() ? getFromStack(pegA, i) : " ";
            String bSymbol = i < pegB.size() ? getFromStack(pegB, i) : " ";
            String cSymbol = i < pegC.size() ? getFromStack(pegC, i) : " ";
            System.out.println(aSymbol + "   " + bSymbol + "   " + cSymbol);
        }
        System.out.println("---------");
        System.out.println("A   B   C\n");
    }

    /**
     * dig out of stack the element at level 'index', where 0-indexed is the bottom one.
     * But keep stack intouch.
     *
     * @param index
     * @return integer value transferred to char
     */
    private String getFromStack(Stack<Integer> stack, int index) {
        return stack.elementAt(index).toString();
    }

    static enum Peg {
        A, B, C;
    }

    public static void main(String[] args) {
        HanoiTower tower = new HanoiTower(15, true);
        tower.solve();
        System.out.println("The total number of moves: " + tower.getDiskMovesTotal());
    }
}
