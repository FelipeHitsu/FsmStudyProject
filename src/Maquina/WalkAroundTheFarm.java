package Maquina;

import Farmer.Billy;
import Messages.Message;

import java.util.Random;

public class WalkAroundTheFarm implements State<Billy> {

    public static WalkAroundTheFarm instance = null;

    private WalkAroundTheFarm(){

    }

    public static WalkAroundTheFarm getInstance() {
        if(instance==null)
            instance = new WalkAroundTheFarm();
        return instance;
    }

    Random random = new Random();

    @Override
    public void enter(Billy billy) {
        System.out.println("Billy: Vou dar uma volta pela fazenda.");
    }

    @Override
    public void execute(Billy billy) {
        System.out.println("Billy: Andando por ai");
        billy.m_walk = random.nextInt(100) +1;

        if (billy.m_walk > 0 || billy.m_walk < 76 ){
            billy.getStateMachine().ChangeState(LookAtTheWeather.getInstance());
        }
    }

    @Override
    public void exit(Billy billy) {
        System.out.println("Billy: Vou dar uma parada.");
    }

    @Override
    public boolean onMessage(Billy billy, Message msg) {
        return false;
    }
}
