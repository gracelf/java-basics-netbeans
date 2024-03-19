package interview;

/**
 *
 */
public class Interview {

    public int calculateCubes(int x) {

        int result = 0;
        if (x > 1) {

            result = (x - 2) * (x - 2) * (x - 2);
        }

        return result;

    }
    
    // find duplicate in an arrayList

    //walmart
    public int factorial(int num) {

        int result = 1;
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                result = result * i;
            }
        }

        return result;

    }

    //num * factorialRecursive(num-1)
    public int factorialRecursive(int num) {

        int result = 1;
        if (num > 1) {

            result = num * factorialRecursive(num - 1);

        }

        return result;

    }

    public static void main(String[] args) {

        Interview interview = new Interview();

        System.out.println("result: " + interview.factorialRecursive(4));

    }

}
