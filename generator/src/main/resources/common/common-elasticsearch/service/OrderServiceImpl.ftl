package ${packageName}.service.impl;

import ${packageName}.pojo.Order;
import ${packageName}.repository.OrderRepository;
import ${packageName}.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @project springdataES
 * @author capture or new
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void saveAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateById(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findList(Order order, Integer pageIndex, Integer pageSize) {
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria()
                .and(new Criteria("orderDesc").contains(order.getOrderDesc()))
                .and(new Criteria("orderNo").is(order.getOrderNo())))
                .setPageable(PageRequest.of(pageIndex, pageSize));

        SearchHits<Order> searchHits = elasticsearchRestTemplate.search(criteriaQuery, Order.class);
        List<Order> result = searchHits.get().map(item -> item.getContent()).collect(Collectors.toList());
        System.out.println(result);
        return result;
    }

    @Override
    public Page<Order> findAll(Integer pageIndex, Integer pageSize) {
        Page<Order> page = orderRepository.findAll(PageRequest.of(pageIndex, pageSize));
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());

        return page;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }


}

