package org.example;

import java.util.LinkedList;

public class Consumer implements Runnable{
    Buffer henteListe;
    LinkedList<Flaske> consumerListe = new LinkedList<>();
    String consumerNavn;

    public Consumer(Buffer retrieveBuffer, String consumerNavn){
        this.henteListe = retrieveBuffer;
        this.consumerNavn = consumerNavn;
    }

    @Override
    public String toString() {
        return consumerNavn + "{" + henteListe + ": " + consumerListe;
    }

    @Override
    public void run() {
        while(true) {
            consumerListe.addLast(henteListe.hentFoersteFlaske());
            System.out.println(this);
/*
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

 */

        }
    }
}
