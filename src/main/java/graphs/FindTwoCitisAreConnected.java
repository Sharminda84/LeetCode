package graphs;

import java.util.Arrays;

public class FindTwoCitisAreConnected {


    public int findProvinces(int[][] m){
        int[] parents = new int[m.length]; // worst case, is the length of cities
        Arrays.fill(parents, -1);
        for(int x = 0; x < m.length; x ++){
            for(int y = 0; y < m.length; y++){
                if(m[x][y] == 1 && x != y){ // its connected
                    union(parents, x, y);
                }
            }
        }
        int count = 0;
        for(int i =0; i < parents.length ; i++){
            if(parents[i] == -1){
                count++;
            }
        }
        return count;
    }

    public void union(int[] parents, int x, int y){
        int xset = find(parents, x);
        int yset = find(parents, y);

        if(xset != yset){
            parents[xset] = yset;
        }
    }

    public int find(int[] parents, int x){
        if(parents[x] == -1){
            return x;
        }

        return find(parents, parents[x]);
    }
}
