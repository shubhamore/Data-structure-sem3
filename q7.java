import java.util.*;
// palindrome using ll
class ll{
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
    void addnode(){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter data:");
        int data=sc.nextInt();
        if(isempty()){
            head=new node(data);
            return;
        }
        node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=new node(data);
    }
    void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    int check(){
        node start=head;
        node end=start;
        int length=1;
        while(end.next!=null){
            end=end.next;
            length++;
        }
        for(int i=0;i<length/2;i++){
            int tlen=0;
            node tn=head;
            while(tlen!=length-i-1){
                tn=tn.next;
                tlen++;
            }
            int tlen2=0;
            node tn2=head;
            while(tlen2!=i){
                tn2=tn2.next;
                tlen2++;
            }
            if(tn2.data!=tn.data)
                return 0;
        }
        return 1;
    }
}

public class q7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ll l=new ll();
        int choice=100;
        do {
            System.out.println("Enter 0 to exit, 1 to insert, 2 to check palindrome");
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("exiting the code...");
            }
            else if(choice==1){
                l.addnode();
                l.print();
            }
            else if(choice==2){
                int ans=l.check();
                System.out.println("returned value is "+ans);
            }
            else{
                System.out.println("wrong input");
            }
            System.out.println();
        } while (choice!=0);
    }
}
