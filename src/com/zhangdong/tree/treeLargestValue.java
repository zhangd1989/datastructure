package com.zhangdong.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class treeLargestValue {

    public List<Integer> LargestValue(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if(root != null)
            ((LinkedList<Node>) queue).add(root);

        while(!queue.isEmpty()){
            int max =Integer.MIN_VALUE;
            int levelSize = queue.size();
            for(int i =0; i< levelSize; i++){
                Node node = queue.poll();
                max = Math.max(max, node.getValue());
                if(node.getLeft()!=null)
                    ((LinkedList<Node>) queue).add(node.getLeft());

                if(node.getRight()!=null)
                    ((LinkedList<Node>) queue).add(node.getRight());
            }

            values.add(max);
        }

        return values;
    }
}
