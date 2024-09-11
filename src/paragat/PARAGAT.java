/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paragat;

import java.util.Scanner;


public class PARAGAT {

   
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();

        System.out.print("Enter number of orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 1; i <= numOrders; i++) {
            System.out.println("Enter details of order " + i + ":");
            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Order Date: ");
            String orderDate = scanner.nextLine();
            System.out.print("Order Amount: ");
            double orderAmount = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Order Status: ");
            String orderStatus = scanner.nextLine();

       
            if (orderAmount <= 0) {
                System.out.println("Error: Order amount must be positive.");
                continue;  
            }
            if (!isValidOrderStatus(orderStatus)) {
                System.out.println("Error: Invalid order status. Valid statuses are: Pending, Shipped, Delivered, Canceled.");
                continue; 
            }

            
            Order order = new Order(orderId, customerName, orderDate, orderAmount, orderStatus);
            orderManager.addOrder(order);
        }

        orderManager.viewOrders();
    }

    private static boolean isValidOrderStatus(String orderStatus) {
        return orderStatus.equalsIgnoreCase("Pending") ||
               orderStatus.equalsIgnoreCase("Shipped") ||
               orderStatus.equalsIgnoreCase("Delivered") ||
               orderStatus.equalsIgnoreCase("Canceled");
    }

    
    
}
