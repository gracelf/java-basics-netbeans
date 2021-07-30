/*
ref:https://www.udemy.com/course/practical-data-structures-algorithms-in-java/learn/lecture/10851178#questions/9095176
also check the comment/question section
 */
package hashTable;

public class HashTable {
    String [] hashArray;
    int arraySize; // must be prime
    int size = 0; // current number of elements in slot
    int smallestArraySize = 7;
    int smallPrime = 7;
 
    public HashTable(int numSlots) {
        // numSlots MUST be prime
        arraySize = (numSlots >= smallestArraySize) && isPrime(numSlots)
          ? numSlots
          : getNextPrime(numSlots >= smallestArraySize ? numSlots : smallestArraySize);
        hashArray = new String[arraySize];
        if (arraySize != numSlots) {
            System.out.println("Specified number of slots to HashTable not prime: " + numSlots +
                               ", increased to next prime: " + arraySize);
        }
    }
 
    private boolean isPrime(int n) {
        // not efficient as a general prime tester -- but works correctly
        // test edge cases
        if (n < 2) { return false; }
        if (n == 2) { return true; }
        if (n % 2 == 0) { return false; }
        // we know n > 2, n is not even
        // see if n divisible by any odd-numbered integer x >= 3, where x^2 <= n
        for (int x = 3; x*x <= n; x += 2) {
            if (n % x == 0) { return false; } // not prime, divisible by x > 2 where x != n
        }
        return true;
    }
 
    private int getNextPrime(int n) {
        if (isPrime(n)) { return n; }
        // inefficient for general prime determination
        // NOTE: n is not prime, start checking next odd number after n
        int k = (n % 2) == 0 ? n + 1 : n + 2;
        while (!isPrime(k)) {
             k += 2; // check next odd number
        }
        return k; // k is prime
    }
 
    private int hashFunction(String key) {
        // determine preferred has array position
        System.out.println("hashcode: "+ key.hashCode() +  ", for key: " + key );
        int hashVal = key.hashCode() % arraySize; // can be negative
        if (hashVal < 0) {
            hashVal += arraySize;
        }
        System.out.println("hash val: " + hashVal);
        return hashVal;
    }
 
    private int stepSize(String key) {
        int hashVal = key.hashCode() % arraySize; // can be negative
        if (hashVal < 0) {
            hashVal += arraySize;
        }
        // use primary number less than array size as step size, for example, we can use num 3
        int stepSize = smallPrime - (hashVal % smallPrime);
        System.out.println("stepSize: " + stepSize);
        return stepSize;  // will be a number 1 to smallPrime, this stepSize don't need to be a prime number
    }
 
    public void insert(String key) {
        int hashVal = hashFunction(key);
        if (hashArray[hashVal] != null) { // collision
            int step = stepSize(key);
            while (hashArray[hashVal] != null) {
                hashVal = (hashVal + step) % arraySize;
            }
        }
        hashArray[hashVal] = key;
    }
 
    public int find(String key) {
//        int step = 0; // step not computed yet (marker value)
//        // NOTE: step computed only when key not found in first hash position, optimize
//        // avoid needless additional hash computation when key is immediately found
//        for (int hashVal = hashFunction(key);
//                 hashArray[hashVal] != null;
//                     hashVal = (hashVal + step) % arraySize) {
//            if (hashArray[hashVal].equals(key)) { return hashVal; } // found it
//            if (step == 0) { step = stepSize(key); } // compute step if didnt find key immediately
//        }

        int hashVal = hashFunction(key);
        int stepSize = 0;
        // if hashArray[hashVal] is null, maybe there was a key there, but removed, we don't consider that that in this method
        // assuming we won't remove a key from the hashtable
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].equals(key)) {
                return hashVal;
            } 
            if (stepSize == 0) { stepSize = stepSize(key); }
            hashVal += stepSize;
            hashVal = hashVal % arraySize;
        }
        return -1; // key not found
    }
 
    public void displayHashTable() {
        // print the content of the hashArray
        System.out.println("Hash table display:");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.println(i + " : " + hashArray[i]);
            } else {
                System.out.println(i + " : " + "<<<null>>>");
            }
        }
    }
 
}
