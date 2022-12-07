import java.util.*;
// Evaluation of Post-fix expression using Stack
class post {
    int n;
    int top = -1;
    int[] stack;

    post(int n) {
        this.n = n;
        stack = new int[n];
    }

    boolean isempty() {
        return top == -1;
    }

    boolean isfull() {
        return top + 1 == n;
    }

    void push(int d) {
        if (!isfull()) {
            stack[++top]=d;
        } else {
            System.out.println("stack is full");
        }
    }
    int pop(){
        if(!isempty()){
            int temp=stack[top--];
            // stack[top--]=0;
            return temp;
        }
        else{
            System.out.println("stack is empty");
            return 0;
        }
    }
    int peek(){
        if(top==-1) return 0;
        else return stack[top];
    }
    int imp(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                int a=Character.getNumericValue(str.charAt(i));
                push(a);
            }
            else{
                char t=str.charAt(i);
                int a=pop();
                int b=pop();
                if(t=='+') push(b+a);
                else if(t=='-') push(b-a);
                else if(t=='*') push(b*a);
                else if(t=='/') push(b/a);
                else if(t=='^') push((int) Math.pow(b,a));
            }
        }
        return peek();
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the post-fix expression: ");
        String str = sc.next();
        post p = new post(str.length());
        int ans=p.imp(str);
        System.out.println("answer is "+ans);
    }
}
