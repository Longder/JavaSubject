package subject7;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 定义Person抽象类，Student类、Company类，Employee类。
 *
 * Person类的属性：String name, int age, boolean gender
 * Person类的方法:
 *
 * public Person(String name, int age, boolean gender);
 * public String toString();         //返回"name-age-gender"格式的字符串
 * public boolean equals(Object obj);//比较name、age、gender,都相同返回true,否则返回false
 *
 * Student类继承自Person，属性:String stuNo, String clazz
 * Student类的方法:
 *
 * //建议使用super复用Person类的相关有参构造函数
 * public Student(String name, int age, boolean gender, String stuNo, String clazz);
 * public String toString();         //返回 “Student:person的toString-stuNo-clazz”格式的字符串
 * public boolean equals(Object obj);//首先调用父类的equals方法,如果返回true，则继续比较stuNo与clazz。
 * Company类属性：String name
 * Company类方法:
 *
 * public Company(String name);
 * public String toString();         //直接返回name
 * public boolean equals(Object obj);//name相同返回true
 * Employee类继承自Person，属性：Company company, double salary
 * Employee类方法：
 *
 * //建议使用super复用Person类的相关有参构造函数
 * public Employee(String name, int age, boolean gender, double salary, Company company);
 * public String toString();         //返回"Employee:person的toString-company-salary"格式的字符串
 * public boolean equals(Object obj);//首先调用父类的equals方法,如果返回true。再比较company与salary。
 * //比较salary属性时，使用DecimalFormat df = new DecimalFormat("#.#");保留1位小数
 * 编写equals方法重要说明：
 *
 * 对Employee的company属性的比较。要考虑传入为null的情况。如果company不为null且传入为null，返回false
 * 对所有String字符类型比较时，也要考虑null情况。
 * 提示
 * 排序可使用Collections.sort
 * equals方法要考虑周全
 * main方法说明
 * 创建若干Student对象、Employee对象。
 * 输入s，然后依次输入name age gender stuNo clazz创建Student对象。
 * 输入e，然后依次输入name age gender salary company创建Employee对象。
 * 然后将创建好的对象放入List<Person> personList。输入其他字符，则结束创建。
 * 创建说明:对于String类型，如果为null则不创建对象，而赋值为null。对于company属性，如果为null则赋值为null，否则创建相应的Company对象。
 *
 * 对personList中的元素实现先按照姓名升序排序，姓名相同再按照年龄升序排序。提示：可使用Comparable<Person>或Comparator<Person>
 *
 * 接受输入，如果输入为exit则return退出程序，否则继续下面步骤。
 *
 * 将personList中的元素按照类型分别放到stuList与empList。注意：不要将两个内容相同的对象放入列表（是否相同是根据equals返回结果进行判定）。
 *
 * 输出字符串stuList，然后输出stuList中的每个对象。
 *
 * 输出字符串empList，然后输出empList中的每个对象。
 *
 * 1-3为一个测试点 4-6为一个测试点
 *
 * 输入样例：
 * s zhang 23 false 001 net15
 * e wang 18 true 3000.51 IBM
 * s zhang 23 false 001 net15
 * e bo 25 true 5000.51 IBM
 * e bo 25 true 5000.52 IBM
 * e bo 18 true 5000.54 IBM
 * e tan 25 true 5000.56 IBM
 * e tan 25 true 5000.51 IBM
 * s wang 17 false 002 null
 * s wang 17 false 002 null
 * e hua 16 false 1000 null
 * s wang 17 false 002 net16
 * e hua 16 false 1000 null
 * e hua 18 false 1234 MicroSoft
 * !
 * continue
 * 输出样例：
 * Employee:bo-18-true-IBM-5000.54
 * Employee:bo-25-true-IBM-5000.51
 * Employee:bo-25-true-IBM-5000.52
 * Employee:hua-16-false-null-1000.0
 * Employee:hua-16-false-null-1000.0
 * Employee:hua-18-false-MicroSoft-1234.0
 * Employee:tan-25-true-IBM-5000.56
 * Employee:tan-25-true-IBM-5000.51
 * Student:wang-17-false-002-null
 * Student:wang-17-false-002-null
 * Student:wang-17-false-002-net16
 * Employee:wang-18-true-IBM-3000.51
 * Student:zhang-23-false-001-net15
 * Student:zhang-23-false-001-net15
 * stuList
 * Student:wang-17-false-002-null
 * Student:wang-17-false-002-net16
 * Student:zhang-23-false-001-net15
 * empList
 * Employee:bo-18-true-IBM-5000.54
 * Employee:bo-25-true-IBM-5000.51
 * Employee:hua-16-false-null-1000.0
 * Employee:hua-18-false-MicroSoft-1234.0
 * Employee:tan-25-true-IBM-5000.56
 * Employee:tan-25-true-IBM-5000.51
 * Employee:wang-18-true-IBM-3000.51
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");
        List<Person> personList = new ArrayList<>();
        while("s".equals(strArray[0])||"e".equals(strArray[0])){
            if("s".equals(strArray[0])){
                Student student = new Student(strArray[1].equals("null")?null:strArray[1],
                        Integer.parseInt(strArray[2]),Boolean.valueOf(strArray[3]),
                        strArray[4].equals("null")?null:strArray[4],strArray[5].equals("null")?null:strArray[5]);
                personList.add(student);
            }else{
                Company company = strArray[5].equals("null")?null:new Company(strArray[5]);
                Employee employee = new Employee(strArray[1].equals("null")?null:strArray[1],
                        Integer.parseInt(strArray[2]),Boolean.valueOf(strArray[3]),company,Double.parseDouble(strArray[4]));
                personList.add(employee);
            }
            input = scanner.nextLine();
            strArray = input.split(" ");
        }
        Collections.sort(personList);
        for (Person person : personList) {
            System.out.println(person);
        }
        input = scanner.nextLine();
        if(!"exit".equals(input)){
            List<Student> stuList = new ArrayList<>();
            List<Employee> empList = new ArrayList<>();
            for (Person person : personList) {
                if(person instanceof Student&&!stuList.contains(person)){
                    stuList.add((Student) person);
                }
                if(person instanceof Employee&&!empList.contains(person)){
                    empList.add((Employee) person);
                }
            }
            System.out.println("stuList");
            for (Student student : stuList) {
                System.out.println(student);
            }
            System.out.println("empList");
            for (Employee employee : empList) {
                System.out.println(employee);
            }
        }
    }
}

