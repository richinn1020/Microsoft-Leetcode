/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Pre-order Traversal 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("n");
            sb.append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;
        
        Queue<String> q = new LinkedList<>();
        String[] input = data.split(",");
        for(String s: input) {
            q.offer(s);
        }
        TreeNode root = deserializeHelper(q);
        
        return root;
    }
    
    private TreeNode deserializeHelper(Queue<String> q) {
        String val = q.poll();
        if(val.equals("n")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Level order Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur != null) {
                sb.append(cur.val);
                sb.append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            } else {
                sb.append("n");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        String[] input = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        q.offer(root);
        
        for(int i=1; i<input.length; i++) {
            TreeNode cur = q.poll();
            if(!input[i].equals("n")) {
                cur.left = new TreeNode(Integer.parseInt(input[i]));
                q.offer(cur.left);
            }
            if(!input[++i].equals("n")) {
                cur.right = new TreeNode(Integer.parseInt(input[i]));
                q.offer(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
