package lr9;

import java.util.*;

public class speed {
    private static final int BASE_SIZE = 20_000_000;
    @SuppressWarnings("unused")
    private static final int GET_ITERATIONS = 20_000_000_000L > Integer.MAX_VALUE ?
            Integer.MAX_VALUE : (int) 20_000_000_000L; // Ограничение int

    public static void main(String[] args) {
        List<Integer> arrayList = createArrayList(BASE_SIZE);
        SortedSet<Integer> sortedSet = createSortedSet(BASE_SIZE);
        TreeSet<Integer> treeSet = createTreeSet(BASE_SIZE);

        System.out.println("ТАБЛИЦА 1: Добавление элемента");
        System.out.println("+----------------------+------------+------------+------------+");
        System.out.println("| Операция             | ArrayList  | SortedSet  | TreeSet    |");
        System.out.println("+----------------------+------------+------------+------------+");

        printRow("В начало", 
            timeAddFirst(new ArrayList<>(arrayList)), 
            timeAddAny(new TreeSet<>(sortedSet)), 
            timeAddAny(treeSet)
        );

        printRow("В конец", 
            timeAddLast(new ArrayList<>(arrayList)), 
            timeAddAny(new TreeSet<>(sortedSet)), 
            timeAddAny(treeSet)
        );

        printRow("В середину", 
            timeAddMiddle(new ArrayList<>(arrayList)), 
            timeAddAny(new TreeSet<>(sortedSet)), 
            timeAddAny(treeSet)
        );

        System.out.println("+----------------------+------------+------------+------------+\n");

        System.out.println("ТАБЛИЦА 2: Удаление элемента");
        System.out.println("+----------------------+------------+------------+------------+");
        System.out.println("| Операция             | ArrayList  | SortedSet  | TreeSet    |");
        System.out.println("+----------------------+------------+------------+------------+");

        printRow("Из начала", 
            timeRemoveFirst(new ArrayList<>(arrayList)), 
            timeRemoveFirst(new TreeSet<>(sortedSet)), 
            timeRemoveFirst(treeSet)
        );

        printRow("Из конца", 
            timeRemoveLast(new ArrayList<>(arrayList)), 
            timeRemoveLast(new TreeSet<>(sortedSet)), 
            timeRemoveLast(treeSet)
        );

        printRow("Из середины", 
            timeRemoveMiddle(new ArrayList<>(arrayList)), 
            timeRemoveMiddle(new TreeSet<>(sortedSet)), 
            timeRemoveMiddle(treeSet)
        );

        System.out.println("+----------------------+------------+------------+------------+\n");

        System.out.println("ТАБЛИЦА 3: Получение по индексу (" + GET_ITERATIONS + " раз)");
        System.out.println("+----------------------+------------+------------+------------+");
        System.out.println("| Операция             | ArrayList  | SortedSet  | TreeSet    |");
        System.out.println("+----------------------+------------+------------+------------+");

        long arrayListGet = timeGetByIndex(new ArrayList<>(arrayList));
        System.out.printf("| По индексу           | %10d | %10s | %10s |\n", 
                arrayListGet, "Н/Д", "Н/Д");
        System.out.println("+----------------------+------------+------------+------------+\n");
    }

    private static List<Integer> createArrayList(int size) {
        List<Integer> list = new ArrayList<>(size);
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt());
        }
        return list;
    }

    private static SortedSet<Integer> createSortedSet(int size) {
        SortedSet<Integer> set = new TreeSet<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            set.add(rnd.nextInt());
        }
        return set;
    }

    private static TreeSet<Integer> createTreeSet(int size) {
        TreeSet<Integer> set = new TreeSet<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            set.add(rnd.nextInt());
        }
        return set;
    }

    private static long timeAddFirst(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(0, -1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddLast(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(-1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddMiddle(List<Integer> list) {
        int mid = list.size() / 2;
        long start = System.currentTimeMillis();
        list.add(mid, -1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddAny(SortedSet<Integer> set) {
        int val = set.size() + 1;
        long start = System.currentTimeMillis();
        set.add(val);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveFirst(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(0);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveFirst(SortedSet<Integer> set) {
        Integer first = set.first();
        long start = System.currentTimeMillis();
        set.remove(first);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveLast(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(list.size() - 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveLast(SortedSet<Integer> set) {
        Integer last = set.last();
        long start = System.currentTimeMillis();
        set.remove(last);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveMiddle(List<Integer> list) {
        int mid = list.size() / 2;
        long start = System.currentTimeMillis();
        list.remove(mid);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveMiddle(SortedSet<Integer> set) {
        List<Integer> copy = new ArrayList<>(set);
        Integer midVal = copy.get(copy.size() / 2);
        long start = System.currentTimeMillis();
        set.remove(midVal);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeGetByIndex(List<Integer> list) {
        int size = list.size();
        long start = System.nanoTime();
        for (int i = 0; i < GET_ITERATIONS; i++) {
            list.get(i % size);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    private static void printRow(String op, long a, long b, long c) {
        System.out.printf("| %-20s | %10d | %10d | %10d |\n", op, a, b, c);
    }
}
