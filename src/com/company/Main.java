package com.company;


//task#1 variant1

/*public class Main {
    public static void main(String[] args) {

    }
    public boolean scrollTo (int itemId) {
        while (!isDisplayed(itemId)) {
            scroll(); //it`s not mentioned in the task how many times we can use scroll() method: 10, 100 or more times in order to find the item.
        }
        return true;
    }
}*/

//task#1 variant2
/*
public class Main {
    public static void main(String[] args) {

    }
    public boolean scrollTo(int itemId){
        while (scroll()){
            if (isDisplayed(itemId)){
                return true;
            }
        }
        return false;
    }
}*/

//task#2

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static class Product {
        private final Integer id;
        private final String name;

        public Product(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        Map<String, Integer> stats = m.getExtraProductStats(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        m.print(Map.copyOf(stats));
    }

    public Map<String, Integer> getExtraProductStats(List<Integer> productIds) {
        Map<String, Integer> productStats = new HashMap();
        for (Integer id : productIds) {
            Product p = getProductById(id);
            if (p != null) {
                List<Product> extraProducts = getExtraProducts(p.getName());
                for (Product extra : extraProducts) {
                    Integer count = productStats.get(extra.getName());
                    if (count == null) {
                        productStats.put(extra.getName(), Integer.valueOf(1));
                    } else {
                        productStats.put(extra.getName(), count++);
                    }
                }
            }
        }
        return productStats;
    }

    public void print(Map<String, Integer> stats) {
        System.out.println("{");
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("}");
    }
}