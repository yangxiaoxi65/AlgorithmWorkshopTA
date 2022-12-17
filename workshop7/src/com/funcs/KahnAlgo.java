package com.funcs;

import com.entity.GraphAddOn;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgo {

    private Queue<GraphAddOn> queue;
    private List<GraphAddOn> t;
    private List<GraphAddOn>nodesSet;

    public KahnAlgo(List<GraphAddOn> nodesSet){
        queue=new LinkedList<>();
        t=new ArrayList<>();
        this.nodesSet=nodesSet;
    }

    public void search(){
            //if this node's increment equal 0 means this node now we
            // can catch to queue.
            for(GraphAddOn iterator: nodesSet){
                if(iterator.getIncrement()==0 && !iterator.getCheck()){
                    queue.offer(iterator);
                }
            }
            while(t.size()!=nodesSet.size()){
                GraphAddOn curNode = queue.poll();
                for(GraphAddOn iterator:curNode.getAdjacentNodes()){
                    if(iterator.getIncrement()==0 && !iterator.getCheck())queue.offer(iterator);
                    else if(!iterator.getCheck()){
                        int temp=iterator.getIncrement();
                        temp--;
                        iterator.setIncrement(temp);
                        if (iterator.getIncrement()==0){
                            queue.offer(iterator);
                        }
                    }
                }
                curNode.setCheck(true);
                t.add(curNode);
            }
            System.out.print("KahnAlgo result is :\t");
            for(GraphAddOn iterator: t){
                System.out.print(iterator.getNodeName()+"-->");
            }
        System.out.print("end");
        }
}
