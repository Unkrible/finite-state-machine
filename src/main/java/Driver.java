import GUI.PanelFrame;
import State.Controller;
import Transition.CommandChannel;

public class Driver {
    public static void main(String[] args){
        Controller roomController = new Controller();
        CommandChannel commandChannel = roomController.getCommandChannel();
        PanelFrame frame = new PanelFrame(commandChannel);
    }
}
