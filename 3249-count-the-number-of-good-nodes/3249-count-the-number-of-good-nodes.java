class Solution {

    int ans = 0;

    public int countGoodNodes(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        // Build graph
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }


        dfs(0, -1, graph);

        return ans;
    }



    private int dfs(int node, int parent, ArrayList<Integer>[] graph) {


        int subtreeSize = 1;

        int previousSize = -1;

        boolean good = true;


        for(int child : graph[node]) {


            if(child == parent)
                continue;


            int childSize = dfs(child, node, graph);


            if(previousSize == -1) {

                previousSize = childSize;

            }
            else if(previousSize != childSize) {

                good = false;

            }


            subtreeSize += childSize;
        }



        if(good) {

            ans++;

        }


        return subtreeSize;
    }
}