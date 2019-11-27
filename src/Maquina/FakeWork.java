package Maquina;

import Farmer.*;
import Messages.Message;
import Messages.MessageDispatcher;

import java.util.Random;

public class FakeWork implements State<Billy> {

    public static FakeWork instance = null;

    private FakeWork(){

    }

    public static FakeWork getInstance() {
        if(instance==null)
            instance = new FakeWork();
        return instance;
    }
    
    @Override
    public void enter(Billy billy) {
        
    }

    @Override
    public void execute(Billy billy) {

        System.out.println("Fazendo nada");
        System.out.println("Digo,to trampando");

        Random r = new Random();

        int rand = r.nextInt(50);

        if(rand < 40 ){

        }
        else{
            billy.getStateMachine().ChangeState(LookAtTheWeather.getInstance());
        }
    }

    @Override
    public void exit(Billy billy) {
        MessageDispatcher.getInstance().dispatchMessage(billy,EntityManager.getInstance().getEntity("Bob"),"done",null);
    }

    @Override
    public boolean onMessage(Billy billy, Message msg) {
        return false;
    }
}
