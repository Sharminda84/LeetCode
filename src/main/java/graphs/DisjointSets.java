package graphs;

public class DisjointSets {
    public static void main(String[] args) {
        RootCompressionOnFind qf = new RootCompressionOnFind(10);
        // 1-2-5-6-7 3-8-9 4
        qf.union(1, 2);
        qf.union(2, 5);
        qf.union(5, 6);
        qf.union(6, 7);
        qf.union(3, 8);
        qf.union(8, 9);
        System.out.println(qf.connected(1, 5)); // true
        System.out.println(qf.connected(5, 7)); // true
        System.out.println(qf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        qf.union(9, 4);
        System.out.println(qf.connected(4, 9)); // true

    }
}

class UnionByRank { // try to create a balance tree based on minimising the height of the balanced tree
    // Union-find -> O(logN)
    // find -> O(logN)
    // connected -> O(logN)
     private int[] root;
     private int[] rank;

     public UnionByRank(int size){
         root = new int[size];
         rank = new int[size];
         for(int i = 0; i < size; i++){
             root[i] = i;
             rank[i] = i;
         }
     }

     public int find(int x){
         while(x != root[x]){
             x = root[x];
         }
         return x;
     }

     public void union(int x, int y){
         int root_X = find(x);
         int root_Y = find(y);

         if(root_X != root_Y) { // means we have two tree, so we should try to merge the trees
             if(rank[root_X] > rank[root_Y]){
                 root[root_Y] = root_X;
             }
             else if (rank[root_X] < rank[root_Y]){
                 root[root_X] = root_Y;
             }
             else {
                 root[root_Y] = root_X;
                 rank[root_X] += 1;
             }
         }
     }

     public boolean connected(int x, int y){
         return find(x) == find(y);
     }
}

class QuickUnion {
    // Union-find -> O(logN)
    // find -> O(logN)
    // connected -> O(logN)

    private int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class QuickFind {
    // Union-find -> O(N)
    // find -> O(1)
    // connected -> O(1)

    private int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int i = 0;i < size; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        return root[x];
    }

    public void union(int x, int y) {
        int root_X = find(x);
        int root_y = find(y);

        if(root_X != root_y){
            for(int i =0; i < root.length ; i++){
                if(root[i] == root_y){ // its own root
                    root[i] = root_X;
                }
            }
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y); // if the root nodes are matching then its the same
    }
}

class RootCompressionOnFind {
    private int[] root;

    public RootCompressionOnFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
