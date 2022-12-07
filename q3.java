import java.util.*;
// multiple queue
class queue {
    int[] qu;
    int[] start;
    int[] end;
    int noOfQueue, sizeOfQueue;

    queue(int noOfQueue, int sizeOfQueue) {
        this.noOfQueue = noOfQueue;
        this.sizeOfQueue = sizeOfQueue;
        qu = new int[noOfQueue * sizeOfQueue];
        startm(noOfQueue, sizeOfQueue);
        endm(noOfQueue, sizeOfQueue);
    }

    void startm(int noOfQueue, int sizeOfQueue) {
        start = new int[noOfQueue];
        for (int i = 0; i < noOfQueue; i++) {
            start[i] = i * sizeOfQueue;
        }
    }

    void endm(int noOfQueue, int sizeOfQueue) {
        end = new int[noOfQueue];
        for (int i = 0; i < noOfQueue; i++) {
            end[i] = i * sizeOfQueue - 1;
        }
    }

    void print() {
        for (int i = 0; i < qu.length; i++) {
            System.out.print(qu[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    void enqueue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the index of queue:");
        int index = sc.nextInt();
        if (!isfull(index)) {
            System.out.print("Enter the data:");
            int data = sc.nextInt();
            qu[++end[index]] = data;
        } else {
            System.out.println("the queue of index " + index + " is full!");
        }
    }

    void dequeue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the index of queue:");
        int index = sc.nextInt();
        if (!isempty(index)) {
            qu[start[index]++] = 0;
        } else {
            System.out.println("the queue of index " + index + " is empty!");
        }
    }

    boolean isempty(int index) {
        return start[index] > end[index];
    }

    boolean isfull(int index) {
        return end[index] != index * sizeOfQueue - 1 && (end[index] + 1) % sizeOfQueue == 0;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of queue:");
        int noOfQueue = sc.nextInt();
        System.out.print("Enter size of each queue:");
        int sizeOfQueue = sc.nextInt();
        queue q = new queue(noOfQueue, sizeOfQueue);
        int choice = 200;
        while (choice != 3) {
            System.out.println("enter 1 to enqueue 2 to dequeue 3 to exit");
            choice = sc.nextInt();
            if (choice == 3) {
                System.out.println("exiting the code...");
            } else if (choice == 2) {
                q.dequeue();
            } else if (choice == 1) {
                q.enqueue();
            } else {
                System.out.println("wrong input");
            }
            q.print();
        }
    }
}
