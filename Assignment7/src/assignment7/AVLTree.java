package assignment7;
    
public class AVLTree { 
    Node root;

    public double height(Node N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 

    public double max(double a, double b) { 
        return (a > b) ? a : b; 
    } 

    Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 

        x.right = y; 
        y.left = T2; 

        y.height = (int) (Double.max(height(y.left), height(y.right)) + 1); 
        x.height = (int) (Double.max(height(x.left), height(x.right)) + 1); 

        return x; 
    } 

    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        y.left = x; 
        x.right = T2; 

        x.height = (int) (Double.max(height(x.left), height(x.right)) + 1); 
        y.height = (int) (Double.max(height(y.left), height(y.right)) + 1); 

        return y; 
    } 

    public double getBalance(Node N) { 
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    } 
  
    Node insert(Node node, String name, int accountNum, double key) { 

        if (node == null) 
            return (new Node(key)); 
  
        if (key < node.key) 
            node.left = insert(node.left, name, accountNum, key); 
        else if (key > node.key) 
            node.right = insert(node.right, name, accountNum, key); 
        else
            return node; 

        node.height = (int) (1 + Double.max(height(node.left), height(node.right))); 

        double balance = getBalance(node); 

        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 

        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 

        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 

        return node; 
    }

    Node minValueNode(Node node) {  
        Node current = node;  

        while (current.left != null)  
            current = current.left;  
  
        return current;  
    }  
  
    Node deleteNode(Node root, String name, int accountNum, double key) {  
        if (root == null)  
            return root;  

        if (key < root.key)  
            root.left = deleteNode(root.left, name, accountNum, key);  

        else if (key > root.key)  
            root.right = deleteNode(root.right, name, accountNum, key);  

        else {  
  
            if ((root.left == null) || (root.right == null)) {  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
 
                if (temp == null) {  
                    temp = root;  
                    root = null;  
                }  
                else 
                    root = temp;  
            } else {  
                Node temp = minValueNode(root.right);  
                root.key = temp.key;  
                root.right = deleteNode(root.right, name, accountNum, temp.key);  
            }  
        }  
        
        if (root == null)  
            return root;  

        root.height = (int) (Double.max(height(root.left), height(root.right)) + 1);  

        double balance = getBalance(root);  

        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  

        if (balance > 1 && getBalance(root.left) < 0) {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  

        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  

        if (balance < -1 && getBalance(root.right) > 0) {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }
    
    Node find(Node root, String name, int accountNum, double key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void printTree(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            printTree(node.left); 
            printTree(node.right); 
        } 
    }
}