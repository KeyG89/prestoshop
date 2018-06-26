package mobile.viali.prontoshop.model;

import android.database.Cursor;

import mobile.viali.prontoshop.util.Constants;

public class Product {
    private long id;
    private String productName;
    private String description;
    private String promoMessage;
    private double salePrice;
    private double purchasePrice;
    private String imagePath;
    private long categoryId;
    private String categoryName;
    private long dateAdded;
    private long dateOfLastTtransaction;

    public Product(){

    }

    public Product(Product product){
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.promoMessage = product.getPromoMessage();
        this.salePrice = product.getSalePrice();
        this.purchasePrice = product.getPurchasePrice();
        this.imagePath = product.getImagePath();
        this.categoryId = product.getCategoryId();
        this.categoryName = product.getCategoryName();
        this.dateAdded = product.getDateAdded();
        this.dateOfLastTtransaction = product.getDateOfLastTtransaction();

    }

    public static Product getProductFromCursor(Cursor crs) {
        long id = crs.getLong(crs.getColumnIndex(Constants.COLUMN_ID));
        String name = crs.getString(crs.getColumnIndex(Constants.COLUMN_NAME));
        String description = crs.getString(crs.getColumnIndex(Constants.COLUMN_DESCRIPTION));
        String promoMessage = crs.getString(crs.getColumnIndex(Constants.COLUMN_PROMO_MESSAGE));
        Double salePrice = crs.getDouble(crs.getColumnIndex(Constants.COLUMN_PRICE));
        Double purchasePrice = crs.getDouble(crs.getColumnIndex(Constants.COLUMN_PURCHASE_PRICE));
        String imagePath = crs.getString(crs.getColumnIndex(Constants.COLUMN_IMAGE_PATH));
        long catId = crs.getLong(crs.getColumnIndex(Constants.COLUMN_CATEGORY_ID));
        String catName = crs.getString(crs.getColumnIndex(Constants.COLUMN_CATEGORY_NAME));
        long dateCreated = crs.getLong(crs.getColumnIndex(Constants.COLUMN_DATE_CREATED));
        long dateLastUpdated = crs.getLong(crs.getColumnIndex(Constants.COLUMN_LAST_UPDATED));

        Product product = new Product();
        product.setId(id);
        product.setProductName(name);
        product.setDescription(description);
        product.setPromoMessage(promoMessage);
        product.setSalePrice(salePrice);
        product.setPurchasePrice(purchasePrice);
        product.setImagePath(imagePath);
        product.setCategoryId(catId);
        product.setCategoryName(catName);
        product.setDateAdded(dateCreated);
        product.setDateOfLastTtransaction(dateLastUpdated);

        return product;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getDateOfLastTtransaction() {
        return dateOfLastTtransaction;
    }

    public void setDateOfLastTtransaction(long dateOfLastTtransaction) {
        this.dateOfLastTtransaction = dateOfLastTtransaction;
    }


}
