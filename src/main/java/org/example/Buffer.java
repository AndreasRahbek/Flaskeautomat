package org.example;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private LinkedList<Flaske> queue = new LinkedList<>();
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private String listNavn;

    @Override
    public String toString() {
        return listNavn;
    }

    public Buffer(int capacity, String listNavn){
        this.capacity = capacity;
        this.listNavn = listNavn;
    }


    public void tilfoejFlaskeTilKoe(Flaske flaske) {
        lock.lock();
        try {
            while (queueSize() >= capacity) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(flaske);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    public Flaske hentFoersteFlaske(){
       lock.lock();
       try {
           while (queueSize() <= 0) {
               try {
                   notEmpty.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           Flaske flaske =  queue.getFirst();
           queue.removeFirst();
           notFull.signal();
           return flaske;
       } finally {
           lock.unlock();
       }
    }

    public int queueSize(){
        return queue.size();
    }



}
