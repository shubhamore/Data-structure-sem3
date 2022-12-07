import java.util.*;
// bfs graph
class queue{
    int rear=-1,start=0,n;
    int[] arr;
    queue(int n){
        this.n=n;
        arr=new int[n];
    }
    boolean isempty(){
        return start>rear;
    }
    boolean isfull(){
        return rear==n-1;
    }
    void enqueue(int data){
        arr[++rear]=data;
    }
    void dequeue(){
        arr[start++]=0;
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
    void bfs(int index){
        queue q=new queue(n);
        isvisited[index]=true;
        out[op++]=index;
        q.enqueue(index);
        while(!q.isempty()){
            for(int i=0;i<n;i++){
                if(isvisited[i]==false&&mat[q.arr[q.start]][i]==1){
                    q.enqueue(i);
                    isvisited[i]=true;
                    out[op++]=i;
                }
            }
            q.dequeue();
        }
        System.out.println("final output of bsf traversal="+Arrays.toString(out));
    }
}

public class q15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes:");
        int noOfNodes=sc.nextInt();
        graph g=new graph(noOfNodes);
        g.input();
        System.out.print("enter the index of source:");
        int index=sc.nextInt();
        g.bfs(index);
    }
}
