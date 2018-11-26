/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Arminas
 * @param <E>
 */
public class RBTree <E extends Comparable<E>> implements RBTreeI<E>{
    
    Node<E> root;
    int size = 0;
    protected Comparator<? super E> c = null;
    
    public RBTree() {
        this.c = (e1, e2) -> e1.compareTo(e2);
    }
    
    public RBTree(Comparator<? super E> c){
        this.c = c;
    }

    protected class Node<E>{
        
        //element in the node
        protected E element;
        
        //left child
        protected Node<E> left;
        //right child
        protected Node<E> right;
        //parent of this node
        protected Node<E> parent;
        //need to keep track if it's left or right child
        boolean isLeftChild;
        //if isBlack = true, this node part is black, false means it's red
        boolean black;
        
        public Node(E element){
            this.element = element;
            left = right = parent = null;
            black = false;
            isLeftChild = false;
        }
    }
    
    @Override
    public void add(E element){
        Node<E> node = new Node<>(element);
        
        if(root == null){
            root = node;
            root.black = true;
            size++;
            return;
        }
        add(root, node);
        size++;
    }
    
    public int getSize(){
        return size;
    }
    
    private void add(Node<E> parent, Node<E> newNode){
        
        int cmp = c.compare(newNode.element, parent.element);
        
        if(cmp >= 0){
            if(parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
                checkColor(newNode);
            } else{
                add(parent.right, newNode);
            }
        }//the value of the newNode is lower so we look to place it in the left subtree
        else{
            if(parent.left == null){
                parent.left = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = true;
                checkColor(newNode);
            }else{
                add(parent.left, newNode);
            }            
        }
    }
    
    
    private void checkColor(Node<E> node) {
        if(node == root){
            return;
        }
        if(!node.black && !node.parent.black){
            correctTree(node);
        }
        checkColor(node.parent);
    }
    
    private void correctTree(Node<E> node) {
        if(node.parent.isLeftChild){//aunt is node.parent.parent.right
            if(node.parent.parent.right == null ||
                    node.parent.parent.right.black){
                rotate(node);
                return;
            }
            if(node.parent.parent.right != null){
                node.parent.parent.right.black = true;
            }
            node.parent.parent.black = false;
            node.parent.black = true;
            return;
        }
        //aunt is parent.parent.left
        if(node.parent.parent.left == null ||
                node.parent.parent.left.black){
            rotate(node);
            return;
        }
        if(node.parent.parent.left != null){
            node.parent.parent.left.black = true;
        }
        node.parent.parent.black = false;
        node.parent.black = true;
    }
    
    private void rotate(Node<E> node){
        if(node.isLeftChild){//if it is left child
            if(node.parent.isLeftChild){
                rightRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if(node.parent.right != null)
                    node.parent.right.black = false;
                return;
            }
            rightLeftRotate(node.parent.parent);
            node.black = true;
            node.right.black = false;
            node.left.black = false;
            return;
        }
        
        //if it is a right child
        if(!node.parent.isLeftChild){
                leftRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if(node.parent.left != null)
                    node.parent.left.black = false;
                return;
            }
            leftRightRotate(node.parent.parent);
            node.black = true;
            node.right.black = false;
            node.left.black = false;
    }
    
    
    private void rightRotate(Node<E> node){
        Node<E> temp = node.left;
        node.left = temp.right;
        if(node.left != null){
            node.left.parent = node;
            node.left.isLeftChild = true;
        }
        if(node.parent == null){//we are the root node
            root = temp;
            temp.parent = null;
        }else{
            temp.parent = node.parent;
            if(node.isLeftChild){
                temp.isLeftChild = true;
                temp.parent.left = temp;
            }else{
                temp.isLeftChild = false;
                temp.parent.right = temp;
            }
        }
        temp.right = node;
        node.isLeftChild = false;
        node.parent = temp;
    }
    
    private void leftRotate(Node<E> node){
        Node<E> temp = node.right;
        node.right = temp.left;
        if(node.right != null){
            node.right.parent = node;
            node.right.isLeftChild = false;
        }
        if(node.parent == null){//we are the root node
            root = temp;
            temp.parent = null;
        }else{
            temp.parent = node.parent;
            if(node.isLeftChild){
                temp.isLeftChild = true;
                temp.parent.left = temp;
            }else{
                temp.isLeftChild = false;
                temp.parent.right = temp;
            }
        }
        temp.left = node;
        node.isLeftChild = true;
        node.parent = temp;
    }
    
    private void rightLeftRotate(Node<E> node){
        rightRotate(node.right);
        leftRotate(node);
    }
    
    private void leftRightRotate(Node<E> node){
        leftRotate(node.left);
        rightRotate(node);
    }
    
    
    public int height(){
        if(root == null){
            return 0;
        }
        return height(root) - 1;
    }
    
    private int height(Node<E> node){
        if(node == null)
            return 0;
        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;
        if(leftHeight > rightHeight)
            return leftHeight;
        return rightHeight;
    }
    
    @Override
    public Iterator<E> descendingIterator() {
        return new IteratorKTU(false);

    }
    
    @Override
    public Iterator<E> ascendingIterator() {
        return new IteratorKTU(true);

    }
    
    /**
     * Vidinė objektų kolekcijos iteratoriaus klasė. Iteratoriai: didėjantis ir
     * mažėjantis. Kolekcija iteruojama kiekvieną elementą aplankant vieną kartą
     * vidine (angl. inorder) tvarka. Visi aplankyti elementai saugomi steke.
     * Stekas panaudotas iš java.util paketo, bet galima susikurti nuosavą.
     */
    private class IteratorKTU implements Iterator<E> {

        private Stack<Node<E>> stack = new Stack<>();
        // Nurodo iteravimo kolekcija kryptį, true - didėjimo tvarka, false - mažėjimo
        private boolean ascending;
        // Nurodo einamojo medžio elemento tėvą. Reikalingas šalinimui.
        private Node<E> parent = root;

        IteratorKTU(boolean ascendingOrder) {
            this.ascending = ascendingOrder;
            this.toStack(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public E next() {
            if (!stack.empty()) {
                // Grąžinamas paskutinis į steką patalpintas elementas
                Node<E> n = stack.pop();
                // Atsimenama tėvo viršunė. Reikia remove() metodui
                parent = (!stack.empty()) ? stack.peek() : root;
                Node node = (ascending) ? n.right : n.left;
                // Dešiniajame n pomedyje ieškoma minimalaus elemento,
                // o visi paieškos kelyje esantys elementai talpinami į steką
                toStack(node);
                return n.element;
            } else { // Jei stekas tuščias
                return null;
            }
        }

        @Override
        public void remove() {
            
        }

        private void toStack(Node<E> n) {
            while (n != null) {
                stack.push(n);
                n = (ascending) ? n.left : n.right;
            }
        }
    }
}

