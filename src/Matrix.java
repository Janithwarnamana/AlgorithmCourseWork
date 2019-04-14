import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

    private int adjMatrix[][];
    private int numVertices;
    private boolean[] visited;
    private int[] parent;
    private Queue<Integer> queue;


    public Matrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices+1][numVertices+1];
        this.queue = new LinkedList<Integer>();
        parent = new int[numVertices + 1];
        visited = new boolean[numVertices + 1];
    }

    public void addEdge(int i, int j, int value) {
        adjMatrix[i][j] = value;
    }

//    public void removeEdge(int i, int j) {2
//        adjMatrix[i][j] = ;
//        adjMatrix[j][i] = false;
//    }
//
//    public boolean isEdge(int i, int j) {
//        return adjMatrix[i][j];
//    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= adjMatrix[i].length - 1; j++) {
                s.append((adjMatrix[i][j]) + " ");
            }
            s.append("\n");
        }
        return s.toString();


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

    public int fordFulkerson(int graph[][], int source, int destination)
    {
        int u, v;
        int maxFlow = 0;
        int pathFlow;

        int[][] residualGraph = new int[numVertices + 1][numVertices + 1];
        for (int sourceVertex = 1; sourceVertex <= numVertices; sourceVertex++)
        {
            for (int destinationVertex = 1; destinationVertex <= numVertices; destinationVertex++)
            {
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

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }
}


