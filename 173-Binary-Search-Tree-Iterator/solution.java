/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    /** Return all the numbers smaller than root one by one. Using inorder traversal*/
    
    Stack<TreeNode> stack = new Stack<TreeNode>(); 
    
    public BSTIterator(TreeNode root) {
        // push all the left node to the stack:
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curSmall = stack.pop();
        TreeNode node = curSmall.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return curSmall.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */