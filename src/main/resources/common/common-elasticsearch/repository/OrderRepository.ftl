package ${packageName}.repository;

import ${packageName}.pojo.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @project springdataES
 * @author capture or new
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Integer> {
}
