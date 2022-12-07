import java.util.*;
// circular queue
class cir {
    int size;
    int[] queue;
    int front = 0, rear = 0;

    cir(int size) {
        this.size = size;
        queue = new int[size];
    }

    boolean isempty() {
        return front == rear;
    }

    boolean isfull() {
        return (rear + 1) % size == front;
    }

    void enqueue(){
        if(!isfull()){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter data:");
        int data=sc.nextInt();
        rear=(rear+1)%size;
        queue[rear]=data;
        }
        else{
            System.out.println("queue is full!");
        }
    }
    void dequeue(){
        if(!isempty()){
            front=(front+1)%size;
            queue[front]=0;
        }
        else{
            System.out.println("queue is empty!");
        }
    }
    void print(){
        for(int i : queue){
            System.out.print(i+" ");
        }
        System.out.println("\nfront="+front+" rear="+rear);
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of queue:");
        int size = sc.nextInt();
        cir c = new cir(size);
        int choice = 400;
        while (choice != 0) {
            System.out.println("Enter 0 to exit, 1 to enqueue, 2 to dequeue");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exiting the code...");
            } else if (choice == 1) {
                c.enqueue();
            } else if (choice == 2) {
                c.dequeue();
            } else {
                System.out.println("wrong input");
            }
            c.print();
        }
    }
}
