package main.com.aashirwad.util;

import main.com.aashirwad.model.PromotionNodeModel;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class will contain all our ongoing promotion related data
 * @author Aashirwad Gupta
 */
public class ItemPromotionsUtil {

    public static Map<String, PromotionNodeModel> getPromotionData(){
        Map<String, PromotionNodeModel> promotionData = new TreeMap<>();
        promotionData.put("A", new PromotionNodeModel("A", 3, 130, null));
        promotionData.put("B", new PromotionNodeModel("B", 2, 45, null));
        promotionData.put("C", new PromotionNodeModel("C", 1, 30, null));
        promotionData.put("D", new PromotionNodeModel("D", 1, 30, null));
        promotionData.get("C").setJointDiscountNode(promotionData.get("D"));
        return promotionData;
    }
}
