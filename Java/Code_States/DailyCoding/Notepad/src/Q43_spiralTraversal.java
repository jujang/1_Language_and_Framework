public class Q43_spiralTraversal {
    public static void main(String[] args){

        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        System.out.println("------------------------------------");

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'

    }

    public static String spiralTraversal(Character[][] matrix){

        int[][] mapArray = new int[matrix.length][matrix[0].length];
        int prevDirX = 0;
        int prevDirY = 1;
        int x = 0;
        int y = 0;
        String result = "";
        mapArray[x][y] = 1;
        result = result.concat(Character.toString(matrix[0][0]));
        boolean flag = false;
        int cnt = 1;


        while(!flag) {
            if(x + prevDirX < matrix.length && 0 <= x + prevDirX &&
                    y + prevDirY < matrix[0].length && 0 <= y + prevDirY &&
                    mapArray[x + prevDirX][y + prevDirY] == 0) {
                x+=prevDirX;
                y+=prevDirY;
                mapArray[x][y] = 1;
                result = result.concat(Character.toString(matrix[x][y]));
                cnt++;
            }
            else {
                if(prevDirX == 0 && prevDirY == 1) {
                    prevDirX = 1;
                    prevDirY = 0;
                } else if(prevDirX == 1 && prevDirY == 0) {
                    prevDirX = 0;
                    prevDirY = -1;
                } else if(prevDirX == 0 && prevDirY == -1) {
                    prevDirX = -1;
                    prevDirY = 0;
                } else if(prevDirX == -1 && prevDirY == 0){
                    prevDirX = 0;
                    prevDirY = 1;
                }
            }
            if(cnt >= matrix.length*matrix[0].length) flag = true;
        }
        return result;
    }
}
