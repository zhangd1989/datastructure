package com.zhangdong.tree;

public class maxPathSum {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(Node node){
        maxPathSumHelper(node);
        return maxValue;
    }

    public int maxPathSumHelper(Node node){
        if(node == null)
            return 0;

        int left = maxPathSumHelper(node.getLeft());

        int right = maxPathSumHelper(node.getRight());

        int cur = node.getValue() + + Math.max(0, left) + Math.max(0, right);
        //第1,2,3三种情况,返回当前值加上左右子节点的最大值即可，如果左右子节点都
        //小于0，还不如不选
        int res = node.getValue() + Math.max(0, Math.max(left, right));
        //记录最大value值
        maxValue = Math.max(maxValue, Math.max(cur, res));
        //第1,2,3种情况还可以再计算，所以返回的是res
        return res;
    }

}
