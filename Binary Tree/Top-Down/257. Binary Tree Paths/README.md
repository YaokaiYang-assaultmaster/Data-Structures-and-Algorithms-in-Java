## DFS + Backtracking
* Time:O(n)
* Space:O(logn), Worst case:O(n)

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if( root == null ) return res;
        helper(root,res,new StringBuilder());
        return res;
        
    }
    private void helper(TreeNode node, List<String> res, StringBuilder sb){
        int len = sb.length();
        sb.append(node.val);
        if( node.left == null && node.right == null ){
            res.add(sb.toString());
        } else { 
            sb.append("->");
            if (node.left != null ){
                helper(node.left,res,sb);
            }
            if(node.right != null ){
                helper(node.right,res,sb);
            }
        }
        sb.setLength(len);
    }
}
```

## BFS

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<StringBuilder> path = new LinkedList<>();
        queue.add(root);
        path.add(new StringBuilder());
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            StringBuilder sb = path.poll();
            if( node.left == null && node.right == null ){
                res.add(sb.append(node.val).toString());
            }
            if( node.left != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.left);
                path.add(temp.append(node.val).append("->"));
            }
            if( node.right != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.right);
                path.add(temp.append(node.val).append("->"));
            }
        }
        return res;
    }

```