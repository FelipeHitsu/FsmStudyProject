package Maquina;

import Farmer.*;
import Messages.*;
import Messages.Message;
import Messages.MessageDispatcher;

import java.util.Random;

public class GoHomeAndSleepTillRested implements State<Farmer> {

    public static GoHomeAndSleepTillRested instance = null;

    private GoHomeAndSleepTillRested(){

    }

    public static GoHomeAndSleepTillRested getInstance() {
        if(instance==null)
            instance = new GoHomeAndSleepTillRested();
        return instance;
    }

    Random random = new Random();


    @Override
    public void enter(Farmer farmer) {
        System.out.println("Vim pra casa");
        farmer.setBillyWorked(false);
        System.out.println("Billy e falso");
        Entity billy = EntityManager.getInstance().getEntity("Billy");
        System.out.println("Referenciei o billy");
        MessageDispatcher.getInstance().dispatchMessage(farmer,billy,"work",null);
        System.out.println("Chegando em casa");
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Acordei (*・_・)ノ*`*`*");
    }

    @Override
    public void execute(Farmer farmer) {
        System.out.println("Dormindo ［(－－)］zzz ");
        farmer.m_fadiga -= random.nextInt(5);

        if(farmer.m_fadiga <= 0 && farmer.getBillyWorked()){
            farmer.m_fadiga = 0;
            farmer.getStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());
        }
        else if(farmer.m_fadiga<=0)
        {
            System.out.println("Esperando o billy acaba o trampo");
        }
    }

    @Override
    public boolean onMessage(Farmer f, Message msg) {
        return false;
    }
}
