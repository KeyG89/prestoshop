package mobile.viali.prontoshop.model;

import java.util.List;

public class Transaction {
    private long id;
    private long customerId;
    private double subTotalAmout;
    private double taxAmount;
    private double totalAmout;
    private boolean paid;
    private String paymentType;
    private long transactionDate;
    private long modifiedDate;

    // this property cannot be persisted
    private List<LineItem> lineItems;

    // theis list of line items will be persisted into this json
    // string before it can be saved to the database
    private String jsonLineItems;



    public Transaction(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getSubTotalAmout() {
        return subTotalAmout;
    }

    public void setSubTotalAmout(double subTotalAmout) {
        this.subTotalAmout = subTotalAmout;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(double totalAmout) {
        this.totalAmout = totalAmout;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(long transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getJsonLineItems() {
        return jsonLineItems;
    }

    public void setJsonLineItems(String jsonLineItems) {
        this.jsonLineItems = jsonLineItems;
    }
}
