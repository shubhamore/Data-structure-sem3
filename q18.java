import java.util.*;
// quadratic probing
class ht {
    boolean isnotfull(int[] table) {
        for (int i : table) {
            if (i == 0)
                return true;
        }
        return false;
    }

    void insert(int[] table, int key) {
        if (isnotfull(table)) {
            int address = key % table.length;
            if (table[address] == 0) {
                table[address] = key;
            } else {
                int i = 1;
                while (table[(address + i*i) % table.length] != 0) {
                    i++;
                    if(i>table.length){
                        System.out.println("overflow detected");
                        return;
                    }
                }
                table[(address + i*i) % table.length] = key;
            }
        } else {
            System.out.println("table is full");
        }
    }
    void print(int[] table){
        for(int i: table){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();
    }
}

public class q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of hash table");
        int size = sc.nextInt();
        int[] table = new int[size];
        System.out.println("Enter no of keys");
        int n = sc.nextInt();
        ht h=new ht();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter key:");
            int key = sc.nextInt();
            h.insert(table, key);
            h.print(table);
        }
    }
}
