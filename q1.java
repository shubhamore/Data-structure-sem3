import java.util.*;
//infix to postfix
class stacks {
    char[] stack;
    int top = -1;

    stacks(int size) {
        stack = new char[size];
    }

    boolean isempty() {
        System.out.println("stack empty");
        return top == -1;
    }

    boolean isfull() {
        System.out.println("stack full");
        return top == stack.length - 1;
    }

    void push(char data) {
        System.out.println("push "+ data +" to "+(top+1));
        stack[++top] = data;
    }

    char pop() {
        System.out.println("pop "+stack[top]);
        char temp=stack[top--];
        stack[top+1]=' ';
        return temp;
    }

    void print(){
        for(char i : stack){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String output = "";
        System.out.print("Enter size of input: ");
        int size = sc.nextInt();
        stacks s = new stacks(size);
        for (int i = 0; i < size; i++) {
            System.out.print("Enter character: ");
            char nxt = sc.next().charAt(0);
            if (isChar(nxt)) {
                output += nxt;
            } else {
                if (nxt == ')') {
                    // System.out.println("closing bracket encountered!");
                    // System.out.println("precedence of top is "+precedence(s.stack[s.top]));
                    // System.out.println("s.top="+s.top+" s.stack[s.top]="+s.stack[s.top]);
                    while (precedence(s.stack[s.top]) != -1) {
                        char temp = s.pop();
                        // System.out.println("popped "+temp+" because it was between 2 brackets");
                        output += temp;
                    }
                    s.pop();
                    // continue;
                } else if (s.top == -1 || precedence(s.stack[s.top]) < precedence(nxt)) {
                    s.push(nxt);
                } else {
                    while (precedence(nxt)!=-1&&precedence(s.stack[s.top]) >= precedence(nxt)) {
                        char temp = s.pop();
                        output += temp;
                        if(s.top==-1)
                            break;
                    }
                    s.push(nxt);
                }
            }
            System.out.println("output is "+output);
            System.out.print("stack is ");
            s.print();
            System.out.println();
        }
        while (!s.isempty()) {
            char temp = s.pop();
            output += temp;
        }
        System.out.println("\nfinal output is :" + output);
    }

    static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return -1;
        }
        return 22345235;
    }
}
// output from terminal
// PS C:\Users\shubh\OneDrive\Desktop\STUDY MATERIAL\DS\DS_LAB> cd "c:\Users\shubh\OneDrive\Desktop\STUDY MATERIAL\DS\DS_LAB\" ; if ($?) { javac q1.java } ; if ($?) { java q1 }
// Enter size of input: 15
// Enter character: (
// push ( to 0
// output is
// stack is (

// Enter character: a
// output is a
// stack is (

// Enter character: +
// push + to 1
// output is a
// stack is ( +

// Enter character: b
// output is ab
// stack is ( +

// Enter character: -
// pop +
// push - to 1
// output is ab+
// stack is ( -

// Enter character: c
// output is ab+c
// stack is ( -

// Enter character: )
// pop -
// pop (
// output is ab+c-
// stack is

// Enter character: *
// push * to 0
// output is ab+c-
// stack is *

// Enter character: d
// output is ab+c-d
// stack is *

// Enter character: -
// pop *
// push - to 0
// output is ab+c-d*
// stack is -

// Enter character: (
// push ( to 1
// output is ab+c-d*
// stack is - (

// Enter character: e
// output is ab+c-d*e
// stack is - (

// Enter character: +
// push + to 2
// output is ab+c-d*e
// stack is - ( +

// Enter character: f
// output is ab+c-d*ef
// stack is - ( +

// Enter character: )
// pop +
// pop (
// output is ab+c-d*ef+
// stack is -

// stack empty
// pop -
// stack empty

// final output is :ab+c-d*ef+-