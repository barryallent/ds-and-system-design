package org.example.LLD.Designs.GarbageCollector;

import java.util.*;

public class GarbageCollector {

    Set<Object> markedObjects = new HashSet<>();

    //recursively mark all the child objects for a obj using DFS
    void mark(Object obj) {
        if( obj==null || markedObjects.contains(obj)) {
            return;
        }
        markedObjects.add(obj);
        for(Object childObject:getObjectReference(obj)) {
            mark(childObject);
        }
    }

    //sweep all the objects that are not marked
    void sweep(List<Object> heap) {
        Iterator<Object> it= heap.iterator();
        while(it.hasNext()) {
            Object obj = it.next();
            if(!markedObjects.contains(obj)) {
                //reclaim memory
                it.remove();
            }
        }
    }

    //get all root objects from stack, global vars or static fields
    List<Object> getRootObjects() {
        return new ArrayList<>();
    }

    // Return all objects referenced by this object
    List<Object> getObjectReference(Object obj) {
        return new ArrayList<>();
    }

    void runGC(List<Object> heap) {

        // 1. Mark all reachable objects
        List<Object> objects = getRootObjects();
        for(Object obj:objects) {
            mark(obj);
        }
        // 2. Sweep and remove all unmarked objects
        sweep(heap);

    }
}
