public class DoubleArray {
    public static void main(String args[]){

        String[][] dblArray = new String[][]{
                {"1", "2", "3"},
                {"a", "c"},
                {},
                {"1", "3", "a", "x"}
        };


        System.out.println(dblArray.length);
        System.out.println(dblArray[0].length);
        System.out.println(dblArray[1].length);
        System.out.println(dblArray[2].length);


        String[][] dblEmptyArray = new String[][]{
                {}
        };

        System.out.println(dblEmptyArray.length);
    }
}
