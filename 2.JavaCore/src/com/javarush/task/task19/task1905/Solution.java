package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{
       private Customer customer;
       private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        public String getCountryCode() {
            String result = null;
            for (Map.Entry<String, String> entry: countries.entrySet() ) {
                if (entry.getValue().equals(customer.getCountryName() ) ) result = entry.getKey();
            }
        return result;
            }

        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            String[] name = contact.getName().split(", ");
            return name[1];
        }

        public String getContactLastName() {
            String[] name = contact.getName().split(", ");
            return name[0];
        }

        public String getDialString() {
           return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}