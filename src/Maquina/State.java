package Maquina;

import Farmer.*;
import Messages.Message;

public interface State<NonPlayableCharacter> {

    public  void enter(NonPlayableCharacter npc);
    public  void execute(NonPlayableCharacter npc);
    public  void exit(NonPlayableCharacter npc);
    public  boolean onMessage(NonPlayableCharacter f, Message msg);

}
