package graphs.dfs;

import java.util.*;

public class AllPathsFromSRCToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        AllPathsFromSRCToTarget paths = new AllPathsFromSRCToTarget();
        List<List<Integer>> result = paths.allPathsSourceTarget(graph);
        System.out.println(result);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < graph.length ; i++) {
            int[] edge = graph[i];
            graphMap.putIfAbsent(i, new ArrayList<>());
            for(int node: edge){
                graphMap.get(i).add(node);
            }
        }

        for(int i = 0; i < graph.length ; i++){
            if(graphMap.get(i).size() > 0) {
                List<Integer> trail = new ArrayList<>();
                trail.add(i);
                trails(graphMap, trail, i, result);
            }
        }

        return result;
    }

    public void trails(Map<Integer, List<Integer>> graphMap, List<Integer> trail, int next, List<List<Integer>> result){
        if(graphMap.get(next).size() == 0){
            result.add(new ArrayList<>(trail));
        }
        else{
            for(Integer node : graphMap.get(next)){
                trail.add(node);
                if(graphMap.get(node).size() > 0){
                    trails(graphMap, new ArrayList<>(trail), node, result);
                }
                else { // end of road
                    result.add(new ArrayList<>(trail));
                }
            }
        }
    }

}
