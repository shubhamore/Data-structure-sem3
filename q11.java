import java.util.*;
// insert(end), concat in dll
class linkedlist{
    node head;
    class node{
        node left;
        node right;
        int data;
        node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    boolean isempty(){
        return head==null;
    }
    void print(){
        System.out.print("NULL--");
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--");
            temp=temp.right;
        }
        System.out.print("--NULL\n");
    }
    void insertend(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter data:");
        int data=sc.nextInt();
        if(isempty()){
            head=new node(data);
            return;
        }
        node current=head;
        while(current.right!=null){
            current=current.right;
        }
        node newnode=new node(data);
        newnode.left=current;
        current.right=newnode;
    }
    void insertend(int data){
        if(isempty()){
            head=new node(data);
            return;
        }
        node current=head;
        while(current.right!=null){
            current=current.right;
        }
        node newnode=new node(data);
        newnode.left=current;
        current.right=newnode;
    }
    void concat(linkedlist ll1,linkedlist ll2){
        node temp1=ll1.head;
        node temp2=ll2.head;
        while(temp1!=null){
            this.insertend(temp1.data);
            temp1=temp1.right;
        }
        while(temp2!=null){
            this.insertend(temp2.data);
            temp2=temp2.right;
        }
    }
}

public class q11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        linkedlist ll1=new linkedlist();
        linkedlist ll2=new linkedlist();
        int choice1=100,choice2=100;
        while(choice1!=0){
            System.out.println("for linked list 1");
            System.out.println("Enter 0 to exit, 1 to insert, 2 to display");
            choice1=sc.nextInt();
            if(choice1==0){
                System.out.println("Exiting 1st linked list...");
            }
            else if(choice1==1){
                ll1.insertend();
            }
            else if(choice1==2){
                ll1.print();
            }
            System.out.println();
        }
        while(choice2!=0){
            System.out.println("for linked list 2");
            System.out.println("Enter 0 to exit, 1 to insert, 2 to display");
            choice2=sc.nextInt();
            if(choice2==0){
                System.out.println("Exiting 2nd linked list...");
            }
            else if(choice2==1){
                ll2.insertend();
            }
            else if(choice2==2){
                ll2.print();
            }
            System.out.println();
        }
        int choice3=100;
        linkedlist result=new linkedlist();
        while(choice3!=1){
            System.out.println("Enter 1 to concatenate");
            choice3=sc.nextInt();
            if(choice3==1){
                result.concat(ll1,ll2);
            }
            else{
                System.out.println("wrong input!!!");
            }
        }
        System.out.println("new concatenated linked list is ");
        result.print();
    }
}
