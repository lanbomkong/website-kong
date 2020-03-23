import java.util.Stack;

/**
 * @description
 * @date 2019/10/30
 */
public class October_30 {

    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("123".substring(0, 2));
        System.out.println(trap);
    }

    public int numDecodings(String s) {
//        char[] numArrays = s.toCharArray();

        int[] sizeArray = new int[s.length()];
        sizeArray[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            Integer num = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num < 27) {

            }
        }

        return 1;
    }

    public static int trap(int[] height) {
        int[] A = height;

        if (A == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length) {
            if (s.isEmpty() || A[i] <= A[s.peek()]) {
                s.push(i++);
            } else {
                int bot = s.pop();
                maxBotWater = s.isEmpty() ? // empty means no il
                        0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;


//        List<Point> points = new ArrayList<>();
//        for (int i = 0; i < height.length; i++) {
//            Point point = new Point(i, height[i]);
//            points.add(point);
//        }
//        Collections.sort(points);
//        points.forEach(point -> {
//            System.out.println(point.getY() + "--" + point.getX());
//        });
//
//        int preIndex = points.get(points.size()-1).getX();
//        int sufIndex = points.get(points.size()-1).getX();
//        int totalArea = 0;
//        for (int i = points.size() - 2; i >= 0; i--) {
//            int partArea = 0;
//            int partAreaToDesc = 0;
//            int n = points.get(i).getX();
//            if (n > sufIndex) {
//                partArea = height[n] * (n - sufIndex -1);
//                while (++sufIndex < n) {
//                    partAreaToDesc += height[sufIndex];
//                }
//                totalArea += partArea - partAreaToDesc;
//            } else if (n < preIndex) {
//                partArea = height[n] * (preIndex - n -1);
//                while (n < --preIndex) {
//                    partAreaToDesc += height[preIndex];
//                }
//                totalArea += partArea - partAreaToDesc;
//            }
//        }
//
//        return totalArea;
    }

    static class Point implements Comparable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Object o) {
            Point point = (Point) o;
            return this.y > point.y ? 1 : this.y < point.y ? -1 : this.x > point.x ? 1 : this.x < point.x ? -1 : 0;
        }
    }
}
