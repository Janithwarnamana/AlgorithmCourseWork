public class Matrix {

    private int adjMatrix[][];
    private int numVertices;


    public Matrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices + 1][numVertices + 1];
    }

    public void addEdge(DataPoint dataPoint) {
        adjMatrix[dataPoint.getNum1()][dataPoint.getNum2()] = dataPoint.getCapacity();
    }

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


    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}


