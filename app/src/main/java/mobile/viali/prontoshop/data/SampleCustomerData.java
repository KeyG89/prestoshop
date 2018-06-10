package mobile.viali.prontoshop.data;

import java.util.ArrayList;
import java.util.List;

import mobile.viali.prontoshop.model.Customer;

public class SampleCustomerData {

    public static List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setCustomerName("Debbie Sam");
        customer1.setEmailAddress("deb@email.net");
        customer1.setProfileImagePath("https://image.ibb.co/eCrrco/person1.png");
        customers.add(customer1);


        Customer customer2 = new Customer();
        customer2.setCustomerName("Keisha Williams");
        customer2.setEmailAddress("diva@comcast.com");
        customer2.setProfileImagePath("https://image.ibb.co/bWeYq8/person2.png");
        customers.add(customer2);


        Customer customer3 = new Customer();
        customer3.setCustomerName("Gregg McQuire");
        customer3.setEmailAddress("emailing@nobody.com");
        customer3.setProfileImagePath("https://image.ibb.co/jVpYq8/person3.png");
        customers.add(customer3);


        Customer customer4 = new Customer();
        customer4.setCustomerName("Jamal Puma");
        customer4.setEmailAddress("jamal@hotmail.com");
        customer4.setProfileImagePath("https://image.ibb.co/eF1eV8/person4.png");
        customers.add(customer4);


        Customer customer5 = new Customer();
        customer5.setCustomerName("Dora Keesler");
        customer5.setEmailAddress("dora@yahoo.com");
        customer5.setProfileImagePath("https://image.ibb.co/jmreV8/person5.png");
        customers.add(customer5);

        Customer customer6 = new Customer();
        customer6.setCustomerName("Anthony Lopez");
        customer6.setEmailAddress("toney@gmail.com");
        customer6.setProfileImagePath("https://image.ibb.co/fZitq8/person6.png");
        customers.add(customer6);

        Customer customer7 = new Customer();
        customer7.setCustomerName("Ricardo Weisel");
        customer7.setEmailAddress("ricardo@gmail.com");
        customer7.setProfileImagePath("https://image.ibb.co/jTHxHo/person7.png");
        customers.add(customer7);

        Customer customer8 = new Customer();
        customer8.setCustomerName("Angele Lu");
        customer8.setEmailAddress("angele@ymail.com");
        customer8.setProfileImagePath("https://image.ibb.co/gt5v3T/person8.png");
        customers.add(customer8);


        Customer customer9 = new Customer();
        customer9.setCustomerName("Brendon Suh");
        customer9.setEmailAddress("brendon@outlook.com");
        customer9.setProfileImagePath("https://image.ibb.co/hB1rco/person9.png");
        customers.add(customer9);


        Customer customer10 = new Customer();
        customer10.setCustomerName("Pietro Augustino");
        customer10.setEmailAddress("pietro@company.com");
        customer10.setProfileImagePath("https://image.ibb.co/dhiRA8/person10.png");
        customers.add(customer10);


        Customer customer11 = new Customer();
        customer11.setCustomerName("Matt Zebrotta");
        customer11.setEmailAddress("matt@stopasking.com");
        customer11.setProfileImagePath("https://image.ibb.co/coUzV8/person11.png");
        customers.add(customer11);

        Customer customer12 = new Customer();
        customer11.setCustomerName("James McGiney");
        customer11.setEmailAddress("james@outlook.com");
        customer11.setProfileImagePath("https://image.ibb.co/j1MDq8/person12.png");
        customers.add(customer11);
        return customers;
    }
}