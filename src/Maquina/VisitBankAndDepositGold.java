package Maquina;

import Farmer.Farmer;
import Messages.Message;

public class VisitBankAndDepositGold implements State<Farmer> {

    public static VisitBankAndDepositGold instance = null;

    private VisitBankAndDepositGold(){

    }

    public static VisitBankAndDepositGold getInstance() {
        if(instance==null)
            instance = new VisitBankAndDepositGold();
        return instance;
    }

    @Override
    public void enter(Farmer farmer) {
        System.out.println("Chegando no banco");
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("Saindo do banco");
    }

    @Override
    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }

    @Override
    public void execute(Farmer farmer) {

        System.out.println("Depositando Dinheiros (ʘ∇ʘ)ク");

        farmer.m_banco += farmer.m_ouro;

        farmer.m_ouro = 0;

        if(farmer.m_fadiga >= 25)
           farmer.getStateMachine().ChangeState(GoHomeAndSleepTillRested.getInstance());
        else
            farmer.getStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());

    }
}
