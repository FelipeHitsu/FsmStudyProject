package Maquina;

import Farmer.Farmer;
import Messages.Message;

public class BobGlobalState implements State<Farmer> {

    private static BobGlobalState instance = null;

    private BobGlobalState(){};

    public static BobGlobalState getInstance(){
        if(instance == null){
            instance = new BobGlobalState();
        }
        return instance;
    }


    @Override
    public void enter(Farmer farmer) {
        System.out.println("Entrando no Estado Global");
    }

    @Override
    public void execute(Farmer farmer) {
        if(farmer.m_bexiga >= 50)
            farmer.getStateMachine().ChangeState(VisitBathroom.getInstance());
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Saindo do Estado Global");
    }

    @Override
    public boolean onMessage(Farmer farmer, Message msg) {

        if(msg.getMessage().compareToIgnoreCase("done")==0){
            farmer.setBillyWorked(true);
            return true;
        }else{
            return false;
        }

    }
}
