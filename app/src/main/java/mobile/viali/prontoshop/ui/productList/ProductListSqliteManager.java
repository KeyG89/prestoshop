package mobile.viali.prontoshop.ui.productList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.data.DatabaseHelper;
import mobile.viali.prontoshop.model.Category;
import mobile.viali.prontoshop.model.Product;
import mobile.viali.prontoshop.util.Constants;

public class ProductListSqliteManager implements ProductListContract.Repository {
    private DatabaseHelper dbHelper;
    private final Context mContext;
    private SQLiteDatabase database;

    public ProductListSqliteManager(Context mContext) {
        this.mContext = mContext;
        dbHelper = DatabaseHelper.newInstance(mContext);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public List<Product> getAllProducts() {
        // initialize an empty list of product
        List<Product> product = new ArrayList<>();

        // SQL command to select all Products
        String querry = "SELECT * FROM " + Constants.PRODUCT_TABLE;

        // make sure the database is not null

        if (database != null) {
            Cursor crs = database.rawQuery(querry, null);

            if (crs.moveToFirst()) {
                while (!crs.isAfterLast()) {
                    // get each product in the Cursor
                    getAllProducts().add(Product.getProductFromCursor(crs));
                    crs.moveToNext();
                }
            }

            crs.close();

        }
        return null;
    }

    @Override
    public Product getProductById(long id) {
        // Get cursor representating the Product
        Cursor crs = database.rawQuery("SELECT * FROM " + Constants.PRODUCT_TABLE +
                " WHERE " + Constants.COLUMN_ID + " = '" + id + "'", null);

        Product product;

        if (crs.moveToFirst()) {
            product = Product.getProductFromCursor(crs);
        } else {
            product = null;
        }

        return product;
    }

    @Override
    public void deleteProduct(Product product, OnDatabaseOperationCompleteListener listener) {
        if (database != null) {
            int result = database.delete(Constants.PRODUCT_TABLE, Constants.COLUMN_ID + " = " + product.getId(), null);

            if (result > 0) {
                listener.onDatabaseOperationSucceded("Product Deleted");
            } else {
                listener.onDatabaseOperationFailed("Unable to delete Product");
            }

        }


    }

    @Override
    public void addProduct(Product product, OnDatabaseOperationCompleteListener listener) {
        //prepare the information that will be saved to the database
        ContentValues cv = new ContentValues();
        cv.put(Constants.COLUMN_NAME, product.getProductName());
        cv.put(Constants.COLUMN_DESCRIPTION, product.getDescription());
        cv.put(Constants.COLUMN_PRICE, product.getSalePrice());
        cv.put(Constants.COLUMN_PURCHASE_PRICE, product.getPurchasePrice());
        cv.put(Constants.COLUMN_IMAGE_PATH, product.getImagePath());
        cv.put(Constants.COLUMN_CATEGORY_NAME, product.getCategoryName());
        cv.put(Constants.COLUMN_DATE_CREATED, System.currentTimeMillis());
        cv.put(Constants.COLUMN_LAST_UPDATED, System.currentTimeMillis());

        try {
            database.insertOrThrow(Constants.RETAILER_TABLE, null, cv);
            listener.onDatabaseOperationSucceded("Product Added");
        } catch (SQLException e) {
            listener.onDatabaseOperationFailed(e.getMessage());
        }

    }

    @Override
    public void updateProduct(Product product, OnDatabaseOperationCompleteListener listener) {

        ContentValues cv = new ContentValues();
        cv.put(Constants.COLUMN_NAME, product.getProductName());
        cv.put(Constants.COLUMN_DESCRIPTION, product.getDescription());
        cv.put(Constants.COLUMN_PRICE, product.getSalePrice());
        cv.put(Constants.COLUMN_PURCHASE_PRICE, product.getPurchasePrice());
        cv.put(Constants.COLUMN_IMAGE_PATH, product.getImagePath());
        cv.put(Constants.COLUMN_CATEGORY_NAME, product.getCategoryName());
        cv.put(Constants.COLUMN_DATE_CREATED, System.currentTimeMillis());
        cv.put(Constants.COLUMN_LAST_UPDATED, System.currentTimeMillis());


        int result = database.update(Constants.PRODUCT_TABLE, cv, Constants.COLUMN_ID + " = " + product.getId(), null);

        if (result == 1) {
            listener.onDatabaseOperationSucceded("Product updated");
        } else {
            listener.onDatabaseOperationFailed("Product update failed");
        }

    }


        @Override
        public List<Category> getAllCategories () {
            return null;
        }
    }
