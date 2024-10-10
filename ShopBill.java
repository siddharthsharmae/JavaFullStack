//Made by Siddharth

package com.Siddharth.Upload.JavaFullStack;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ShopBill {

    static void Bill(String name,String item_name, double price , int quantity,double tax,Locale lang){
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,lang);
        Date date = new Date();
        NumberFormat nf = NumberFormat.getCurrencyInstance(lang);
        double tax_amount = (tax/100) * price * quantity;
        System.out.println("-----------------------");
        System.out.println("Hello, " + name);
        System.out.println("You purchased " + quantity + " " +  item_name + " on " + df.format(date) );
        System.out.println("Price after tax is : " + nf.format(price * quantity));
        System.out.println("Tax amount is : " + nf.format(tax_amount));
        System.out.println("Price before tax is : " + nf.format((price * quantity - tax_amount)));
    }

    public static void main(String[] args) {
//         Locale lang = new  Locale("hi","IN");
        Locale lang = Locale.of("en","IN");
//        NumberFormat nf = NumberFormat.getCompactNumberInstance(lang, NumberFormat.Style.LONG);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scan.nextLine();
        System.out.print("Enter the product name : ");
        String item = scan.nextLine();
        System.out.print("Enter the quantity of item : ");
        int quantity = scan.nextInt();
        System.out.print("Enter the total amount per item : ");
        double price = scan.nextDouble();
        System.out.print("Enter the tax amount : ");
        double tax = scan.nextDouble();
        Bill(name,item,price,quantity,tax,lang);
    }

}
