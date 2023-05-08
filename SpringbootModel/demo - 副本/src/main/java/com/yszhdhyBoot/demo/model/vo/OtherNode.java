package com.yszhdhyBoot.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class OtherNode {

    /**
     *节点父名称
     */
    private String parentNodeName;

//    子节点
    private List<Node> nodes;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node{
        private String nodeName;

        private String context;
    }

}
