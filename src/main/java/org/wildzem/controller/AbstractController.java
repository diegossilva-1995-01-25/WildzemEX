package org.wildzem.controller;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Generic interface for a controller, providing 4 basic methods that nearly
 * controller will need.
 * 
 * @param <T>: will be replaced by the object specified in the implementation
 *
 */

public interface AbstractController<T> {

    void addNew();
    void editRecord(T object);
    void updateRecord();
    void deleteRecord(T object);
}
