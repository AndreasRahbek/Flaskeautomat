package org.example;

import java.util.Random;

public class Producent implements Runnable{

    Buffer buffer;
    int flaskerTilProducering;

    public Producent(Buffer buffer, int produceAmount){
        this.buffer = buffer;
        this.flaskerTilProducering = produceAmount;
    }

    @Override
    public void run() {
        while(flaskerTilProducering >0) {
            Random random = new Random();
            int randomNumber = random.nextInt(2);
            Flaske flaske = new Flaske();

            if (randomNumber == 0) {
                flaske.setType("Øl");
            } else flaske.setType("Sodavand");

            buffer.tilfoejFlaskeTilKoe(flaske);
            flaskerTilProducering--;
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
