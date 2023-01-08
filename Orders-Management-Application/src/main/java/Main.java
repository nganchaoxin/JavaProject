import configuration.SpringConfig;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static OrderDetailsRepository orderDetailsRepository = context.getBean("orderDetailsRepository", OrderDetailsRepository.class);
    static OrdersRepository ordersRepository = context.getBean("ordersRepository", OrdersRepository.class);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        do {
            System.out.println("1. Create order with order detail");
            System.out.println("2. List all order and order details in the database.");
            System.out.println("3. Get an order and orderDetails by order id.");
            System.out.println("4. List all the orders in the current month.");
            System.out.println("5. List all orders which have total amount more than 1,000USD.");
            System.out.println("6. List all orders buy Java book.");
            System.out.println("7. Out Of Program.");
            System.out.print("Enter your input: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    createOrderWithOrderDetail();
                    break;
                case 2:
                    listAllOrderAndOrderDetail();
                    break;
                case 3:
                    getOrderAndOrderDetailsByOrderId();
                    break;
                case 4:
                    getAllOrderInCurrentMonth();
                    break;
                case 5:
                    getOrderFromTotal();
                    break;
                case 6:
                    getOrderFromJavaBook();
                    break;
                case 7:
                    exit = true;
                    break;
            }
        } while (!exit);

    }

    public static void getOrderFromJavaBook() {
        System.out.println(ordersRepository.getOrderFromJavaBook());
    }

    public static void getOrderFromTotal() {
        System.out.println(ordersRepository.getOrderFromTotal());
    }

    public static void getAllOrderInCurrentMonth() {
        System.out.println("List All Order in current month");
        System.out.println(ordersRepository.getOrderInCurrentMonth());

    }

    public static void getOrderAndOrderDetailsByOrderId() {
        System.out.println("Enter order ID you want to find:");
        System.out.println(orderDetailsRepository.findOrderById(scanner.nextInt()));
    }

    public static void listAllOrderAndOrderDetail() {
        System.out.println("List All Order and Order Detail");
        List<OrdersEntity> listOrder = (List<OrdersEntity>) ordersRepository.findAll();

        for (OrdersEntity order : listOrder) {
            System.out.println(order.toString());
            System.out.println("Order detail have order id: " + order.getId());
            List<OrderDetailsEntity> listOrderDetail = orderDetailsRepository.findOrderById(order.getId());
            for (OrderDetailsEntity orderDetail : listOrderDetail) {
                System.out.println(orderDetail.toString());
            }
        }

    }

    public static void createOrderWithOrderDetail() {
        System.out.println("Create order with order detail");
        OrdersEntity ordersEntity = enterNewOrder();
        ordersRepository.save(ordersEntity);

        OrderDetailsEntity orderDetailsEntity = enterNewOrderDetail();
        orderDetailsEntity.setOrderId(ordersEntity);
        orderDetailsRepository.save(orderDetailsEntity);

    }

    public static OrdersEntity enterNewOrder() {
        OrdersEntity ordersEntity = new OrdersEntity();
        System.out.println("Enter Customer Name:");
        scanner.nextLine();
        ordersEntity.setCustomerName(scanner.nextLine());
        System.out.println("Enter Customer Address:");
        ordersEntity.setCustomerAddress(scanner.nextLine());
        ordersEntity.setOrderDate(LocalDate.now());

        ordersRepository.save(ordersEntity);

        return ordersEntity;
    }

    public static OrderDetailsEntity enterNewOrderDetail() {
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