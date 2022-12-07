import java.util.*;
// insert(position),sort in dll
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
    void addnode(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter data:");
        int data=sc.nextInt();
        if(isempty()){
            head=new node(data);
            return;
        }
        System.out.print("Enter 1 for start, 2 for end, 3 for between: ");
        int choice=sc.nextInt();
        if(choice==1){
            insertstart(data);
        }
        else if(choice==2){
            insertend(data);
        }
        else{
            insertbetween(data);
        }
    }
    void insertstart(int data){
        node newnode=new node(data);
        newnode.right=head;
        head.left=newnode;
        head=head.left;
    }
    void insertend(int data){
        node current=head;
        while(current.right!=null){
            current=current.right;
        }
        node newnode=new node(data);
        newnode.left=current;
        current.right=newnode;
    }
    void insertbetween(int data){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter position:");
        int pos=sc.nextInt();
        node current=head;
        int tpos=0;
        while(tpos!=pos){
            tpos++;
            current=current.right;
        }
        node newnode=new node(data);
        newnode.left=current.left;
        newnode.right=current;
        current.left.right=newnode;
        current.left=newnode;
    }
    void sort(){
        if(head==null) return;
        else{
            for(node i=head;i!=null;i=i.right){
                for(node j=i.right;j!=null;j=j.right){
                    if(i.data>j.data){
                        int temp=i.data;
                        i.data=j.data;
                        j.data=temp; 
                    }
                }
            }
        }
    }
}

public class q10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        linkedlist ll=new linkedlist();
        int choice=100;
        while(choice!=0){
            System.out.println("Enter 0 to exit, 1 to insert, 2 to sort, 3 to display");
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("Exiting the code...");
            }
            else if(choice==1){
                ll.addnode();
            }
            else if(choice==2){
                ll.sort();
            }
            else if(choice==3){
                ll.print();
            }
        }
    }
}
