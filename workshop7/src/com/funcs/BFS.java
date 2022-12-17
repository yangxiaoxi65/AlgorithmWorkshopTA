package com.funcs;

import com.entity.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private GraphNode graph;
    private Queue<GraphNode> queue;
    private List<GraphNode> ret;

    public BFS(GraphNode graph){
        this.graph = graph;
        queue = new LinkedList<>();
        //this queue need to offer root graph node.
        queue.offer(graph);
        graph.setCheck(true);
        ret=new ArrayList<>();
    }

    public void bfs(){
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            ret.add(currentNode);
            currentNode.setCheck(true);
            if(!currentNode.getNextNodes().isEmpty()){
                for(GraphNode iterator: currentNode.getNextNodes()){
                    if(!iterator.getCheck()){
                        queue.offer(iterator);
                        iterator.setCheck(true);
                    }
                }
            }
        }
        System.out.println("result of com.funcs.BFS");
        for(GraphNode iterator: ret){
            System.out.print(iterator.getNodeName()+"-->");
        }
    }
}
