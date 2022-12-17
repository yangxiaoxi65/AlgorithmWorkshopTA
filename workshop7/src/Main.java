import com.entity.GraphAddOn;
import com.entity.GraphNode;
import com.entity.GraphNodeByMatric;
import com.funcs.BFS;
import com.funcs.DFS;
import com.funcs.DFSTopology;
import com.funcs.KahnAlgo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //generate nodes
        GraphAddOn p1 =new GraphAddOn("point_1",false);
        GraphAddOn p2 =new GraphAddOn("point_2",false);
        GraphAddOn p3 =new GraphAddOn("point_3",false);
        GraphAddOn p4 =new GraphAddOn("point_4",false);
        GraphAddOn p5 =new GraphAddOn("point_5",false);
        GraphAddOn p6 =new GraphAddOn("point_6",false);

        p1.connectGraph(p2);
        p1.connectGraph(p4);
        p3.connectGraph(p4);
        p3.connectGraph(p5);
        p4.connectGraph(p5);
        p4.connectGraph(p6);
        p5.connectGraph(p6);
        //we need a set(list) to store nodes' increment
        List<GraphAddOn> set=new ArrayList<>();
        set.add(p1);set.add(p2);set.add(p3);set.add(p4);set.add(p5);set.add(p6);
        //here to lunch the function
        KahnAlgo algo = new KahnAlgo(set);
        algo.search();
        System.out.println();
        //use dfs to solve the problem,first we need to generate nodes
        //and input to a linklist
        List<GraphAddOn> list=new ArrayList<>();
        GraphAddOn q1 =new GraphAddOn("point_1",false);
        GraphAddOn q2 =new GraphAddOn("point_2",false);
        GraphAddOn q3 =new GraphAddOn("point_3",false);
        GraphAddOn q4 =new GraphAddOn("point_4",false);
        GraphAddOn q5 =new GraphAddOn("point_5",false);
        GraphAddOn q6 =new GraphAddOn("point_6",false);
        GraphAddOn q7 =new GraphAddOn("point_7",false);
        GraphAddOn q8 =new GraphAddOn("point_8",false);
        GraphAddOn q9 =new GraphAddOn("point_9",false);
        GraphAddOn q10 =new GraphAddOn("point_10",false);
        list.add(q1);list.add(q2);list.add(q3);list.add(q4);
        list.add(q5);list.add(q6);list.add(q7);list.add(q8);
        list.add(q9);list.add(q10);
        //connect nodes
        q7.connectGraph(q1);
        q7.connectGraph(q3);
        q7.connectGraph(q6);
        q5.connectGraph(q3);
        q5.connectGraph(q6);
        q4.connectGraph(q8);
        q4.connectGraph(q2);
        q6.connectGraph(q8);
        q2.connectGraph(q10);

        DFSTopology dfstop = new DFSTopology(list);
        dfstop.search();
    }
}
