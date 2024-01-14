
package msaqms;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import msaqms.Product.Mobile;
public class Order extends Mobile

{
    private int orderId;
    private String customerName;
   

 public Order(int orderId, String customerName, String id, String brand, String name,
                 String model, double price,int stock, String ram, String rom, String cameraInmp,
                 InputStream imagePath)
 {
        super(id, brand, name, model, price,stock, ram, rom, cameraInmp);
        this.orderId = orderId;
        this.customerName = customerName;
    }
    // Add getter and setter methods for orderId and customerName if needed


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
    // override the method here 
//    public String toString() {
//        return "Order{" +
//                "orderId=" + orderId +
//                ", customerName='" + customerName + '\'' +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", price=" + price +
//                ", ram='" + ram + '\'' +
//                ", rom='" + rom + '\'' +
//                ", cameraInmp='" + cameraInmp + '\'' +
//                '}';
//    }
//}

//class OrderManager {
//    private LinkedList<Order> orderList = new LinkedList<>();
//
//    public void placeOrder(Order order) {
//        orderList.add(order);
//    }
//
//    public Order processNextOrder() {
//        if (!orderList.isEmpty()) {
//            return orderList.removeFirst();
//        }
//        return null;
//    }
//
//    public boolean hasOrders() {
//        return !orderList.isEmpty();
//    }
//
//    public String viewOrders() {
//        StringBuilder ordersText = new StringBuilder("Current Orders:\n");
//        for (Order order : orderList) {
//            ordersText.append(order.toString()).append("\n");
//        }
//        return ordersText.toString();
//    }
//}
//}
////public class OrderProcessingApp {
////    public static void main(String[] args) {
////        OrderManager orderManager = new OrderManager();
////
////        while (true) {
////            String choiceStr = JOptionPane.showInputDialog(
////                    "1. Place Order\n2. Process Next Order\n3. View Orders\n4. Exit\nEnter your choice:");
////
////            int choice;
////            try {
////                choice = Integer.parseInt(choiceStr);
////            } catch (NumberFormatException e) {
////                JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
////                continue;
////            }
////
////            switch (choice) {
////                case 1:
////                    try {                        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));
////                        String customerName = JOptionPane.showInputDialog("Enter Customer Name:");
////                        String brand = JOptionPane.showInputDialog("Enter Brand:");
//                        String model = JOptionPane.showInputDialog("Enter Model:");
//                        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
//                        String ram = JOptionPane.showInputDialog("Enter RAM:");
//                        String rom = JOptionPane.showInputDialog("Enter ROM:");
//                        String cameraInmp = JOptionPane.showInputDialog("Enter Camera (in MP):");
//
//                        Order newOrder = new Order(orderId, customerName, brand, model,
//                                price, ram, rom, cameraInmp);
//                        orderManager.placeOrder(newOrder);
//                        JOptionPane.showMessageDialog(null, "Order placed successfully!");
//                    } catch (NumberFormatException e) {
//                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values for Order ID and Price.");
//                    }
//                    break;
//
//                case 2:
//                    if (orderManager.hasOrders()) {
//                        Order processedOrder = orderManager.processNextOrder();
//                        JOptionPane.showMessageDialog(null, "Order processed:\n" + processedOrder.toString());
//                    } else {
//                        JOptionPane.showMessageDialog(null, "No orders to process.");
//                    }
//                    break;
//
//                case 3:
//                    JOptionPane.showMessageDialog(null, orderManager.viewOrders());
//                    break;
//
//                case 4:
//                    JOptionPane.showMessageDialog(null, "Exiting the application. Thank you!");
//                    System.exit(0);
//
//                default:
//                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
//            }
//        }
//    }
//}
              