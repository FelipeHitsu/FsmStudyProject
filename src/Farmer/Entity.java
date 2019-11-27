package Farmer;

import Maquina.*;
import Messages.Message;

public abstract class Entity {

    private String name;
    private int id;

    protected StateMachine stateMachine;

    public Entity(String name,int id){
        this.name = name;
        this.id = id;
        EntityManager.getInstance().registerEntity(this);
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract void update();

    public boolean handleMessage(Message msg){
        return stateMachine.handleMessage(msg);
    }
}
