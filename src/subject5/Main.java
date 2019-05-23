package subject5;
import java.util.Scanner;
import java.util.Stack;


/**
 * 1.定义一个Person类
 * 属性：name(String)、gender（boolean)、age(int)、id(int) ，所有的变量必须为私有(private)。
 * 无参构造函数:Person(), 功能：打印This is constructor 。
 * 有参构造函数:Person(name, gender, age) ，功能：给属性赋值。
 * 建议：使用Eclipse自动生成toString方法
 *
 * 2.定义类的初始化块
 * 为Person类加入初始化块，在初始化块中对id属性赋值，并且要保证每次的值比上次创建的对象
 * 的值+1。然后在下一行打印This is initialization block, id is ... 其中...是id的值。
 * 提示：可为Person类定义一个static属性来记录所创建的对象个数。
 *
 * 3.编写静态初始化块
 * 打印This is static initialization block
 *
 * 4.编写main方法
 * 首先输入n，代表要创建的对象数量。
 * 然后从控制台分别读取n行的name, gender, age, 并调用有参构造函数Person(name, age, gender)新建对象 。
 * 将创建好的n个对象逆序输出(即输出toString()方法)。
 * 使用无参构造函数新建一个Person对象，然后直接打印该对象。
 * 思考
 * 初始化类与对象有几种方法，构造函数、初始化块、静态初始化块。这三种方法执行的先后顺序是什么？各执行几次。
 *
 * 输入样例:
 * 3
 * a 11 false
 * b 12 true
 * c 10 false
 * 输出样例:
 * This is static initialization block
 * This is initialization block, id is 0
 * This is initialization block, id is 1
 * This is initialization block, id is 2
 * Person [name=c, age=10, gender=false, id=2]
 * Person [name=b, age=12, gender=true, id=1]
 * Person [name=a, age=11, gender=false, id=0]
 * This is initialization block, id is 3
 * This is constructor
 * null,0,false,3
 * Person [name=null, age=0, gender=false, id=3]
 */
class Person {
    private static int num = 0;

    static {
        System.out.println("This is static initialization block");
    }

    private String name = null;
    private boolean gender = false;
    private int age = 0;
    private int id;

    public Person(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        id = num;
        num++;
    }

    public Person() {
        System.out.println("This is initialization block, id is " + num);
        System.out.println("This is constructor");
        id = num;
        num++;
        System.out.println(name + "," + age + "," + gender + "," + id);
        System.out.println(toString());
    }

    public static int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Person [" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", id=" + id +
                ']';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        Stack stack = new Stack();
        for (int i = 0; i < time; i++) {
            String name = scanner.next();
            int age = Integer.valueOf(scanner.next());
            boolean gender = Boolean.valueOf(scanner.next());
            Person p = new Person(name, gender, age);
            System.out.println("This is initialization block, id is " + i);
            stack.push(p);
        }
        for (int i = 0; i < Person.getNum(); i++) {
            Person person = (Person) stack.peek();
            System.out.println(person);
            stack.pop();
        }
        new Person();
    }
}