import java.util.*;

class NormalBSTtoBalancedBST{
    static class Node {
        int data;        // The value of the node
        Node left;       // Reference to the left child
        Node right;      // Reference to the right child
    
        // Constructor to initialize the node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void getinorder(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getinorder(root.left,inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }
    public static Node createBST(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder,st,mid-1);
        root.right = createBST(inorder,mid+1,end);
        return root;
        
    }
    public static Node buildBalancedTree(Node root) 
    {
        //Add your code here.
        ArrayList<Integer> inorder = new ArrayList<>();
        getinorder(root,inorder);
        root = createBST(inorder,0,inorder.size()-1);
        return root;
    }
}