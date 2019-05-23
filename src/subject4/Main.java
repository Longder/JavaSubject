package subject4;
import java.util.*;

/**
 * 本习题主要用于练习如何使用ArrayList来替换数组。
 * 新建1个ArrayList<String> strList用来存放字符串，然后进行如下操作。
 *
 * 提示:查询Jdk文档中的ArrayList。
 * 注意:请使用System.out.println(strList)输出列表元素。
 *
 * 输入格式
 * 输入n个字符串，放入strList。直到输入为!!end!!时，结束输入。
 *
 * 在strList头部新增一个begin，尾部新增一个end。
 *
 * 输出列表元素
 *
 * 输入:字符串str
 *
 * 判断strList中有无包含字符串str，如包含输出true，否则输出false。并且输出下标，没包含返回-1。
 *
 * 在strList中从后往前找。返回其下标，找不到返回-1。
 *
 * 移除掉第1个(下标为0)元素,并输出。然后输出列表元素。
 *
 * 输入:字符串str
 *
 * 将第2个（下标为1）元素设置为字符串str.
 *
 * 输出列表元素
 *
 * 输入:字符串str
 *
 * 遍历strList，将字符串中包含str的元素放入另外一个ArrayList strList1，然后输出strList1。
 *
 * 在strList中使用remove方法，移除第一个和str相等的元素。
 *
 * 输出strList列表元素。
 *
 * 使用clear方法，清空strList。然后输出strList的内容，size()与isEmpty()，3者之间用,连接。
 *
 * 输入样例:
 * a1 b1 3b a2 b2 12b c d !!end!!
 * b1
 * second
 * b
 * 输出样例:
 * [begin, a1, b1, 3b, a2, b2, 12b, c, d, end]
 * true
 * 2
 * 2
 * begin
 * [a1, b1, 3b, a2, b2, 12b, c, d, end]
 * [a1, second, 3b, a2, b2, 12b, c, d, end]
 * [3b, b2, 12b]
 * [a1, second, 3b, a2, b2, 12b, c, d, end]
 * [],0,true
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] sources = input.split(" ");
        if("!!end!!".equals(sources[sources.length-1])){
            sources[sources.length-1] = null;
        }
        List<String> strList = new ArrayList<>(Arrays.asList(sources));
        strList.remove(strList.size()-1);
        strList.add(0,"begin");
        strList.add(strList.size(),"end");
        System.out.println(strList);
        input = scanner.nextLine();
        if(strList.contains(input)){
            System.out.println(true);
            System.out.println(strList.indexOf(input));
        }else {
            System.out.println(false);
            System.out.println(-1);
        }
        int index =-1;
        for(int i=strList.size()-1;i>=0;i--){
            if(input.equals(strList.get(i))){
                index = i;
                break;
            }
        }
        System.out.println(index);
        String firstOne = strList.remove(0);
        System.out.println(firstOne);
        System.out.println(strList);
        String str = scanner.nextLine();
        strList.set(1,str);
        System.out.println(strList);
        str = scanner.nextLine();
        List<String> strList1 = new ArrayList<>();
        for(String value:strList){
            if(value.contains(str)){
                strList1.add(value);
            }
        }
        System.out.println(strList1);
        Iterator<String> it = strList.iterator();
        while(it.hasNext()){
            if(str.equals(it.next())){
                it.remove();
                break;
            }
        }
        System.out.println(strList);
        strList.clear();
        System.out.println(String.format("%s,%s,%s",strList,strList.size(),strList.isEmpty()));
    }
}