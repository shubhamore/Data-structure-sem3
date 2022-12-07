import java.util.*;
// bst and pre,in,post order traversal
class bst{
    node root;
    class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    node insert(node temp,int data){
        if(temp==null){
            temp=new node(data);
            return temp;
        }
        else if(temp.data>data){
            temp.left=insert(temp.left,data);
        }
        else if(temp.data<data){
            temp.right=insert(temp.right,data);
        }
        return temp;
    }
    void preorder(node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    void postorder(node root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
}

public class q14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice=100;
        bst b=new bst();
        while(choice!=0){
            System.out.println("enter 0 to exit, 1 to insert");
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("Exiting the code...");
                continue;
            }
            else if(choice==1){
                System.out.print("enter data:");
                int data=sc.nextInt();        
                b.root=b.insert(b.root,data);
            }
            System.out.print("preorder: ");
            b.preorder(b.root);
            System.out.println();
            System.out.print("inorder: ");
            b.inorder(b.root);
            System.out.println();
            System.out.print("postorder: ");
            b.postorder(b.root);
            System.out.println();
            System.out.println();
        }
    }
}