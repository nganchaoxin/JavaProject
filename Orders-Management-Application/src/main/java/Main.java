import configuration.SpringConfig;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static OrderDetailsRepository orderDetailsRepository = context.getBean("orderDetailsRepository", OrderDetailsRepository.class);
    static OrdersRepository ordersRepository = context.getBean("ordersRepository", OrdersRepository.class);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        do {
            System.out.println("1. Create new order and order detail.");
            //System.out.println("2. Create new orderDetail.");
            System.out.println("3. List all order and order details in the database.");
            System.out.println("4. Get an order and orderDetails by order id.");
            System.out.println("5. List all the orders in the current month.");
            System.out.println("6. List all orders which have total amount more than 1,000USD.");
            System.out.println("7. List all orders buy Java book.");
            System.out.println("8. Out Of Program.");
            System.out.print("Enter your input: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    orderByUser();
                    break;
                case 2:
                    listAllOrderAndOrderDetail();
                    break;
                case 8:
                    exit = true;
                    break;
            }
        } while (!exit);

    }
    public static void listAllOrderAndOrderDetail() {
        System.out.println("List All Order and Order Detail");
        List<OrdersEntity> listOrder = (List<OrdersEntity>) ordersRepository.findAll();

        for (OrdersEntity order: listOrder) {
            System.out.println(order.toString());

        }

        System.out.println(listOrder.toString());

    }
    public static void orderByUser() {
        System.out.println("Enter new order!");

        // Create new orders
        OrdersEntity ordersEntity = new OrdersEntity();
        System.out.println("Enter Name:");
        scanner.nextLine();
        ordersEntity.setCustomerName(scanner.nextLine());
        System.out.println("Enter Date:");
        ordersEntity.setOrderDate(scanner.nextLine());
        System.out.println("Enter Address:");
        ordersEntity.setCustomerAddress(scanner.nextLine());
        ordersRepository.save(ordersEntity);

        // OrderDetail
        OrderDetailsEntity orderDetailsEntity = createOrderDetail();
        orderDetailsEntity.setOrderId(ordersEntity);

        //System.out.println(ordersEntity.toString());
    }

    public static OrderDetailsEntity createOrderDetail() {
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

        System.out.println("Enter Product Name:");
        orderDetailsEntity.setProductName(scanner.nextLine());
        System.out.println("Enter Quantity Name:");
        orderDetailsEntity.setQuantity(scanner.nextInt());
        System.out.println("Enter Price:");
        orderDetailsEntity.setUnitPrice(scanner.nextDouble());

        orderDetailsRepository.save(orderDetailsEntity);
        return orderDetailsEntity;
    }
}