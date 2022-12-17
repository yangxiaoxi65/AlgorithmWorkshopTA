package com.entity;


import java.util.ArrayList;
import java.util.List;


public class GraphAddOn extends GraphNode{

    public GraphAddOn(String nodeName, List<GraphNode> nextNode, Boolean isCheck) {
        super(nodeName, nextNode, isCheck);
    }
    //here to add-on new features that you want to input into new obj.
    public GraphAddOn(String nodeName, Boolean isCheck) {
        super(nodeName, isCheck);
        adjacentNodes=new ArrayList<GraphAddOn>();
        setIncrement(0);
        setInStack(false);
    }
    // features
    private List<GraphAddOn> adjacentNodes;
    private Integer increment;
    private Boolean isInStack;

    /*getter & setter
    * */

    public List<GraphAddOn> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<GraphAddOn> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
    public Integer getIncrement() {
        return increment;
    }
    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Boolean getInStack() {
        return isInStack;
    }

    public void setInStack(Boolean inStack) {
        isInStack = inStack;
    }

    //you can add node one by one.
    //this method means that a node can reach to another node,
    //this requires input is end node.
    public void connectGraph(GraphAddOn node){
        //this param is for kahnAlgo
        getAdjacentNodes().add(node);
        int curIncrement = node.getIncrement();
        curIncrement++;
        node.setIncrement(curIncrement);
    }

}
