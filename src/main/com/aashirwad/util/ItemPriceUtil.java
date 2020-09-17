package main.com.aashirwad.util;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class will act as a database of item pricing for us.
 * @author Aashirwad Gupta
 */
public class ItemPriceUtil {

    /**
     * This method returns the items we have and their price
     * @return Map of Item name (can be id) as key and their price as value
     */
    public static Map<String, Integer> itemPricing(){
        Map<String, Integer> itemPriceMap = new TreeMap<>();
        itemPriceMap.put("A", 50);
        itemPriceMap.put("B", 45);
        itemPriceMap.put("C", 30);
        itemPriceMap.put("D", 15);
        return itemPriceMap;
    }
}
