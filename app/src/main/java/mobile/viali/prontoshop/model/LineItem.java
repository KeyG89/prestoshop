package mobile.viali.prontoshop.model;

public class LineItem extends  Product {
    private  int qauntity;


    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    private double getSumPrice(){
        return getSalePrice() * qauntity;
    }
}
