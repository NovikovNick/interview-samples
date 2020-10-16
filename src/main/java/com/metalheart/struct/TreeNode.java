package com.metalheart.struct;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public List<TreeNode> getChildren() {
        return children == null ? children = new ArrayList<>() : children;
    }

    public void add(TreeNode child) {
        getChildren().add(child);
        child.parent = this;
    }
}
