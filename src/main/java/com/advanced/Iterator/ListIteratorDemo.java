package com.advanced.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        /**
         * ListIterator, Iterator interface'ini extend eden
         * bir diğer iterator yapısıdır. List'lerin üzerinde
         * daha efektif gezinmek için oluşturulmuştur.

         * İçerisinde birden fazla eklenmiş yeni method vardır.
         */

        List<String> followers = new ArrayList<>(
                Arrays.asList(
                        "Cristiano Ronaldo",
                        "Dua Lipa",
                        "The Rock",
                        "Jennifer Lopez",
                        "Gigi Hadid",
                        "Barbara Palvin",
                        "Ana de Armas",
                        "Emilia Clarke"));

        ListIterator<String> listIterator = followers.listIterator();
        System.out.println("Iterator is going forward...");
        while(listIterator.hasNext()){
            System.out.println("--> " + listIterator.next());
        }
        /**
         * Burada sadece iterator'dan farklı olan methodları anlatacağım!!!
         */

        /**
         * hasPrevious() methodu, iteratoru'un mevcut bulunduğu konumdan
         * öncesinde bir eleman olup olmadığını boolean dönerek gösterir.


         * previous() methodu geriye mevcut elemanı döndürür ve iterator'u
         * index'i bir azaltarak mevcut bulunduğu konumdan bir önceki konuma getirir
         */

        System.out.println("Iterator is going backward...");
        while(listIterator.hasPrevious()){
            System.out.println("--> " + listIterator.previous());
        }

        /**
         * nextIndex() methodu iterator'un mevcut bulunduğu konumdan
         * bir sonraki konumun index'ini döner.
         */

        System.out.println("Iterator is going forward with indexes...");
        while(listIterator.hasNext()){
            System.out.printf("Followers list has '%s' at index %d\n",
                    listIterator.next(), listIterator.nextIndex()-1);
        }

        /**
         * previousIndex() methodu iterator'un mevcut bulunduğu konumdan
         * bir önceki konumun index'ini döner.
         */

        System.out.println("Iterator is going backward with indexes...");
        while(listIterator.hasPrevious()){
            System.out.printf("Followers list has '%s' at index %d\n",
                    listIterator.previous(), listIterator.previousIndex() + 1);
        }

        /**
         * set(E e) methodu'u iterator'un next() veya previous() ile son döndürdüğü
         * eleman ile parametrede belirtilen elemanı yer değiştirir. Bu durumda aşağıda
         * iki kere next() yapmamız sonunda en son 'Dua Lipa' değerini döndürür.
         * set('Megan Fox') çağrısı ile de 'Dua Lipa' yerine 'Megan Fox' u yeni takipçimiz yaparız. :D
         */
        listIterator.next();
        listIterator.next();

        listIterator.set("Megan Fox");

        /**
         *  Iterator'u sıfırlamak için yeniden atamak gerek.
         *  Aksi halde kaldığı index'den devam edecektir işlemlere.
         */
        listIterator = followers.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        /**
         * add(E e) method'u next() ile dönülecek elemandan hemen öncesine ya da
         * previous() ile dönülecek değerin hemen sonrasına belirtilen elemanı ekler.
         * Eğer listede eleman yoksa tek elemanlı bir liste oluşur.
         */



        listIterator = followers.listIterator();

        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.previous();

        listIterator.add("Jennifer Lawrence");

        listIterator = followers.listIterator();
        System.out.println("------------------------");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }
}
