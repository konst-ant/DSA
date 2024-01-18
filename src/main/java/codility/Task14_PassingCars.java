package codility;


public class Task14_PassingCars {

    public int solution(int[] A) throws Exception {
        int seenCarsTravellingEast = 0;
        int passingCars = 0;

        int seenCarsTravellingWest = 0;
        int passingCars2 = 0;

        for (int a : A) {
            if (a == 0) {
                seenCarsTravellingEast++;
            } else {
                passingCars += seenCarsTravellingEast;
            }
        }

        // count same but from end of array upwards
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                seenCarsTravellingWest++;
            } else {
                passingCars2 += seenCarsTravellingWest;
            }
        }

        if (passingCars2 != passingCars) {
            throw new Exception("Something wrong in the algorithm");
        }

        return passingCars;
    }

    public static void main(String[] args) throws Exception {
        Task14_PassingCars passingCars = new Task14_PassingCars();
        System.out.println(passingCars.solution(new int[] {0,1,0,1,1}));
//        System.out.println(passingCars.solution(new int[] {1,0,1,0,0})); // change direction - different result
    }
}
