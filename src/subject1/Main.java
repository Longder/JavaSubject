package subject1;

import java.util.Random;
import java.util.Scanner;

/**
 * 尝试使用蒙特卡罗法计算圆周率（π）的值。原理如下：
 *
 * 以原点(0, 0)作为圆心，半径为1画一个圆。该圆的外切正方形，编程为2。
 *
 * 现往该正方形内随机投点，数量足够多的情况下，落入圆内的点与落入整个
 * 外切正方形的点的数量比值大概为：
 * ​4∗r
 * ​2
 * ​​
 * ​
 * ​π∗r
 * ​2
 * ​​
 * ​​ ，然后就可以得到π的值。
 *
 * 注意
 *
 * 请使用jdk库中的Random对象来生成随机数。
 * 使用Math库中的sqrt与pow函数来计算开根号与平方值。
 * 让点(x,y)投在整个矩形中，及x与y的取值范围为(-1≤x<1, -1≤y<1)。
 * 输入格式:
 * 随机数种子seed 投点个数n
 * 注意：seed为long型，n为int型
 *
 * 输出格式:
 * 计算出的值圆周率的值
 *
 * 输入样例:
 * 2 100000
 * 输出样例:
 * 3.14684
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");
        long seed = Long.parseLong(strArray[0]);
        int n = Integer.parseInt(strArray[1]);
        Random random = new Random(seed);
        int inSide = 0;
        for (int i = 0; i < n; i++) {
            //点
            double[] xAndY = new double[2];
            for (int j = 0; j < 2; j++) {
                xAndY[j] = random.nextDouble() * 2 - 1;
            }
            Point point = new Point(xAndY[0], xAndY[1]);
            if (point.isInside()) {
                inSide ++;
            }
        }
        double pi = 4.0*(inSide/(double)n);
        System.out.println(pi);
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //判断这个点是否在圆内
    public boolean isInside() {
        return Math.sqrt(x * x + y * y) < 1;
    }
}