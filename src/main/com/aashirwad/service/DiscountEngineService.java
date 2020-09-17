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

        Map<String, Integer> cartFinal = new TreeMap<>();

        for(Map.Entry<String, Integer> cartItemEntry: cart.entrySet()){
            int itemQuantity = cartItemEntry.getValue();
            String item = cartItemEntry.getKey();
            PromotionNodeModel currNode = promotionData.get(item);
            /**
             * 1. First we will check that if the joinDiscount node is null, that will mean that this will be a solo
             *    discounted item. If so, then we will check if the quantity is greater or equal to the promotion
             *    quantity, and accordingly multiply it discounted quantity bundle with the discounted price and the
             *    remaining with their original price. For Ex - Item1 @ 50 each is 7 in cart and is available at
             *    3 for 130, then 2 bundle(3 in one bundle) will be evaluated for 130 each and
             *    remaining one will be priced at 50.
             * 2. If the associated node is not null, then we will consider this one as a joint promotion.
             *    In case of joint promotion, if the currentPromotionNode's quantity in the care is more than the
             *    associatedNode's quantity in the cart, then we will subtract the associated item's quantity,
             *    with currentNode quantity, and multiply it with promotionalValue. and the remaining quantity
             *    with the currentNode's original price.
             * 3. If in the above scenario, the associatedNode's item quantity, then the calculation get reversed.
             *    If the quantity, is equal, then any node's promotional value can be multiplied.
             *
             * Keep adding this in total and we will get final amount of the cart
             *
             */
            if(null!=currNode){
                int amount = 0;
                if(null==currNode.getJointDiscountNode()){
                    if(itemQuantity!=1){
                        amount = (itemQuantity/currNode.getPromotionQuantity())*currNode.getPromotionalPrice()
                                + (itemQuantity%currNode.getPromotionQuantity())*itemPriceData.get(item);
                    } else{
                        amount = itemQuantity*itemPriceData.get(item);
                    }
                    cartFinal.put(item, amount);
                }
                else {
                    PromotionNodeModel associatedPromoNode = currNode.getJointDiscountNode();
                    String associatedItem = associatedPromoNode.getSkuItem();
                    if(null!=cart.get(associatedItem)){
                        int associatedItemQuantity = cart.get(associatedItem);
                        if(itemQuantity>associatedItemQuantity){
                            amount = (itemQuantity - associatedItemQuantity)*itemPriceData.get(item);
                            cartFinal.put(item, amount);
                            amount = associatedItemQuantity*currNode.getPromotionalPrice();
                            cartFinal.put(associatedItem, amount);
                        }
                        else if(itemQuantity<associatedItemQuantity){
                            amount = (associatedItemQuantity - itemQuantity)*itemPriceData.get(associatedItem);
                            cartFinal.put(associatedItem, amount);
                            amount = itemQuantity*currNode.getPromotionalPrice();
                            cartFinal.put(item, amount);
                        }
                        else {
                            amount = itemQuantity*currNode.getPromotionalPrice();
                            cartFinal.put(item, amount);
                        }
                    }
                    else{
                        amount = itemQuantity*itemPriceData.get(item);
                        cartFinal.put(item, amount);
                    }
                }
            }
        }
        System.out.println(cartFinal);
        return cartFinal.values().stream().mapToInt(Integer::intValue).sum();
    }
}
