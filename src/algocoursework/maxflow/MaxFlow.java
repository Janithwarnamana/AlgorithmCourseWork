package algocoursework.maxflow;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MaxFlow {

    public static final int MIN_NODES = 4;
    public static final int MAX_NODES = 10;
    public static final int MAX_CAPACITY = 20;
    public static final int MIN_CAPACITY = 5;
    private int numberOfNodes;
    private int source;
    private int destination;


    public static void main(String args[]) {

        MaxFlow maxFlow = new MaxFlow();
        maxFlow.initializeMaxFLow();

    }

    private void initializeMaxFLow() {

        //User flow execute here
        ArrayList<DataPoint> matrixArrayList = getUserInput();

        //Mock input flow execute here
//        ArrayList<DataPoint> matrixArrayList = getMockInputs();

        //Random inputs
//        ArrayList<DataPoint> matrixArrayList = getRandomInputs();

        //Add inputs to matrix
        Matrix matrix = getMatrix(matrixArrayList,numberOfNodes);
        int[][] grid = matrix.getAdjMatrix();

        AlgoUtility algoUtility = new AlgoUtility();
        algoUtility.initializeAlgorithm(matrixArrayList.size());
        int fordFulkerson = algoUtility.fordFulkerson(grid, source, destination);

        System.out.println("The Max Flow is " + fordFulkerson);

    }

    private Matrix getMatrix(ArrayList<DataPoint> matrixArrayList,int numberOfNodes) {
        Matrix matrix = new Matrix(numberOfNodes);
        for (int i = 0; i < matrixArrayList.size(); i++) {
            matrix.addEdge(matrixArrayList.get(i));
        }
        System.out.println(matrix.toString());
        return matrix;
    }

    /**
     * used only for test purposes only
     */
    private ArrayList<DataPoint> getMockInputs() {

        ArrayList<DataPoint> mockArrayList = new ArrayList<>();
        mockArrayList.add(new DataPoint(1, 2, 5));
        mockArrayList.add(new DataPoint(1, 3, 10));
        mockArrayList.add(new DataPoint(2, 3, 8));
        mockArrayList.add(new DataPoint(3, 2, 4));
        mockArrayList.add(new DataPoint(2, 4, 5));
        mockArrayList.add(new DataPoint(3, 4, 9));
        numberOfNodes = mockArrayList.size();
        source = 1;
        destination = 4;
        return mockArrayList;
    }


    private ArrayList<DataPoint> getUserInput() {

        ArrayList<DataPoint> matrixArrayList = new ArrayList<>();
        int permission;
        int input_i;
        int input_j;
        Scanner node = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        numberOfNodes = node.nextInt();

        System.out.println("You can Enter Nodes from Below.. ");

        for (int x = 0; x <= (numberOfNodes * numberOfNodes); x++) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("If You Want ENTER A NODE ? \n(if YES press 1 ,is NO press 0)");
            permission = scanner.nextInt();

            if (permission == 1) {

                Scanner i = new Scanner(System.in);
                System.out.println("Enter The 'i' value");
                input_i = i.nextInt();

                Scanner j = new Scanner(System.in);
                System.out.println("Enter The 'j' value");
                input_j = j.nextInt();

                Scanner val = new Scanner(System.in);
                System.out.println("Enter the Value ");
                int value = val.nextInt();

                DataPoint dataPoint = new DataPoint(input_i, input_j, value);
                matrixArrayList.add(dataPoint);
            } else {
                break;
            }
        }
        Scanner val = new Scanner(System.in);
        System.out.println("Enter the Source ");
        source = val.nextInt();
        System.out.println("Enter the Sink ");
        destination = val.nextInt();
        return matrixArrayList;
    }

    private ArrayList<DataPoint> getRandomInputs() {


        numberOfNodes = getRandomNodes();

        ArrayList<DataPoint> mockArrayList = new ArrayList<>();

        for(int i = 0; i< numberOfNodes-1;i++)
        {
            for(int j = 1; j< numberOfNodes;j++)
            {
                mockArrayList.add(new DataPoint(i+1, j+1, getRandomCapacity()));
            }
        }
        source = 1;
        destination = numberOfNodes;
        return mockArrayList;
    }

    private int getRandomCapacity() {
        return ThreadLocalRandom.current().nextInt(MIN_CAPACITY, MAX_CAPACITY +1 );
    }


    public int getRandomNodes() {
        return ThreadLocalRandom.current().nextInt(MIN_NODES, MAX_NODES + 1);
    }
}