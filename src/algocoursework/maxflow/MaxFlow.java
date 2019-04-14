package algocoursework.maxflow;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxFlow {

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
//        ArrayList<algocoursework.maxflow.DataPoint> matrixArrayList = getMockInputs();

        //Add inputs to matrix
        Matrix matrix = new Matrix(numberOfNodes);
        for (int i = 0; i < matrixArrayList.size(); i++) {
            matrix.addEdge(matrixArrayList.get(i));
        }
        System.out.println(matrix.toString());

        AlgoUtility algoUtility = new AlgoUtility();
        algoUtility.initializeAlgorithm(numberOfNodes);
        int fordFulkerson = algoUtility.fordFulkerson(matrix.getAdjMatrix(), source, destination);

        System.out.println("The Max Flow is " + fordFulkerson);

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
        System.out.println("Enter the Source ");
        destination = val.nextInt();
        return matrixArrayList;
    }

}