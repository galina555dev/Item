import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Program {

    /*
    &  - побитовое логическое "И"
    |  - побитовое логическое "ИЛИ"
    << - битовый сдвиг влево
    >> - битовый сдвиг вправо
     */
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(356.4,10),
                new Item(13.75, 40),
                new Item(136.63, 70),
                new Item(13, 300),
                new Item(130, 200)
        );
        List<List<Item>>ListOfList=getAllSubsets(items);
        double maxWeight = 200.0;
        System.out.println("Max cost : " + findMaxCost(items, maxWeight));
        System.out.println("findBestSetOfItems:"+findBestSetOfItems(maxWeight,items));
        System.out.println("getAllSubsets:");
        for (List<Item> list : ListOfList) {
            System.out.println("\n"+list);
        }

    }

    //Возвращает true, если число является степенью двойки.
    public static boolean isPowerOfTwoNaive(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        return number == 1;
    }

    public static boolean isPowerOfTwoOptimized(int number) {
        return (number & (number - 1)) == 0;
    }

    //Есть список вещей, есть ограничение по максимальному весу. Определить максимальную суммарную стоимость награбленного
    public static double findMaxCost(List<Item> items, double maxWeight) {
        double maxCost = 0.0;
        for (int mask = 0; mask < (1 << items.size()); ++mask) {
            //На данной итерации мы имеем какой-то набор вещей.
            double totalCost = 0;      //Суммарная стоимость
            double totalWeight = 0;    //Суммарный вес
            for (int index = 0; index < items.size(); ++index) {
                int value = (mask >> index) & 1;
                if (value == 1) {
                    totalCost += items.get(index).getCost();
                    totalWeight += items.get(index).getWeight();
                }
            }
            //Здесь мы будем иметь суммарную стоимость данного набора вещей и суммарный вес.'
            //Если мы можем поместить данный набор вещей в нашу сумку
            if (totalWeight <= maxWeight) {
                maxCost = Math.max(totalCost, maxCost);
                //То же самое, что и данный код ниже:
//                if(totalCost > maxCost) {
//                    maxCost = totalCost;
//                }
            }
        }
        return maxCost;
    }
    	public static List<Item> findBestSetOfItems(double maxWeight,List<Item> items){
          List<Item> newItem=new ArrayList<Item>();
            for (Item m:items) {
                if(m.getWeight()<maxWeight){
                    newItem.add(m);
                }

            }
            Collections.sort(newItem, (o1, o2) -> Double.compare(o2.getCost(), o1.getCost()));
            return newItem;
        }

      	public static List<List<Item>> getAllSubsets(List<Item> items){
            List<List<Item>>ListOfList=new ArrayList<List<Item>>();
            int n=items.size()-1;
        for (int i=0;i<n;i++) {
            for (int j = n; j>i; j--) {
                ListOfList.add(items.subList( i, j));

            }
        }
        return ListOfList;
    }
}