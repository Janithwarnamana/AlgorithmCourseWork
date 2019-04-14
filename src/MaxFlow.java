import java.util.ArrayList;

public class MaxFlow {

    private static int value = 0;


    public static void main(String args[]) {

        ArrayList<DataPoint> matrixArrayList = new ArrayList<>();

        int numberOfNodes;
        int input_i = 0;
        int input_j = 0;
        int permission = 0;

//        Scanner node = new Scanner(System.in);
//        System.out.println("Enter the number of nodes");
//        numberOfNodes = node.nextInt();
//
//        System.out.println("You can Enter Nodes from Below.. ");
//
//        for (int x = 0; x <= (numberOfNodes * numberOfNodes); x++) {
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("If You Want ENTER A NODE ? \n(if YES press 1 ,is NO press 0)");
//            permission = scanner.nextInt();
//
//            if (permission == 1) {
//
//                Scanner i = new Scanner(System.in);
//                System.out.println("Enter The 'i' value");
//                input_i = i.nextInt();
//
//                Scanner j = new Scanner(System.in);
//                System.out.println("Enter The 'j' value");
//                input_j = j.nextInt();
//
//                Scanner val = new Scanner(System.in);
//                System.out.println("Enter the Value ");
//                value = val.nextInt();
//
//
//                DataPoint dataPoint = new DataPoint(input_i, input_j, value);
//                matrixArrayList.add(dataPoint);
//            } else {
//                break;
//            }
//        }


        numberOfNodes = 4;
//        matrixArrayList.add(new DataPoint(1, 2, 5));
//        matrixArrayList.add(new DataPoint(1, 3, 10));
//        matrixArrayList.add(new DataPoint(2, 3, 8));
//        matrixArrayList.add(new DataPoint(3, 2, 4));
//        matrixArrayList.add(new DataPoint(2, 4, 5));
//        matrixArrayList.add(new DataPoint(3, 4, 9));

        matrixArrayList.add(new DataPoint(1, 2, 5));
        matrixArrayList.add(new DataPoint(1, 3, 10));
        matrixArrayList.add(new DataPoint(2, 3, 8));
        matrixArrayList.add(new DataPoint(3, 2, 4));
        matrixArrayList.add(new DataPoint(2, 4, 5));
        matrixArrayList.add(new DataPoint(3, 4, 9));

        Matrix matrix = new Matrix(numberOfNodes);

        for (int i = 0; i < matrixArrayList.size(); i++) {

            matrix.addEdge(matrixArrayList.get(i).getNum1(), matrixArrayList.get(i).getNum2(), matrixArrayList.get(i).getCapacity());

        }
        System.out.println(matrix.toString());

        int fordFulkerson = matrix.fordFulkerson(matrix.getAdjMatrix(), 1, 4);
        System.out.println("The Max Flow is " + fordFulkerson);


    }

}