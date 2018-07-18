package mobile.viali.prontoshop.ui.customerslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mobile.viali.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import mobile.viali.prontoshop.data.DatabaseHelper;
import mobile.viali.prontoshop.model.Customer;
import mobile.viali.prontoshop.model.Product;
import mobile.viali.prontoshop.util.Constants;

import static mobile.viali.prontoshop.BuildConfig.DEBUG;

public class CustomerListSQLiteManager implements CustomerListContract.Repository {
    private static final String TAG = "CUST_LIST_SQ_MANAG";
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Context mContext;

    public CustomerListSQLiteManager(Context mContext) {
        this.mContext = mContext;
        databaseHelper = DatabaseHelper.newInstance(mContext);
        database = databaseHelper.getWritableDatabase();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        // SQL command to select all Customers
        String querry = "SELECT * FROM " + Constants.CUSTOMER_TABLE;

        // make sure the database is not null

        if (database != null) {
            Cursor crs = database.rawQuery(querry, null);

            if (crs.moveToFirst()) {
                while (!crs.isAfterLast()) {
                    // get each customer in the Cursor
                    customers.add(Customer.getCustomerFromCursor(crs));
                    crs.moveToNext();
                }
            }

            crs.close();

        }
        return customers;
    }

    @Override
    public Customer getCustomerById(long id) {
        //Get the cursor representing the Customer
        Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.CUSTOMER_TABLE + " WHERE " +
                Constants.COLUMN_ID + " = '" + id + "'", null);

        //Create a variable of data type Customer
        Customer customer;
        if (cursor.moveToFirst()) {
            customer = Customer.getCustomerFromCursor(cursor);
        } else {
            customer = null;
        }

        cursor.close();

        //Return result: either a valid customer or null
        return customer;
    }

    @Override
    public void onDeleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {
        // Ensure database exists.
        if (database != null) {
            int result = database.delete(Constants.CUSTOMER_TABLE, Constants.COLUMN_ID + " = " + customer.getId(), null);

            if (result > 0) {
                listener.onDatabaseOperationSucceded("Customer Deleted");
            } else {
                listener.onDatabaseOperationFailed("Unable to Delete Customer");
            }

        }

    }

    @Override
    public void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {
        if (database != null){
            //prepare the transaction information that will be saved to the database
            ContentValues values = new ContentValues();
            values.put(Constants.COLUMN_NAME, customer.getCustomerName());
            values.put(Constants.COLUMN_EMAIL, customer.getEmailAddress());
            values.put(Constants.COLUMN_PHONE, customer.getPhoneNumber());
            values.put(Constants.COLUMN_IMAGE_PATH, customer.getProfileImagePath());
            values.put(Constants.COLUMN_STREET1, customer.getStreetAddress());
            values.put(Constants.COLUMN_STREET2, customer.getStreetAddress2());
            values.put(Constants.COLUMN_CITY, customer.getCity());
            values.put(Constants.COLUMN_STATE, customer.getCity());
            values.put(Constants.COLUMN_ZIP, customer.getPostalCode());
            values.put(Constants.COLUMN_NOTE, customer.getNote());
            values.put(Constants.COLUMN_DATE_CREATED, System.currentTimeMillis());
            values.put(Constants.COLUMN_LAST_UPDATED, System.currentTimeMillis());
            try {
                database.insertOrThrow(Constants.CUSTOMER_TABLE, null, values);
                listener.onDatabaseOperationSucceded("Customer Added");
                if (DEBUG){
                    Log.d(TAG, "Customer Added");
                }
            } catch (SQLException e) {
                listener.onDatabaseOperationFailed(e.getCause() + " " + e.getMessage());
            }
        }

    }

    @Override
    public void updateCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {
        if (database != null) {
            //prepare the transaction information that will be saved to the database
            ContentValues values = new ContentValues();
            values.put(Constants.COLUMN_NAME, customer.getCustomerName());
            values.put(Constants.COLUMN_EMAIL, customer.getEmailAddress());
            values.put(Constants.COLUMN_PHONE, customer.getPhoneNumber());
            values.put(Constants.COLUMN_IMAGE_PATH, customer.getProfileImagePath());
            values.put(Constants.COLUMN_STREET1, customer.getStreetAddress());
            values.put(Constants.COLUMN_STREET2, customer.getStreetAddress2());
            values.put(Constants.COLUMN_CITY, customer.getCity());
            values.put(Constants.COLUMN_STATE, customer.getCity());
            values.put(Constants.COLUMN_ZIP, customer.getPostalCode());
            values.put(Constants.COLUMN_NOTE, customer.getNote());
            values.put(Constants.COLUMN_LAST_UPDATED, System.currentTimeMillis());
            //Now update the this row with the information supplied
            int result = database.update(Constants.CUSTOMER_TABLE, values,
                    Constants.COLUMN_ID + " = " + customer.getId(), null);
            if (result == 1) {
                listener.onDatabaseOperationSucceded("Customer Updated");
            } else {
                listener.onDatabaseOperationFailed("Customer Update Failed");
            }
        }

    }
}
