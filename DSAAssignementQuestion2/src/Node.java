class Node
{
    int val;
    Node left,right;
    Node(int val)
    {
        this.val=val;
        left=right=null;
    }
}
class Main
{
    Node node;
    Node prev = null;
    Node newHead = null;
    void modifyBST(Node root)
    {
        if(root == null)
        {
            return;
        }
        modifyBST(root.left);
        Node rightNode = root.right;
        Node leftNode = root.left;
        if(newHead == null)
        {
            newHead = root;
            root.left = null;   
            prev = root;
        }
        else
        {

            prev.right = root;
            root.left = null;
            prev = root;
        }
        modifyBST(rightNode);
    }
    void traverse(Node root)
    {
        if(root == null)return;
        System.out.print(root.val + " ");
        traverse(root.right);
    }
    public static void main(String[] args) {

        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        tree.modifyBST(tree.node);
        tree.traverse(tree.newHead);
    }
}