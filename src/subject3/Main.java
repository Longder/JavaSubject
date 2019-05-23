package subject3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 定义长方形类与圆形类Circle
 * 长方形类-类名：Rectangle，private属性：int width,length
 * 圆形类-类名：Circle，private属性:int radius
 *
 * 编写构造函数：
 * 带参构造函数:Rectangle(width, length),Circle(radius)
 *
 * 编写方法：
 * public int getPerimeter()，求周长。
 * public int getArea()，求面积。
 * toString方法，使用Eclipse自动生成。
 *
 * 注意：
 *
 * 计算圆形的面积与周长，使用Math.PI。
 * 求周长和面积时，应先计算出其值(带小数位)，然后强制转换为int再返回。
 * 2. main方法
 * 输入2行长与宽，创建两个Rectangle对象放入相应的数组。
 * 输入2行半径，创建两个Circle对象放入相应的数组。
 * 输出1：上面2个数组中的所有对象的周长加总。
 * 输出2：上面2个数组中的所有对象的面积加总。
 * 最后需使用Arrays.deepToString分别输出上面建立的Rectangle数组与Circle数组
 * 思考：如果初次做该题会发现代码冗余严重。使用继承、多态思想可以大幅简化上述代码。
 *
 * 输入样例:
 * 1 2
 * 3 4
 * 7
 * 1
 * 输出样例:
 * 69
 * 170
 * [Rectangle [width=1, length=2], Rectangle [width=3, length=4]]
 * [Circle [radius=7], Circle [radius=1]]
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] sourceArray = input.split(" ");
        Rectangle[] rectangles = new Rectangle[2];
        Rectangle r1 = new Rectangle(Integer.parseInt(sourceArray[0]),Integer.parseInt(sourceArray[1]));
        rectangles[0] = r1;
        input = scanner.nextLine();
        sourceArray = input.split(" ");
        Rectangle r2 = new Rectangle(Integer.parseInt(sourceArray[0]),Integer.parseInt(sourceArray[1]));
        rectangles[1] = r2;

        Circle[] circles = new Circle[2];
        input = scanner.nextLine();
        Circle c1 = new Circle(Integer.parseInt(input));
        circles[0] = c1;
        input = scanner.nextLine();
        Circle c2 = new Circle(Integer.parseInt(input));
        circles[1] = c2;

        int totalPerimeter = 0;
        int totalArea = 0;
        for (Rectangle rectangle : rectangles) {
            totalPerimeter += rectangle.getPerimeter();
            totalArea += rectangle.getArea();
        }
        for (Circle circle : circles) {
            totalPerimeter += circle.getPerimeter();
            totalArea += circle.getArea();
        }

        System.out.println(totalPerimeter);
        System.out.println(totalArea);

        System.out.println(Arrays.deepToString(rectangles));
        System.out.println(Arrays.deepToString(circles));

    }
}



class Rectangle{
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getPerimeter(){
        return (this.width+this.length) * 2;
    }

    public int getArea(){
        return this.width*this.length;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", length=" + length + "]";
    }

}

class Circle{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getPerimeter(){
        return (int) (2 * Math.PI * this.radius);
    }

    public int getArea(){
        return (int) (Math.PI * Math.pow(this.radius,2));
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}