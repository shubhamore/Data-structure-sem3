import java.util.*;

class minheap{
    int[] insert(int arr[],int n,int key){
        arr[n] = key;
        int i=n;
        while (i>0){
            int parent = (i-1)/2;
            if(arr[i]<arr[parent]){
                int temp = arr[parent];
                arr[parent] = arr[i];
                arr[i] = temp;
                i=parent;
            }
            else return arr ;
        }
        return arr;
    }
    void heapify(int arr[],int n,int index){
        int minelement = index;
        int left = 2*index +1;
        int right = 2*index+2;
        if(left<=n && arr[left]<arr[minelement]){
            minelement = left;
        }
        if(right<=n && arr[right]<arr[minelement]){
            minelement= right;
        }
        if(minelement!=index){
            int temp = arr[minelement];
            arr[minelement] = arr[index];
            arr[index] = temp;
            heapify(arr,n,minelement);
        }
    }

    void heapsort(int arr[]){
        int n =arr.length;
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i-1,0);
        }
    }
}
public class q19 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements ");
        int n = sc.nextInt();
        minheap heap = new minheap();
        int arr[] = new int[n];
        System.out.println("Enter the elements ");
        for(int i=0;i<n;i++){
            System.out.print("Enter element "+(i+1)+" ");
            arr[i] = sc.nextInt();
            arr = heap.insert(arr,i,arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Sorting Started");
//        int arr2[]= {20,35,9,26,49,78,2,46};
//        heap.heapify(arr2,n,0);
        heap.heapsort(arr);
        System.out.print("Final sorted array :   ");
        System.out.println(Arrays.toString(arr));
    }
}