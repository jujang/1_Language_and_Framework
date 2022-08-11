public class test {
    public static void main(String args[]){

//        int[][] board1 = new int[][]{
//                {0, 0, 0, 1},
//                {1, 1, 1, 0},
//                {1, 1, 0, 0},
//                {0, 0, 0, 0}
//        };
////        int output1 = (int)boardGame(board1, "R");
////        System.out.println(output1); // 4
//        System.out.println(boardGame(board1, "RRDLLD"));


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
//        int output2 = boardGame(board2, "UUUDD");
//        System.out.println(output2); // null
        System.out.println(boardGame(board2, "UUUDD")); // null


        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
//        int output3 = boardGame(board3, "DDRRRUDUDUD");
//        System.out.println(output3); // 0
          System.out.println(boardGame(board3, "DDRRRUDUDUD")); // 0

    }

    public static Integer boardGame(int[][] board, String operation) {

        int x = 0;
        int y = 0;
        int point = 0;

        for(int i = 0; i < operation.length(); i++){
            if(operation.charAt(i) == 'U'){
//                System.out.println("U");
                x = x-1;
                if(x < board.length && y < board.length && x >= 0 && y >= 0 && board[x][y] == 1) point++;
                else if(x < board.length && y < board.length && x >= 0 && y >= 0) ;
                else return null;
            } else if(operation.charAt(i) == 'D'){
//                System.out.println("D");
                x = x+1;
                if(x < board.length && y < board.length && x >= 0 && y >= 0 && board[x][y] == 1) point++;
                else if(x < board.length && y < board.length && x >= 0 && y >= 0) ;
                else return null;
            } else if(operation.charAt(i) == 'L'){
//                System.out.println("L");
                y = y-1;
                if(x < board.length && y < board.length && x >= 0 && y >= 0 && board[x][y] == 1) point++;
                else if(x < board.length && y < board.length && x >= 0 && y >= 0) ;
                else return null;
            } else {
//                System.out.println("R");
                y = y+1;
                if(x < board.length && y < board.length && x >= 0 && y >= 0 && board[x][y] == 1) point++;
                else if(x < board.length && y < board.length && x >= 0 && y >= 0) ;
                else return null;
            }
        }

        return point;
    }
}
