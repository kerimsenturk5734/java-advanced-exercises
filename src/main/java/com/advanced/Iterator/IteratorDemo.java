package com.advanced.Iterator;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        /**
         * Iterator interface'i, üzerinde gezinebileceğimiz
         * yani Iterable sınıflar üzerinde kullanılır.
         */

        /**
         * Her collection bir iterator'a sahiptir
         * Bu örnekte map sınıfını kullanalım.
         */
        Map<Integer, String> map = new HashMap<>(
                Map.of(
                        1, "One",
                        2, "Two",
                        3, "Three",
                        10, "Ten"));

        /**
         * Map sınıfı EntrySet ve KeySet olarak iki farklı set'e sahip
         * olduğu için her biri için ayrı iterator'u vardır. Bu örnekte
         * EntrySet'i kullandık.
         */
        Iterator<Map.Entry<Integer, String>> entrySetIterator = map.entrySet().iterator();

        /**
         * hasNext() methodu collection'nın sonuna gelip gelmediğimizi
         * gösteren boolean döndürür.
         */

        /**
         * next() methodu geriye mevcut elemanı döndürür ve iterator'u
         * index'i bir artırarak mevcut bulunduğu konumdan bir sonraki konuma getirir.
         */
        while (entrySetIterator.hasNext()){
            System.out.println("Entry set value : " + entrySetIterator.next());
        }

        /**
         * Bir iterator bir kere yapının sonuna kadar gezdikten sonra geri dönemez.
         * Bu yüzden tekrardan mevcut yapının iterator'unu almamız gerekir.
         */
        entrySetIterator = map.entrySet().iterator();

        /**
         * remove() methodu iterator'un üzerinde bulunduğu elemanı yapıdan siler.
         * Bu methodu kullanmak için önce iterator.next() methodunun bir kere
         * çağrılmış olması gerekir. Aksi halde IllegalStateException döndürür.
         * remove() methodunu çağırırken sürekli next() yapmak unutulmamılıdır.
         */
        while(entrySetIterator.hasNext()){
            entrySetIterator.next();
            entrySetIterator.remove();
        }

        Map<String, String> countryCapitalMap = new HashMap<>(
                Map.of(
                        "TUR", "Ankara",
                        "USA", "Washington",
                        "CHI", "Pekin",
                        "POL", "Varşova"));

        Iterator<String> keyIterator = countryCapitalMap.keySet().iterator();

        keyIterator.next();
        keyIterator.next();

        /**
         * forEachRemaining() methodu iterator.next() yaparak
         * parametre ile verilen Consumer methodu veriler
         * üzerinde uygular.

         * Bu işi yaparken iterator mevcutta neredeyse oradan başlar
         * ve yapının sonuna gider.
         * Bu yüzden önceden iki kere next() işlemini uyguladğımız
         * için kalan veriler için println() fonksiyonunu uyguladı.
         */
        keyIterator.forEachRemaining(System.out::println);
    }
}
