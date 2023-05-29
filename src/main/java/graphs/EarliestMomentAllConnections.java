package graphs;

import java.util.Arrays;

public class EarliestMomentAllConnections {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public int earliestAcq(int[][] logs, int n) {
        int [] friends = new int[n];
        int numberOfConnections = n-1;
        int earliestYear = Integer.MAX_VALUE;
        for(int i=0;i < n;i++){
            friends[i] = i;
        }
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));

        for(int[] log: logs){
            int year = log[0];
            int x = log[1];
            int y = log[2];
            if(union(x,y, friends) == 1) {
                numberOfConnections -= 1;
                if(numberOfConnections == 0){
                    return year;
                }
            }
        }
        return -1;
    }

    public int find(int x, int[] friends){
        while(x != friends[x]){
            x = friends[x];
        }
        return x;
    }

    public int union(int x, int y, int[] friends){
        int rootX = find(x, friends);
        int rootY = find(y, friends);

        if (rootX != rootY){
            if (friends[rootX] < friends[rootY]){
                friends[rootY] = rootX;
            } else {
                friends[rootX] = rootY;
            }
            return 1;
        } else {
            return 0;
        }
    }
}
