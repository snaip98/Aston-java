public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        String[][] shouldBeMatrix4x4 = {{"1", "2", "2", "1"}, {"1", "2", "2", "1"}, {"1", "2", "2", "1"}, {"1", "2", "2", "1"}};
        myArray.checkArray(shouldBeMatrix4x4);
    }
}