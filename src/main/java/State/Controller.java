package State;

import Transition.CommandChannel;

public class Controller {
    public static final String IDLE = "请输入密码打开密室";
    public static final String WRONG_FORMAT = "密码错误: 第%d次";
    public static final String OPEN_TEMPORARILY = "密室打开";
    public static final String CLOSE_FOREVER = "密室永久封闭";

    private String info;
    private State currentState;
    private StateMachine stateMachine;
    private CommandChannel commandChannel;
    private int times;

    public Controller(State idle){
        info = Controller.IDLE;
        times = 0;
        currentState = idle;
        stateMachine = new StateMachine(idle);
        commandChannel = new CommandChannel(this);
    }

    public String getInfo(){
        return info;
    }

    public void updateInfo(){

    }

    public CommandChannel getCommandChannel(){
        return commandChannel;
    }

    public void handle(String eventCode){
        // ignore unknown code;
        if(eventCode == null || !currentState.hasTransition(eventCode))
            return;
        this.transitionTo(currentState.targetState(eventCode));
    }

    public void handleByName(String eventName){
        this.handle(currentState.getTransitionCode(eventName));
    }

    private void transitionTo(State targetState){
        currentState = targetState;
        currentState.executeActions(commandChannel);
    }
}
