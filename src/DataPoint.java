public class DataPoint {

    private int num1;
    private int num2;
    private  int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", capacity=" + capacity +
                '}';
    }

    public DataPoint(int num1, int num2, int capacity) {
        this.num1 = num1;
        this.num2 = num2;
        this.capacity = capacity;
    }
}
