package order;

import user.User;
import user.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    //get all logic
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //get by user logic
    public List<Order> getAllOrdersByUser(User user) {
        if (UserRepository.getDummyDataList().contains(user)) {
            return orderRepository.findByUser(user);
        } else {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    //add order logic
    public boolean addOrder(Order order) {
        if (order.getOrderDateTime().isAfter(LocalDateTime.now())) {
            try {
                throw new Exception("Can't order in the future!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (order.getProducts().size() < 1) {
            try {
                throw new Exception("Order must consist of at least one product!");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return orderRepository.save(order);
    }

    //delete logic
    public boolean deleteOrder(Order order) {
        if (order.getOrderStatus() == OrderStatus.COMPLETED) {
            try {
                throw new Exception("Can't cancel a completed order!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (order.getOrderStatus() == OrderStatus.CANCELLED) {
            try {
                throw new Exception("Order was already cancelled!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderRepository.remove(order);
    }

}
