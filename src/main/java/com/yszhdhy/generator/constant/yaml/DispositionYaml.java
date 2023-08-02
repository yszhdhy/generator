package com.yszhdhy.generator.constant.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @project generator
 * @description yaml的配置
 * @author capture or new
 * @date 2023/7/23 14:07:29
 * @version 1.0
 */

public enum DispositionYaml {
    MINIO_DISPOSITION(new HashMap<String,Object>(){{
        put("accessKey","minioadmin");
        put("secretKey","minioadmin");
        put("bucket","leadnews");
        put("endpoint","http://10.14.0.77:9000");
        put("readPath","http://10.14.0.77:9000");
    }},null,"minio"),

    REDIS_DISPOSITION(new HashMap<String,Object>(){{
        put("host","localhost");
        put("port",6379);
    }},"spring","redis"),

    ELASTICSEARCH_DISPOSITION(new HashMap<String,Object>(){{
        put("host","localhost");
        put("port",9200);
    }},null,"elasticsearch"),
    ;

    private HashMap<String,Object> map;
    private String level;
    private String dispositionName;

    public HashMap<String, Object> getMap() {
        return map;
    }

    public String getDispositionName() {
        return dispositionName;
    }

    public String getLevel() {
        return level;
    }

    DispositionYaml(HashMap<String, Object> map, String level, String dispositionName) {
        this.map = map;
        this.level = level;
        this.dispositionName = dispositionName;
    }
}
