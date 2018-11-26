/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import java.util.Iterator;

/**
 *
 * @author Petras
 * @param <E>
 */
public interface RBTreeI<E> {
    
    
    void add(E element);
    
    Iterator<E> descendingIterator();
    
    Iterator<E> ascendingIterator();
}

