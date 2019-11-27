package Farmer;

import Maquina.*;

public class Billy extends Entity {

    public int m_walk, m_look;
    String m_nome;
    private StateMachine stateMachine;

    public StateMachine<Billy> getStateMachine(){return stateMachine;}


    public Billy(int p_walk, int p_look, String p_nome,int id){
        super(p_nome,id);
        m_walk = p_walk;
        m_look = p_look;
        m_nome = p_nome;

        stateMachine = new StateMachine<Billy>(this);

        stateMachine.SetCurrentState(LookAtTheWeather.getInstance());
        stateMachine.SetGlobalState(BillyGlobalState.getInstance());
    }

    @Override
    public void update() {
        stateMachine.Update();
    }
}
