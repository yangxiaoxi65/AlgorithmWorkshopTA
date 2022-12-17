package com.entity;

import java.util.HashMap;

public class GraphNodeByMatric {
   // use matrics to store datas.

    private int[][] graph;
    //the map save the relation between nodeName and numbers
    private HashMap<Integer,String> mapNum2Str;
    private HashMap<String,Integer> mapStr2Num;
    private int vecNum;

    public GraphNodeByMatric(int vecNum){
        this.vecNum=vecNum;
        graph=new int[vecNum][vecNum];
        mapNum2Str=new HashMap<>();
        mapStr2Num=new HashMap<>();
    }

    public void createNode(int startNum, String nodeName){
        if(startNum>=vecNum){
            System.out.println("illegal input because the number" +
                    "lager than max num");
            return;
        }else{
            mapNum2Str.put(startNum,nodeName);
            mapStr2Num.put(nodeName,startNum);
        }
    }

    public void connectNode(String startNode, String endNode){
        graph[mapStr2Num.get(startNode)][mapStr2Num.get(endNode)]=1;
    }

    public void printGraph(){
        for (int i=0;i<graph.length;i++){
            System.out.println();
            for(int j=0;j< graph.length;j++){
                System.out.print(graph[i][j]+"\t");
            }
        }
    }
}
