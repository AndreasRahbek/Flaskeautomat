package org.example;

import java.util.Objects;

public class Splitter implements Runnable{
    Buffer oel;
    Buffer sodavand;
    Buffer alleFlasker;


    public Splitter(Buffer oel, Buffer sodavand, Buffer alleFlasker){
        this.oel = oel;
        this.sodavand = sodavand;
        this.alleFlasker = alleFlasker;
    }

    @Override
    public void run() {
        while(true){
            Flaske flaske = alleFlasker.hentFoersteFlaske();
            if(Objects.equals(flaske.getType(), "Sodavand")){
                sodavand.tilfoejFlaskeTilKoe(flaske);
            } else oel.tilfoejFlaskeTilKoe(flaske);

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

             */
        }
    }
}
