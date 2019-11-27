package Maquina;

import Farmer.Farmer;
import Messages.Message;

import java.util.Random;

public class QuenchyThirst implements State<Farmer> {

    public static QuenchyThirst instance = null;

    private QuenchyThirst(){

    }

    public static QuenchyThirst getInstance() {
        if(instance==null)
            instance = new QuenchyThirst();
        return instance;
    }

    Random random = new Random();
    @Override
    public void enter(Farmer farmer) {
        System.out.println("Pegar uma agua");
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Hora de trampa (*・_・)ノ*`*`*");
    }

    @Override
    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }

    @Override
    public void execute(Farmer farmer) {

        System.out.println("Matando a sede 且_(ﾟ◇ﾟ；)ノﾞ");
        farmer.m_sede -= random .nextInt(20);

        if(farmer.m_sede <= 0){
            farmer.m_sede = 0;
            farmer.getStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());
        }

    }
}
