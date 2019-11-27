package Maquina;

import Farmer.Farmer;
import Messages.Message;

public class VisitBathroom implements State<Farmer> {


    private static VisitBathroom instance = null;
    private VisitBathroom() { }
    public static VisitBathroom getInstance() {
        if(instance == null) {
            instance = new VisitBathroom();
        }
        return instance;
    }
    //End Singleton:
    @Override
    public void enter(Farmer farmer) {
        System.out.println("Entrando no banheiro");

    }

    @Override
    public void execute(Farmer farmer) {
        farmer.m_bexiga -= 10;
        System.out.println("Urinando");
        if(farmer.m_bexiga <= 0)
            farmer.getStateMachine().RevertToPreviousState();
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Saindo do banheiro");
    }

    @Override
    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }
}
