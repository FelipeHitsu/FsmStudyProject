package Farmer;

import Maquina.*;

import java.util.Random;

public class Farmer extends Entity{

    public int m_sede,m_fadiga,m_ouro,m_banco,m_bexiga;
    String m_nome;
    private boolean billyWorked;
    private StateMachine stateMachine;

    public StateMachine<Farmer>getStateMachine(){
        return stateMachine;
    }

    public Farmer (int p_sede, int p_fadiga, int p_ouro, String p_nome,int id) {
        super(p_nome,id);
        m_sede = p_sede;
        m_fadiga = p_fadiga;
        m_ouro = p_ouro;
        m_banco = 0;
        m_bexiga = 0;
        m_nome = p_nome;
        stateMachine = new StateMachine<Farmer>(this);
        stateMachine.SetCurrentState(EnterMineAndDigForNugget.getInstance());
        stateMachine.SetGlobalState(BobGlobalState.getInstance());

    }

    @Override
    public void update() {
        stateMachine.Update();
    }

    public void setBillyWorked(boolean state){
        billyWorked = state;
    }

    public boolean getBillyWorked(){
        return billyWorked;
    }


}
