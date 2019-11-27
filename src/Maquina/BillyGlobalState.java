package Maquina;

import Farmer.*;
import Messages.Message;

public class BillyGlobalState implements State<Billy> {

    private static BillyGlobalState instance = null;

    private BillyGlobalState(){};

    public static BillyGlobalState getInstance(){
        if(instance == null){
            instance = new BillyGlobalState();
        }
        return instance;
    }


    @Override
    public void enter(Billy billy) {

    }

    @Override
    public void execute(Billy billy) {

    }

    @Override
    public void exit(Billy billy) {

    }

    @Override
    public boolean onMessage(Billy billy   , Message msg) {

        if(msg.getMessage().equals("work")){
            billy.getStateMachine().ChangeState(FakeWork.getInstance());
            return true;
        }else{
            return false;
        }

    }
}
