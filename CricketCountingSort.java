import java.util.*;

class Delivery {
    int over;
    int ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "(" + over + "," + ball + ")";
    }
}

public class CricketCountingSort {

    // Stable Counting Sort by Ball Number
    static void countingSortByBall(Delivery[] arr, int maxBall) {

        int n = arr.length;
        Delivery[] output = new Delivery[n];
        int[] count = new int[maxBall + 1];

        for (Delivery d : arr)
            count[d.ball]++;

        for (int i = 1; i <= maxBall; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].ball] - 1] = arr[i];
            count[arr[i].ball]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    // Stable Counting Sort by Over Number
    static void countingSortByOver(Delivery[] arr, int maxOver) {

        int n = arr.length;
        Delivery[] output = new Delivery[n];
        int[] count = new int[maxOver + 1];

        for (Delivery d : arr)
            count[d.over]++;

        for (int i = 1; i <= maxOver; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].over] - 1] = arr[i];
            count[arr[i].over]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {

        Delivery[] deliveries = {
            new Delivery(2, 4),
            new Delivery(1, 1),
            new Delivery(3, 6),
            new Delivery(1, 5),
            new Delivery(2, 2),
            new Delivery(3, 1),
            new Delivery(1, 3),
            new Delivery(2, 6),
            new Delivery(3, 4),
            new Delivery(1, 2)
        };

        System.out.println("Input Records:");
        for (Delivery d : deliveries)
            System.out.print(d + " ");

        System.out.println("\n");

        // Radix Style Sorting
        countingSortByBall(deliveries, 12);
        countingSortByOver(deliveries, 50);

        System.out.println("Sorted Records:");
        for (Delivery d : deliveries)
            System.out.print(d + " ");

        System.out.println("\n");

        System.out.println("Time Complexity:");
        System.out.println("Counting Sort = O(n + k)");
        System.out.println("Radix Sort = O(d * (n + k))");
        System.out.println("For bounded over and ball values:");
        System.out.println("Overall Complexity = O(n)");
    }
}