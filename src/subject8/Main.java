package subject8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays.sort不能对自定义对象进行排序。现希望对自定义的PersonSortable类的对象，使用Arrays.sort进行排序。
 *
 * 1.编写PersonSortable类
 * 属性：private name(String)、private age(int)
 * 有参构造函数：参数为name,age
 * toString函数：返回格式为：name-age
 * 实现Comparable接口：实现先对name升序排序，如果name相同则对age进行升序排序
 *
 * 2.main方法中
 * 首先输入n
 * 输入n行name age，并创建n个对象放入数组
 * 对数组进行排序后输出。
 * 最后一行使用System.out.println(Arrays.toString(PersonSortable.class.getInterfaces()));输出PersonSortable所实现的所有接口
 * 输入样例:
 * 5
 * zhang 15
 * zhang 12
 * wang 14
 * Wang 17
 * li 17
 *
 * 输出样例:
 * Wang-17
 * li-17
 * wang-14
 * zhang-12
 * zhang-15
 * //这行是标识信息
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        PersonSortable[] personSortables = new PersonSortable[n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] strArray = input.split(" ");
            personSortables[i] = new PersonSortable(strArray[0],Integer.parseInt(strArray[1]));
        }
        Arrays.sort(personSortables);
        for (PersonSortable personSortable : personSortables) {
            System.out.println(personSortable);
        }
        System.out.println(Arrays.toString(PersonSortable.class.getInterfaces()));
    }

}

class PersonSortable implements Comparable<PersonSortable>{
    private String name;
    private int age;

    public PersonSortable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+"-"+this.age;
    }


    @Override
    public int compareTo(PersonSortable o) {
        if(this.name.equals(o.name)){
            return this.age - o.age;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}