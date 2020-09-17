package main.com.aashirwad.service;

import main.com.aashirwad.model.PromotionNodeModel;
import main.com.aashirwad.util.ItemPriceUtil;
import main.com.aashirwad.util.ItemPromotionsUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Aashirwad Gupta
 */
public class DiscountEngineService {

    /**
     * This method will take the cart of the user/shopper and apply
     * the promotion and pricing on the items. It will finally return
     * the final value of the cart
     * @param cart - Map having key as the item (A/B/C/D....) and
     *             and value as their quantity.
     * @return - The total value of the cart.
     */
    public int calculateCartValue(Map<String, Integer> cart){
        Map<String, Integer> itemPriceData = ItemPriceUtil.itemPricing();
        Map<String, PromotionNodeModel> promotionData =ItemPromotionsUtil.getPromotionData();
        return 0;
    }
}
