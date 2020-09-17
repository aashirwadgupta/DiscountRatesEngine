package main.com.aashirwad.model;

/**
 * @author Aashirwad Gupta
 *
 * This class will act as a promotional details object for the engine.
 * It will have the following fields
 * <ul>
 *     <li><b>skuItem</b> - This is basically the item name - For simplicity I will be using A, B, C, D. This can be replaced
 *     with itemId as well, basically anything which can naturally sorted.</li>
 *     <li><b>promotionQuantity</b> - Number of items that must be present in the cart to avail the promotion offer.</li>
 *     <li><b>promotionalPrice</b> - The promotion price which is the price after applying the quantity or combo discount</li>
 *     <li><b>jointDiscountNode</b> - This is a one way relation with anyother item with which the current item is to
 *      be given in discount with. Basically the second one in the combo. Now, If Item1 and Item 2 are in combo and
 *      Item1 has higher prcedence in the natural ordering (based on ID or in our case ASCII value of alphabets),
 *      Then in this case Item1 will have the jointDiscountNode pointing to the Item2 and Item2 will have this value
 *      as null, just to avoid circular reference. Will look into this later as to how it can be improved.</li>
 * </ul>
 */

public class PromotionNodeModel {
    private String skuItem;
    private int promotionQuantity;
    private int promotionalPrice;
    private PromotionNodeModel jointDiscountNode;

    public PromotionNodeModel(String skuItem, int promotionQuantity, int promotionalPrice, PromotionNodeModel jointDiscountNode) {
        this.skuItem = skuItem;
        this.promotionQuantity = promotionQuantity;
        this.promotionalPrice = promotionalPrice;
        this.jointDiscountNode = jointDiscountNode;
    }

    public String getSkuItem() {
        return skuItem;
    }

    public void setSkuItem(String skuItem) {
        this.skuItem = skuItem;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public void setPromotionQuantity(int promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    public int getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(int promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public PromotionNodeModel getJointDiscountNode() {
        return jointDiscountNode;
    }

    public void setJointDiscountNode(PromotionNodeModel jointDiscountNode) {
        this.jointDiscountNode = jointDiscountNode;
    }
}
