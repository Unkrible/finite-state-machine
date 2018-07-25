package Transition;

import State.Controller;

public class CommandChannel {
    private Controller controller;

    public CommandChannel(Controller controller){
        this.controller = controller;
    }

    public void send(String code){
        controller.handle(code);
    }

    public void sendByName(String name){
        System.out.println(String.format("Channel send by name %s", name));
        controller.handleByName(name);
    }

    public String getInfo(){
        return controller.getInfo();
    }
}
