package bloomberg;

import treesAndgraphs.TreeNode;

public class ValidateBT {

    public boolean isValidBST(TreeNode root) {
        return isvalid(root, null, null);
    }

    public boolean isvalid(TreeNode root, Integer low, Integer high) {
        if ( root == null) {
            return false;
        }
        if((low != null && root.getVal() <= low) || (high != null && root.getVal() >= high)){
            return false;
        }

        return isvalid(root.getRight(), root.getVal(), high) && isvalid(root.getLeft(), low, root.getVal());
    }
}
