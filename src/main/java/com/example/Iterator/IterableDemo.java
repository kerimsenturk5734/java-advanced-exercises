package com.example.Iterator;

import java.util.*;

public class IterableDemo {

    public static void main(String[] args) {
        /**
         *  Array, list, map gibi içerisinde birden çok veriyi tutan
         *  Collection class'ları/interface'leri, Iterable yani gezilebilir veri yapılarıdır.
         *  Bu özelliği sağlayan hepsinin super class'ı olan Collection
         *  interface'ının Iterable interface'ini extend etmesinde gelir.
         */

        //ArrayList üzerindeki tanımlı iterable nesnesini alırız.
        Iterable<Integer> iterable = new ArrayList<>(Arrays.asList(17,52,43,63,25));

        /**
         *  Iterable interface'i içerisindeki Iterator methodu ile bu yapılar
         *  üzerinde gezinme işlemini yapan Iterator nesnesini geri döner.
         */

        while(iterable.iterator().hasNext()){
            System.out.println(iterable.iterator().next());
        }

        /**
         *  forEach() methodu sayesinde her bir eleman üzerinde sırayla
         *  parametrede belirtilen Consumer methodu uyguyalaabiliriz.
         *  Bu işlemi yaparken iterator nesnesini kullanmaz.
         */

        iterable.forEach(System.out::println);
    }
}