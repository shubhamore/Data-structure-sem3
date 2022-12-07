import java.util.*;
// dfs graph
class stacks{
    int top=-1,n;
    int[] arr;
    stacks(int n){
        this.n=n;
        arr=new int[n];
    }
    boolean isempty(){
        return top==-1;
    }
    boolean isfull(){
        return top==n-1;
    }
    void push(int data){
        arr[++top]=data;
    }
    int pop(){
        int temp=arr[top];
        arr[top--]=0;
        return temp;
    }
}
class graph{
    int[][] mat;
    int n;
    int[] out;
    int op=0;
    boolean[] isvisited;
    graph(int noOfNodes){
        mat=new int[noOfNodes][noOfNodes];
        n=noOfNodes;
        out=new int[noOfNodes];
        isvisited=new boolean[noOfNodes];
    }
    void printmat(){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of edges");
        int noOfEdges=sc.nextInt();
        for(int i=0;i<noOfEdges;i++){
            System.out.print("enter index of edge 1:");
            int e1=sc.nextInt();
            System.out.print("enter index of edge 2:");
            int e2=sc.nextInt();
            mat[e1][e2]=1;
            mat[e2][e1]=1;
            printmat();
        }
    }
    void dfs(int index){
        stacks s=new stacks(n);
        isvisited[index]=true;
        out[op++]=index;
        s.push(index);
        while(!s.isempty()){
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(isvisited[i]==false&&mat[s.arr[s.top]][i]==1){
                    s.push(i);
                    isvisited[i]=true;
                    out[op++]=i;
                    flag=false;
                    break;
                }
            }
            if(flag)
                s.pop();
        }
        System.out.println("final output of dfs traversal="+Arrays.toString(out));
    }
}

public class q16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes:");
        int noOfNodes=sc.nextInt();
        graph g=new graph(noOfNodes);
        g.input();
        System.out.print("enter the index of source:");
        int index=sc.nextInt();
        g.dfs(index);
    }
}
