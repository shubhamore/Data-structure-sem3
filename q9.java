import java.util.*;
// polynomial multiplication using ll
class ll {
    node head;

    class node {
        int co;
        int pow;
        node next;

        node(int co, int pow) {
            this.co = co;
            this.pow = pow;
            this.next = null;
        }
    }

    boolean isempty() {
        return head == null;
    }

    void addnode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter co-efficient:");
        int co = sc.nextInt();
        System.out.print("enter power:");
        int pow = sc.nextInt();
        if (isempty()) {
            head = new node(co, pow);
            return;
        }
        node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new node(co, pow);
    }

    void addnode(int co, int pow) {
        if (isempty()) {
            head = new node(co, pow);
            return;
        }
        node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new node(co, pow);
    }

    void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.co + "x^" + temp.pow + " + ");
            temp = temp.next;
        }
        System.out.println("0 = 0");
        System.out.println();
    }

    void multiply(ll one,ll two){
        node onep=one.head;
        while(onep!=null){
            node twop=two.head;
            while(twop!=null){
                this.addnode((onep.co*twop.co), onep.pow+twop.pow);
                twop=twop.next;
            }
            onep=onep.next;
        }
    }
}

public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ll one = new ll();
        ll two = new ll();
        ll result = new ll();
        int choice1 = 100, choice2 = 100;
        while (choice1 != 0) {
            System.out.println("for 1st ll, enter 0 to exit, 1 to insert");
            choice1 = sc.nextInt();
            if (choice1 == 0) {
                System.out.println("Input for linked list 1 complete...");
                continue;
            } else if (choice1 == 1) {
                one.addnode();
            } else {
                System.out.println("invalid input!");
            }
            one.print();
        }
        while (choice2 != 0) {
            System.out.println("for 2nd ll, enter 0 to exit, 1 to insert");
            choice2 = sc.nextInt();
            if (choice2 == 0) {
                System.out.println("Input for linked list 2 complete...");
                continue;
            } else if (choice2 == 1) {
                two.addnode();
            } else {
                System.out.println("invalid input!");
            }
            two.print();
        }
        result.multiply(one, two);
        System.out.println("\n\nfinal answer:");
        result.print();
    }
}