abstract class Person implements Comparable<Person>{
    private String name;
    private int age;
    private boolean gender;

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name+"-"+this.age+"-"+this.gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return this.name.equals(((Person) obj).name) && this.age == ((Person) obj).age && this.gender == ((Person) obj).gender;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Person p) {
        if (this.name.compareTo(p.name) < 0) {
            return -1;
        } else if (this.name.compareTo(p.name) > 0) {
            return 1;
        } else {
            return this.age - p.age;
        }
    }
}

class Student extends Person{
    private String stuNo;
    private String clazz;

    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
        super(name, age, gender);
        this.stuNo = stuNo;
        if(clazz==null){
            this.clazz = "null";
        }else{
            this.clazz = clazz;
        }
    }
    @Override
    public String toString() {
        return "subject7.Student:"+super.toString()+"-"+this.stuNo+"-"+this.clazz;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Student) {
            return super.equals(obj) && this.stuNo.equals(((Student) obj).stuNo) && this.clazz.equals(((Student) obj).clazz);
        } else {
            return false;
        }
    }
}
class Company{
    private String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Company) {
            return ((Company) obj).name.equals(this.name);
        } else {
            return false;
        }
    }
}
class Employee extends Person{
    private Company company;
    private double salary;

    public Employee(String name, int age, boolean gender, Company company, double salary) {
        super(name, age, gender);
        this.company = company;
        this.salary = salary;
    }

    @Override
    public String toString() {
        if(company == null){
            return "subject7.Employee:"+super.toString()+"-null-"+this.salary;
        }else{
            return "subject7.Employee:"+super.toString()+"-"+company.toString()+"-"+this.salary;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Employee) {
            Employee t = (Employee) obj;
            if (super.equals(obj)) {
                DecimalFormat p = new DecimalFormat("#.#");
                if(t.company==null){
                    if(this.company==null){
                        return p.format(t.salary).equals(p.format(salary));
                    }else{
                        return false;
                    }
                }else{
                    if(this.company!=null){
                        return t.company.equals(company) && p.format(t.salary).equals(p.format(salary));
                    }else{
                        return false;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }
}