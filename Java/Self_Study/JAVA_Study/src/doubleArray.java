public class doubleArray {
    public static void main(String[] args){

        int[][] doublesArray = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println(doublesArray[1]);
        System.out.println(doublesArray[0][0]);
        System.out.println(doublesArray.length);
        System.out.println(doublesArray[0].length);

        System.out.println("-------");
        int[][] copyArray = new int[doublesArray.length][doublesArray[0].length];

        System.out.println(copyArray[0][0]);
        System.out.println(copyArray.length);

    }

}
