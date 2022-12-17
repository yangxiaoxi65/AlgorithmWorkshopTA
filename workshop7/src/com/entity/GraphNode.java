package com.entity;

import java.util.List;
/*
* use linked-list to store graph datas.
* */
public class GraphNode {

    //plan a graph that what materials should have.
    private String nodeName;
    /*
    this means to store how many nodes does the current node
    have.
    */
    private List<GraphNode> nextNodes;
    private Boolean isCheck;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<GraphNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(List<GraphNode> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }
    //this construction means we know a node that connect with other nodes.
    GraphNode(String nodeName, List<GraphNode> nextNode, Boolean isCheck){
        this.nodeName = nodeName;
        this.nextNodes = nextNode;
        this.isCheck = isCheck;
    }
    //this means we create a normal nodes that we don't know how many nodes we can connect.
    public GraphNode(String nodeName, Boolean isCheck){
        this.nodeName=nodeName;
        this.isCheck=isCheck;
    }

    public void printNode(){
        System.out.print(nodeName+" can get to-->\t");
        List<GraphNode> nodes = nextNodes;
        for(GraphNode iterator: nodes){
            System.out.print(iterator.nodeName+"-->");
        }
    }

}
