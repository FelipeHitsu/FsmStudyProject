package Maquina;
import Messages.*;

public class StateMachine<NonPlayableCharacter> {

    private NonPlayableCharacter myOwner;

    private State<NonPlayableCharacter> estadoAtual;

    private State<NonPlayableCharacter> estadoAnterior;

    private State<NonPlayableCharacter> estadoGlobal;

    public StateMachine(NonPlayableCharacter owner){
        myOwner = owner;
        estadoAnterior = null;
        estadoAtual = null;
        estadoGlobal = null;
    }

    public void SetCurrentState(State<NonPlayableCharacter> state){
        estadoAtual = state;
    }

    public void SetGlobalState(State<NonPlayableCharacter> state){
        estadoGlobal = state;
    }

    public void SetPreviousState(State<NonPlayableCharacter> state){
        estadoAnterior = state;
    }

    public void Update(){

        if(estadoGlobal != null){
            estadoGlobal.execute(myOwner);
        }

        if(estadoAtual != null){
            estadoAtual.execute(myOwner);
        }


    }

    public void ChangeState(State<NonPlayableCharacter>novoEstado){
        estadoAnterior = estadoAtual;
        estadoAtual.exit(myOwner);
        estadoAtual = novoEstado;
        estadoAtual.enter(myOwner);
    }

    public void RevertToPreviousState(){
        ChangeState(estadoAnterior);
    }

    public State<NonPlayableCharacter>getCurrentState(){
        return estadoAtual;
    }

    public State<NonPlayableCharacter>getGlobalState(){
        return estadoGlobal;
    }

    public State<NonPlayableCharacter>getPreviousState(){
        return estadoAnterior;
    }

    public boolean handleMessage(Message msg){
        if(estadoAtual.onMessage(myOwner,msg)){
            return true;
        }
        else if(estadoGlobal != null && estadoGlobal.onMessage(myOwner,msg)){
            return true;
        }
        else {
            return false;
        }

    }

}
