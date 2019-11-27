package Maquina;

import Farmer.Billy;
import Messages.Message;


import java.util.Random;

public class LookAtTheWeather implements State<Billy> {

    public static LookAtTheWeather instance = null;

    private LookAtTheWeather(){

    }

    public static LookAtTheWeather getInstance() {
        if(instance==null)
            instance = new LookAtTheWeather();
        return instance;
    }

    Random random = new Random();

    @Override
    public void enter(Billy billy) {
        System.out.println("Billy: Vou olhar o tempo!");
    }

    @Override
    public void execute(Billy billy) {
        System.out.println("Billy: Olhando o tempo!");
        billy.m_look = random.nextInt(100) +1;

        if (billy.m_look > 75 ){
            billy.getStateMachine().ChangeState(WalkAroundTheFarm.getInstance());
        }
    }

    @Override
    public void exit(Billy billy) {
        System.out.println("Billy: Vou parar de olhar o tempo");
    }

    @Override
    public boolean onMessage(Billy billy, Message msg) {
        return false;
    }
}
