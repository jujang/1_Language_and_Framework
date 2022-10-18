public class Q57_decompression_ref {
    public static void main(String[] args) {

        int[][] image = new int[][]{
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        String result = decompression(image);
        System.out.println(result); // --> "XX100110X1100​"

        image = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1}
        };
        result = decompression(image);
        System.out.println(result); // --> 'X0X101X10101X00X10011'

    }


    public static String decompression(int[][] image) {
        return aux(0, image.length - 1, 0, image.length - 1, image);
    }

    // 재귀를 위한 보조 함수
    // 파라미터는 차례대로 y좌표의 시작(Row Start), y좌표의 끝(Row End), x좌표의 시작(Col Start), x좌표의 끝(Col End)
    public static String aux(int rs, int re, int cs, int ce, int[][] image) {
        // base case
        // 각 좌표에는 number 타입이 저장되어 있다.
        if (rs == re) return String.valueOf(image[rs][cs]);

        // 좌상, 우상, 좌하, 우하로 구분한다.
        int midRow = (int)Math.floor((rs + re) / 2);
        int midCol = (int)Math.floor((cs + ce) / 2);
        String leftUpper = aux(rs, midRow, cs, midCol, image);
        String rightUpper = aux(rs, midRow, midCol + 1, ce, image);
        String leftDown = aux(midRow + 1, re, cs, midCol, image);
        String rightDown = aux(midRow + 1, re, midCol + 1, ce, image);

        // 주어진 사각형 전체를 순회하고 나서 재귀를 하거나
        // 4등분한 각 사각형을 각각 순회하고 나서 재귀를 하는 방식은 데이터를 중복 조회하게 된다.
        // 재귀적으로 각 결과를 합치면서 계산하면 모든 좌표를 한 번씩만 검토하면 된다.
        String result = leftUpper + rightUpper + leftDown + rightDown;
        if (result.equals("1111")) return "1";
        else if (result.equals("0000")) return "0";
        else return "X" + result;
    }

}
