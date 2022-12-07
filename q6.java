import java.util.*;
// priority queue
class prior {
    int size;
    int[] queue;
    int[] priority;
    int front = 0, rear = -1;

    prior(int size) {
        this.size = size;
        queue = new int[size];
        priority = new int[size];
    }

    boolean isempty() {
        return front > rear;
    }

    boolean isfull() {
        return rear == size - 1;
    }

    void enqueue() {
        if (!isfull()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("enter data:");
            int data = sc.nextInt();
            System.out.print("enter priority:");
            int pr=sc.nextInt();
            rear++;
            queue[rear] = data;
            priority[rear]=pr;
            sort();
        }
        else{
            System.out.println("queue is full");
        }
    }
    void dequeue(){
        if(!isempty()){
        queue[front]=0;
        priority[front]=0;
        front++;
        }
        else{
            System.out.println("queue is empty");
        }
    }
    void sort(){
        int i=rear;
        int j=i-1;
        while (i>front&&priority[i]>priority[j]) {
            int temp=queue[i];
            queue[i]=queue[j];
            queue[j]=temp;
            int temp2=priority[i];
            priority[i]=priority[j];
            priority[j]=temp2;
            i--;
            j--;
        }
    }
    void print(){
        System.out.println("queue:");
        for(int i : queue){
            System.out.print(i+" ");
        }
        System.out.println();
        
        System.out.println("priority:");
        for(int i : priority){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue:");
        int size = sc.nextInt();
        prior p = new prior(size);
        int choice = 100;
        while (choice != 0) {
            System.out.println("enter 0 to exit, 1 to enqueue, 2 to dequeue");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exiting the code...");
            } else if (choice == 1) {
                p.enqueue();
            } else if (choice == 2) {
                p.dequeue();
            } else {
                System.out.println("wrong input!");
            }
            p.print();
        }
    }
}
