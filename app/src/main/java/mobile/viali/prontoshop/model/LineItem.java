package mobile.viali.prontoshop.model;

public class LineItem extends  Product {
    private  int quantity;

    public LineItem(Product product, int quantity) {
        super(product);
        this.quantity = quantity;
    }


    public int getQauntity() {
        return quantity;
    }

    public void setQauntity(int qauntity) {
        this.quantity = qauntity;
    }

    private double getSumPrice(){
        return getSalePrice() * quantity;
    }
}
