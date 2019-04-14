import java.util.LinkedList;
import java.util.Queue;

public class AlgoUtility {

    private int numVertices;
    private boolean[] visited;
    private int[] parent;
    private Queue<Integer> queue;

    public AlgoUtility() {
        this.queue = new LinkedList<>();
    }

    public void initializeAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        parent = new int[numVertices + 1];
        visited = new boolean[numVertices + 1];
    }

    public boolean bfs(int source, int goal, int graph[][]) {
        boolean pathFound = false;
        int destination, element;

        for (int vertex = 1; vertex <= numVertices; vertex++) {
            parent[vertex] = -1;
            visited[vertex] = false;
        }

        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()) {
            element = queue.remove();
            destination = 1;

            while (destination <= numVertices) {
                if (graph[element][destination] > 0 && !visited[destination]) {
                    parent[destination] = element;
                    queue.add(destination);
                    visited[destination] = true;
                }
                destination++;
            }
        }
        if (visited[goal]) {
            pathFound = true;
        }
        return pathFound;
    }

    public int fordFulkerson(int graph[][], int source, int destination) {
        int u, v;
        int maxFlow = 0;
        int pathFlow;

        if (numVertices == 0) {
            return 0;
        }

        int[][] residualGraph = new int[numVertices + 1][numVertices + 1];
        for (int sourceVertex = 1; sourceVertex <= numVertices; sourceVertex++) {
            for (int destinationVertex = 1; destinationVertex <= numVertices; destinationVertex++) {
                residualGraph[sourceVertex][destinationVertex] = graph[sourceVertex][destinationVertex];
            }
        }

        while (bfs(source, destination, residualGraph)) {
            pathFlow = Integer.MAX_VALUE;
            for (v = destination; v != source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }
            for (v = destination; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

}
