import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxFlow {

    private static int value = 0;


    public static void main(String args[]) {

        ArrayList<DataPoint> matrixArrayList = new ArrayList<>();

        int numberOfNodes;
        int input_i = 0;
        int input_j = 0;
        int permission = 0;

//        int maxFlow;
//        int [][]graph = new int[0][0];
//        int source = 0;
//        int sink = 0;


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
                value = val.nextInt();


                DataPoint dataPoint = new DataPoint(input_i, input_j, value);
                matrixArrayList.add(dataPoint);
            } else {

//                System.out.println("Enter the source of the graph");
//                source= scanner.nextInt();
//
//                System.out.println("Enter the sink of the graph");
//                sink = scanner.nextInt();

                break;


            }
//            System.out.println("Enter the graph matrix");
//            for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
//            {
//                for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
//                {
//                    graph[sourceVertex][destinationVertex] = scanner.nextInt();
//                }
//            }


        }

        Matrix matrix = new Matrix(numberOfNodes);

        for (int i = 0; i < matrixArrayList.size(); i++) {

            matrix.addEdge(matrixArrayList.get(i).getNum1(), matrixArrayList.get(i).getNum2(), matrixArrayList.get(i).getCapacity());

        }
        System.out.println(matrix.toString());

//        Matrix fordFulkerson = new Matrix(numberOfNodes);
//        maxFlow = fordFulkerson.fordFulkerson(graph, source, sink);
//        System.out.println("The Max Flow is " + maxFlow);


    }

}