import java.util.*;

class Passenger {
    int n; // Number of contingement
    int[][] arr; // Array of 2D array
    int[] passenger; // Array of Passenger id
    int size; // Size of the Passenger Array
    int tcol; // Number of seats in every row
    Scanner sc = new Scanner(System.in);

    Passenger() {
        int maxrow = 0;//max Row
        n = sc.nextInt();// number of containment
        arr = new int[n][2];
        tcol = 0;//total number of seats in each row

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                arr[i][j] = sc.nextInt();
                if (j == 0) {
                    tcol = tcol + arr[i][j];
                    maxrow = maxrow > arr[i][j] ? maxrow : arr[i][j]; // To determine the maximum row
                }

            }
        }
        size = sc.nextInt();
        passenger = new int[size]; // to get passenger id as input

        int count = 0;
        Prioritize(); // Invoke the Method to priotize the array.
        DisplayHead();
        int[][] ba = new int[maxrow][tcol];
        System.out.println();
        for (int i = 0; i < ba.length; ++i) {  // To initialize value for seat type
            for (int j = 0; j < ba[i].length; ++j) {
                ba[i][j] = -1;
            }

        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < arr[i][0]; ++j) {
                for (int k = 0; k < arr[i][1]; ++k) {
                    ba[j][k] = -1;
                }
            }
        }

        for (int i = 0; i < ba.length; ++i) {
            for (int j = 0; j < ba[i].length; ++j) {

                System.out.print(ba[i][j] + "  ");

            }
            System.out.println();
        }
    } // End of Constructor.

    void DisplayHead() {
        int count = 0;
        char[] ch = new char[tcol]; // colummn type as ww, aa and mm
        for (int i = 0; i < arr.length; ++i) { // for the display of seat type
            int l = arr[i][0];

            if (i == 0) {
                System.out.print("ww  ");
                ch[count++] = 'w';
            } else {
                System.out.print("aa  ");
                ch[count++] = 'a';
            }
            for (int j = 1; j < l - 1; ++j) {
                System.out.print("mm  ");
                ch[count++] = 'm';
            }
            if (i == arr.length - 1) {
                System.out.print("ww  ");
                ch[count++] = 'w';
            } else {
                System.out.print("aa  ");
                ch[count++] = 'a';
            }
        }
    }

    void Prioritize() {
        TreeSet<Integer> a = new TreeSet<Integer>();//For Prime Numbers
        TreeSet<Integer> b = new TreeSet<Integer>();//For Powers of 2
        TreeSet<Integer> c = new TreeSet<Integer>();//For others
        for (int i = 0; i < size; ++i) {
            int k = sc.nextInt();
            if (isPrime(k)) {  // Conditon to check Prime
                a.add(k);
            } else if (isPowerofTwo(k)) {  // Conditon to check powers of 2
                b.add(k);
            } else {
                c.add(k);
            }
        }
        PriorityOrder(a, b, c);
        int z = 0;
        for (Integer s : a) {  // Adding first priority id to the array
            passenger[z++] = s;
        }
        for (Integer s : b) { // Adding second priority id to the array
            passenger[z++] = s;
        }
        for (Integer s : c) { // Adding least priority id to the array
            passenger[z++] = s;
        }
    }

    void PriorityOrder(TreeSet<Integer> a, TreeSet<Integer> b, TreeSet<Integer> c) {
        System.out.print("\nFirst Priority Passenger Ids  ");
        for (Integer s : a) {  // Displaying first priority id to the array
            System.out.print(s + " ");
        }
        System.out.print("\nSecond Priority Passenger Ids  ");
        for (Integer s : b) { // Adding second priority id to the array
            System.out.print(s + " ");
        }
        System.out.print("\nLeast Priority Passenger Ids  ");
        for (Integer s : c) { // Adding least priority id to the array
            System.out.print(s + " ");
        }
        System.out.println();
    }

    boolean isPowerofTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}

