package ${packageName}.service;

import ${packageName}.pojo.Order;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @project springdataES
 * @author capture or new
 */
public interface OrderService {
    void saveAll(List<Order> orders);

    Order findById(Integer id);

    void deleteById(Integer id);

    void updateById(Order order);

    List<Order> findList(Order order, Integer pageIndex, Integer pageSize);

    Page<Order> findAll(Integer pageIndex, Integer pageSize);

}
