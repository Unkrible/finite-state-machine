package State;

import Transition.CommandChannel;

public class Controller {
    private String info;
    private State currentState;
    private CommandChannel commandChannel;

    public Controller(State idle){
        commandChannel = new CommandChannel(this);
        this.transitionTo(idle);
    }

    public String getInfo(){
        return info;
    }

    public void updateInfo(String info){
        this.info = info;
    }

    public CommandChannel getCommandChannel(){
        return commandChannel;
    }

    public void handle(String eventCode){
        // ignore unknown code;
        if(eventCode == null)
            return;
        else if(!currentState.hasTransition(eventCode)){
            // Command
            updateInfo(eventCode);
        }
        else {
            // Event
            this.transitionTo(currentState.targetState(eventCode));
        }
    }

    public void handleByName(String eventName){
        this.handle(currentState.getTransitionCode(eventName));
    }

    private void transitionTo(State targetState){
        currentState = targetState;
        currentState.executeActions(commandChannel);
    }
}
