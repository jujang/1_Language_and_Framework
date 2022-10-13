public class Q54_largestRectangularArea_ref {
    public static void main(String[] args) {

        int[] histogram = new int[]{2, 1, 4, 5, 1, 3, 3};
        int output = largestRectangularArea(histogram);
        System.out.println(output); // --> 8

        histogram = new int[]{6, 2, 5, 4, 5, 1, 6};
        output = largestRectangularArea(histogram);
        System.out.println(output); // --> 12

    }

    public static int largestRectangularArea(int[] histogram) {

       int largest = 0;
       // 모든 연속된 부분 히스토그램을 고려한다.
       // 밑변의 길이를 부분 히스토그램의 길이로 고정하면, 높이는 가장 낮은 막대의 높이가 된다.
       for (int left = 0; left < histogram.length; left++) {
          // 길이가 1인 막대로 만들 수 있는 직사각형의 넓이는 막대의 높이와 같다.
          int min = histogram[left];
          for (int right = left; right < histogram.length; right++) {
            // left부터 right까지의 히스토그램의 막대 중 가장 낮은 막대의 높이를 구한다.
            if (histogram[right] < min) min = histogram[right];
            // 해당 구간(left ~ right)의 막대를 전부 포함해서 만들 수 있는 직사각형의 넓이를 구한다.
            int area = min * (right - left + 1);
            // 매번 구한 면적을 기존의 면적과 비교해 갱신한다.
            if (area > largest) largest = area;
         }
       }
       return largest;

    }

}
