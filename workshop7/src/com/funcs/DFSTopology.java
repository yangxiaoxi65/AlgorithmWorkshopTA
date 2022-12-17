package com.funcs;

import com.entity.GraphAddOn;
import com.entity.GraphNode;

import java.util.*;

public class DFSTopology {

    private List<GraphAddOn> ret;
    private List<GraphAddOn> inputGraph;
    private Stack<GraphAddOn> stk;

    //this part means to init this obj to give a start values to them.
    public DFSTopology(List<GraphAddOn> inputGraph){
        this.inputGraph=inputGraph;
        ret=new ArrayList<>();
        stk=new Stack<>();
    }

    public void search(){
        //store nodes if they don't have in-degree.
        Queue<GraphAddOn> set=new LinkedList<>();
        for(GraphAddOn iterator:inputGraph){
            if(iterator.getIncrement()==0){
                set.offer(iterator);
            }
        }
        stk.push(set.poll());
        while (set.size()!=0){
            if(stk.isEmpty()){
                stk.push(set.poll());
            }
            GraphAddOn curNode=stk.peek();
            //if this node have been processed it can pop.
            //add this judge is to avoid loop.
            if(curNode.getInStack()){
                curNode.setCheck(true);
                ret.add(curNode);
                stk.pop();
                continue;
            }
            if(!curNode.getAdjacentNodes().isEmpty()){
                for(GraphAddOn iterator : curNode.getAdjacentNodes()){
                    if(!iterator.getCheck()){
                        stk.push(iterator);
                    }
                }
                curNode.setInStack(true);
            }else if(curNode.getAdjacentNodes().isEmpty()){
                ret.add(curNode);
                //need to set this node is checked.
                curNode.setCheck(true);
                curNode.setInStack(true);
                stk.pop();
            }
        }
        //because we use another direction to print our ans, so finally we
        //need to print them reversely.
        System.out.print("result of DFSTopology is:\t");
        for (int i=0;i<ret.size();i++){
            System.out.print(ret.get(ret.size()-1-i).getNodeName()+"-->");
        }
        System.out.print("end");
    }
}
