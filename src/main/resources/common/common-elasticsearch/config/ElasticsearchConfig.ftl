package ${packageName}.config;


import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @project springdataES
 * @author capture or new
 */
@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.xc.elasticsearch.repository")
@Data
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    private String host ;
    private Integer port ;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient restHighLevelClient = new
                RestHighLevelClient(builder);
        return restHighLevelClient;
    }
}
