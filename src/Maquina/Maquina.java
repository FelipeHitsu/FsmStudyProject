package Maquina;

import Farmer.*;

public class Maquina {

    public static Maquina instance;
    private Farmer Bob = new Farmer(0,0,0,"Bob",1);
    private Billy Billy = new Billy(0,0,"Billy",2);

    public void run() throws InterruptedException {
        while(true) {
            Bob.update();
            Billy.update();
            Thread.sleep(500);
        }
    }

    public static Maquina getInstance(){
        if(instance == null){
            instance = new Maquina();
        }
        return instance;

    }
}

