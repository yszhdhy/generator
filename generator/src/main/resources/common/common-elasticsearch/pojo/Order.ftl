package ${packageName}.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @project springdataES
 * @description
 * @author capture or new
 * @date 2023/7/31 17:55:40
 * @version 1.0
 */
@Data
@Document(indexName = "order", shards = 1, replicas = 1)
public class Order implements Serializable {
    @Id
    private Integer id;

    @Field(type = FieldType.Keyword)
    private Long orderNo;

    @Field(type = FieldType.Integer)
    private Integer orderType;

    @Field(type = FieldType.Long)
    private Long orderAmount;

    @Field(type = FieldType.Text)
    private String orderDesc;

    @Field(type = FieldType.Keyword)
    private String username;

    @Field(type = FieldType.Keyword)
    private String userPhone;

    private Map<String, List<String>> highlights;
}
