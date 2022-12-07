import java.util.*;
// partition in ll
class lil {
    node head;

    class node {
        node next;
        int data;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    boolean isempty() {
        return head == null;
    }

    void print() {
        node cur = head;
        System.out.print("NULL--");
        while (cur != null) {
            System.out.print(cur.data + "--");
            cur = cur.next;
        }
        System.out.println("NULL\n");
    }

    void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data:");
        int data = sc.nextInt();
        if (isempty()) {
            head = new node(data);
            return;
        }
        node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new node(data);
    }

    void insert(int data) {
        if (isempty()) {
            head = new node(data);
            return;
        }
        node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new node(data);
    }

    lil partition() {
        lil result = new lil();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of x:");
        int x = sc.nextInt();
        node temp = head;
        while (temp != null) {
            if (temp.data < x) {
                result.insert(temp.data);
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data>=x){
                result.insert(temp.data);
            }
            temp=temp.next;
        }
        return result;
    }
}

public class q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lil ll = new lil();
        int choice = 100;
        while (choice != 0) {
            System.out.println("Enter 0 to exit, 1 to insert");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Input of linked list is completed...");
            } else if (choice == 1) {
                ll.insert();
            } else {
                System.out.println("incorrect input!");
            }
            ll.print();
        }
        lil result = ll.partition();
        System.out.println("Output after partition is");
        result.print();
    }
}