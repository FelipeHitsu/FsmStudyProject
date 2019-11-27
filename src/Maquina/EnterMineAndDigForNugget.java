package Maquina;

import Farmer.Farmer;
import Messages.Message;

import java.util.Random;

public class EnterMineAndDigForNugget implements State<Farmer> {

    public static EnterMineAndDigForNugget instance = null;

    private EnterMineAndDigForNugget(){

    }

    public static EnterMineAndDigForNugget getInstance() {
        if(instance==null)
            instance = new EnterMineAndDigForNugget();
        return instance;
    }

    Random random = new Random();

    @Override
    public void enter(Farmer farmer) {
        System.out.println("Entrando na mina");
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Saindo da mina");

    }

    @Override
    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }

    @Override
    public void execute(Farmer farmer) {
        System.out.println("Minerando (ﾉ °益°)ﾉ ");
        farmer.m_ouro += random.nextInt(10);
        farmer.m_sede += random.nextInt(8);
        farmer.m_fadiga += random.nextInt(5);
        farmer.m_bexiga += random.nextInt(10);

        if (farmer.m_sede >= 80){
            farmer.getStateMachine().ChangeState(QuenchyThirst.getInstance());
        }

        else if (farmer.m_ouro >= 100){
            farmer.getStateMachine().ChangeState(VisitBankAndDepositGold.getInstance());
        }

    }
}
