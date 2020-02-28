package javaTest.GenericsTest;

import java.util.ArrayList;

public class Test {

    /**
     * 简单的泛型方法
     * @param x
     * @param y
     * @param <T>
     * @return
     */
    public static <T> T add(T x, T y){
        return y;
    }

    public static void main(String[] args) {

        /**
         * 不指定泛型的时候，两个参数都是Integer，所以T为integer类型
         */
        int i = Test.add(1,2);

        /**
         * Integer和Float，取同一父类最小级，为Number
         */
        Number f = Test.add(1,2.2);

        /**
         * Integer和String，取同一父类最小级，为Object
         */
        Object o = Test.add(1,"asd");


        /**
         * 指定泛型的时候，只能为Integer类型或者是其子类
         */
        int a = Test.<Integer>add(1,2);

        /**
         * 编译错误，指定为Integer，不能为Float
         */
//        int a = Test.<Integer>add(1,2.2);


        /**
         *  指定为Number，所以可以为Integer和Float
         */
        Number c = Test.<Number>add(1,2.2);

        ArrayList list = new ArrayList();
        list.add(1);
        list.add("asd");


    }
}
