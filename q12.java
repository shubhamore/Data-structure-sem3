import java.util.*;
// delete duplicate in ll
class linkedlist{
    node head;
    class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    boolean isempty(){
        return head==null;
    }
    void print(){
        node curr=head;
        System.out.print("NULL--");
        while(curr!=null){
            System.out.print(curr.data+"--");
            curr=curr.next;
        }
        System.out.println("NULL\n");
    }
    void insert(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter data:");
        int data=sc.nextInt();
        if(isempty()){
            head=new node(data);
            return;
        }
        node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=new node(data);
    }
    void del(){
        node temp=head;
        while(temp!=null){
            while(temp.next!=null&&temp.next.data==temp.data){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
    }
}

public class q12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice=100;
        linkedlist ll=new linkedlist();
        while(choice!=0){
            System.out.println("Enter 0 to exit, 1 to insert, 2 to delete duplicates");
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("Exiting the code...");
            }
            else if(choice==1){
                ll.insert();
            }
            else if(choice==2){
                ll.del();
            }
            else{
                System.out.println("Incorrect input!");
            }
            ll.print();
        }
    }
}
