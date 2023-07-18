public class BinTree {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        }
        if (addNode(root, value) != null)
            return true;
        return false;

    }
        public Node  turnLeft(Node node) {
        Node child = node.right;
        Node childLeft = child.left;
        child.left = node;
        node.right = childLeft;
        return child;
    }
        public Node turnRight(Node node) {
        Node child = node.left;
        Node childRight = child.right;
        child.right = node;
        node.left = childRight;
        return child;
    }

    void swapColors(Node node1, Node node2) {
        Color temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }



    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else
                return addNode(node.left, value);
        } else  {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else
                return addNode(node.right, value);
        }
    }
    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }



    private class Node {
        int value;
        Node left;
        Node right;
        Color color;
        Node() {
            this.color = Color.red;
        }

        Node(int _value) {
            this.value = _value;
            this.color = Color.red;
        }
    }
    enum Color {red, black}
}