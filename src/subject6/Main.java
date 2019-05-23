package subject6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 前言
 * 前面题目形状中我们看到，为了输出所有形状的周长与面积，需要建立多个数组进行多次循环。这次试验使用继承与多态来改进我们的设计。
 *
 * 本题描述：
 * 定义抽象类Shape
 * 属性：不可变静态常量double PI，值为3.14，
 * 抽象方法:public double getPerimeter(),public double getArea()
 * Rectangle与Circle类均继承自Shape类。
 * Rectangle类(属性：int width,length)、Circle类(属性：int radius)。
 * 带参构造函数为Rectangle(int width,int length),Circle(int radius)。
 * toString方法(Eclipse自动生成)
 * 编写double sumAllArea方法计算并返回传入的形状数组中所有对象的面积和与
 * double sumAllPerimeter方法计算并返回传入的形状数组中所有对象的周长和。
 * main方法
 * 4.1 输入整型值n，然后建立n个不同的形状。如果输入rect，则再输入长和宽。如果输入cir，则再输入半径。
 * 4.2 然后输出所有的形状的周长之和，面积之和。并将所有的形状信息以样例的格式输出。 提示：使用Arrays.toString。 4.3 最后输出每个形状的类型与父类型.使用类似shape.getClass()(获得类型),shape.getClass().getSuperclass()(获得父类型);
 * 注意：处理输入的时候使用混合使用nextInt与nextLine需注意行尾回车换行问题。
 *
 * 思考
 * 你觉得sumAllArea和sumAllPerimeter方法放在哪个类中更合适？
 *
 * 输入样例:
 * 4
 * rect
 * 1 1
 * rect
 * 2 2
 * cir
 * 1
 * cir
 * 2
 * 输出样例:
 * 30.840000000000003
 * 20.700000000000003
 * [Rectangle [width=1, length=1], Rectangle [width=2, length=2], Circle [radius=1], Circle [radius=2]]
 * class Rectangle,class Shape
 * class Rectangle,class Shape
 * class Circle,class Shape
 * class Circle,class Shape
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Shape[] shapes = new Shape[n];
        for(int i=0;i<n;i++){
            String input = scanner.nextLine();
            if("rect".equals(input)){
                input = scanner.nextLine();
                String[] strArray = input.split(" ");
                shapes[i] = new Rectangle(Integer.parseInt(strArray[0]),Integer.parseInt(strArray[1]));
            }else if("cir".equals(input)){
                int r = Integer.parseInt(scanner.nextLine());
                shapes[i] = new Circle(r);
            }else{
                break;
            }
        }
        double totalPerimeter = sumAllPerimeter(shapes);
        double totalArea = sumAllArea(shapes);
        System.out.println(totalPerimeter);
        System.out.println(totalArea);
        System.out.println(Arrays.toString(shapes));
        for (Shape shape : shapes) {
            System.out.println(shape.getClass()+","+shape.getClass().getSuperclass());
        }

    }

    public static double sumAllArea(Shape[] shapes){
        double totle = 0;
        for (Shape shape : shapes) {
            totle +=shape.getArea();
        }
        return totle;
    }

    public static double sumAllPerimeter(Shape[] shapes){
        double total = 0;
        for (Shape shape : shapes) {
            total +=shape.getPerimeter();
        }
        return total;
    }
}

abstract class Shape{
    final static double PI = 3.14;

    public abstract double getPerimeter();

    public abstract double getArea();
}

class Rectangle extends Shape{
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (this.width+this.length) * 2;
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", length=" + length + "]";
    }

}

class Circle extends Shape{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return PI * Math.pow(this.radius,2);
    }

    @Override
    public double getPerimeter(){
        return 2 * PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}
