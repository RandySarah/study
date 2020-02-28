package javaTest.GenericsTest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * 泛型擦除
 */
public class genericsTest {

    public static void main(String[] args) throws Exception{

        //原始类型相等
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        System.out.println(arrayList.getClass() == arrayList2.getClass());


        //通过反射添加其他类型的元素
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); //这样调用add方法只能存储整型，因为泛型类型的实例为Integer
        list.getClass().getMethod("add",Object.class).invoke(list,"asa");

        for (int i = 0; i < list.size(); ++i){
            System.out.println(list.get(i));
        }

    }


 }
