package com.github;//n newthinktank.com

public class BinaryTree {

    class Node {
        int key;
        String name;

        Node leftChild;
        Node rightChild;

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public String toString() {
            return name + " has the key " + key;
            /*
             * return name + " has the key " + key + "\nLeft Child: " + leftChild +
             * "\nRight Child: " + rightChild + "\n";
             */
        }
    }


    Node root;
    public void addNode(int key, String name) {
        // create a new node and initialize it
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            // set root as the Node we will start with as we traverse the tree
            Node focusNode = root;

            // future oarent for our new Node
            Node parent;

            while (true) {
                // root is the top parent so we start there
                parent = focusNode;

                // check if the new node should go on the left side of the parent node
                if (key < focusNode.key) {
                    // switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // if the leftChild has no children
                    if (focusNode == null) {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // all done
                    }
                } else { // if we get here put the node on the right
                    focusNode = focusNode.rightChild;

                    // if the rightChild has no children
                    if (focusNode == null) {
                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void inOrderTraverseTree (Node focusNode) {
        if (focusNode != null) {
            // traverse the left node
            inOrderTraverseTree(focusNode.leftChild);

            // visit the currently focused on node
            System.out.println(focusNode);

            // traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public  void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree (Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        // start at the top of the tree
        Node focusNode = root;

        // while we haven't found the node, keep looking
        while (focusNode.key != key) {
            // if we should search to the left
            if (key < focusNode.key) {
                // shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }
            // the node wasn't found
            if (focusNode == null) {
                return null;
            }
            return focusNode;
        }

        return focusNode;
    }
}

