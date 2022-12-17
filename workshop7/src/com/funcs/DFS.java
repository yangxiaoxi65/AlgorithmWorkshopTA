package com.funcs;

import com.entity.GraphNode;

import java.util.List;
import java.util.Stack;

/**
 * in this part of solution,we choose linkList way to store nodes and use this class
 * to solve.
 */
public class DFS {

    private Stack<GraphNode> stack;
    private GraphNode graph;
    private List<GraphNode> ret;

    public DFS(GraphNode graph) {
        this.graph=graph;
        stack=new Stack<GraphNode>();
        stack.push(graph);
        graph.setCheck(true);
        ret=new Stack<>();
    }

    public void dfsFunc(){
        while(!stack.isEmpty()){
            GraphNode curNode=stack.pop();
            curNode.setCheck(true);
            ret.add(curNode);
            if (curNode.getNextNodes().size()!=0){
                for (GraphNode node: curNode.getNextNodes()){
                    if(!node.getCheck())stack.push(node);
                    node.setCheck(true);
                }
            }
        }
        System.out.println("dfs function solution\n");
        for (GraphNode iterator: ret){
            System.out.print(iterator.getNodeName()+"-->");
        }
    }
}
