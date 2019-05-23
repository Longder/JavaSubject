package subject2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 主要考察简单函数编写、Arrays的用法、String的截取与拼接。
 *
 * 运行程序后可以输入4个选项，分别为：fib,sort,search,getBirthDate
 *
 * fib:根据输入n，打印斐波那契数列。比如输入：3，输出：1 1 2
 *
 * sort:输入一串数字，然后进行排序并输出，注意数组元素输出格式，使用[ ]包括。提示：可直接使用函数Arrays相关函数处理输出。
 *
 * search:如果找到返回所找到的位置，如果没找到，返回-1。提示：可以对数组先排序，然后使用Arrays相关函数进行查找。
 *
 * getBirthDate:输入n个身份证，然后把输入的n个身份号的年月日抽取出来，按年-月-日格式输出。
 *
 * 当输入不是这几个字符串(fib,sort,search,getBirthDate)的时候，显示exit。
 *
 * 注意：在处理输入的时候，尽量全部使用Scanner的nextLine()方法接收输入，不要将nextLine()与其它next方法混用，否则可能会出现行尾回车换行未处理影响下次输入的情况。
 *
 * 参考：jdk文档的Arrays，String
 *
 * 输入格式:
 * fib
 * 3
 * sort
 * -1 10 3 2 5
 * search
 * -1
 * search
 * 0
 * getBirthDate
 * 1
 * 330226196605054190
 * e
 * 输出格式:
 * 1 1 2
 * [-1, 2, 3, 5, 10]
 * 0
 * -1
 * 1966-05-05
 * exit
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] intArray = new int[10];
        while("fib".equals(input)||"sort".equals(input)||"search".equals(input)||"getBirthDate".equals(input)){
            if("fib".equals(input)){
                fib(scanner);
            }else if("sort".equals(input)){
                intArray = sort(scanner);
            }else if("search".equals(input)){
                search(intArray,scanner);
            }else{
                getBirthDate(scanner);
            }
            input = scanner.nextLine();
        }
        System.out.println("exit");
    }

    public static void fib(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i<2){
                arr[i] = 1;
            }else{
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.print(arr[i]);
            if(i !=n-1){
                System.out.print(" ");
            }else{
                System.out.println();
            }
        }
    }

    public static int[] sort(Scanner scanner){
        String arraySource = scanner.nextLine();
        String[] strArray = arraySource.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i=0;i<intArray.length;i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        return intArray;
    }

    public static void search(int[] intArray,Scanner scanner){
        int n  = Integer.parseInt(scanner.nextLine());
        int index = Arrays.binarySearch(intArray,n);
        if(index<0){
            System.out.println(-1);
        }else{
            System.out.println(index);
        }
    }

    public static void getBirthDate(Scanner scanner){
        int n =  Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String idNo = scanner.nextLine();
            String birthDate = idNo.substring(6,14);
            String year = birthDate.substring(0,4);
            String month = birthDate.substring(4,6);
            String day = birthDate.substring(6,8);
            System.out.println(year+"-"+month+"-"+day);
        }
    }
}