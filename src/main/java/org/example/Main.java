package org.example;

public class Main {
    public static void main(String[] args) {

        Buffer alleFlasker = new Buffer(8, "AlleFlasker-liste");
        Buffer oel = new Buffer(8, "Øl-liste");
        Buffer sodavand = new Buffer(8, "Sodavand-liste");

        Thread producent = new Thread(new Producent(alleFlasker,100));
        Thread splitter = new Thread(new Splitter(oel,sodavand,alleFlasker));
        Thread sodavandConsumer = new Thread(new Consumer(sodavand, "Sodavand Consumer"));
        Thread oelConsumer = new Thread(new Consumer(oel, "Oel Consumer"));

        producent.start();
        splitter.start();
        sodavandConsumer.start();
        oelConsumer.start();



    }
}