package State;

import Event.Command;
import Event.Event;
import Transition.Transition;
import Transition.CommandChannel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class State {
    public static final String OTHER = "other";

    protected String name;
    protected List<Command> actions;
    protected Map<String, Transition> transitions;
    protected Map<String, String> codes;

    public State(String name){
        this.name = name;
        actions = new LinkedList<>();
        transitions = new HashMap<>();
        codes = new HashMap<>();
    }

    public void addCommand(Command command){
        if(null == command) {
            System.err.println("Error: null Command");
            return;
        }
        actions.add(command);
    }

    public void addTransition(Event event, State target){
        if(!(null != target && event != null)){
            System.err.println("Error: add Transition");
            return;
        }
        this.transitions.put(event.getCode(), new Transition(this, target, event));
        this.codes.put(event.getName(), event.getCode());
    }

    public List<State> getAllTargets(){
        List<State> results = new LinkedList<State>();
        for(Transition transition : transitions.values()){
            results.add(transition.getTarget());
        }
        return results;
    }

    public boolean hasTransition(String code){
        return transitions.containsKey(code);
    }

    public String getTransitionCode(String name){
        if(codes.containsKey(name))
            return codes.get(name);
        return codes.get(State.OTHER);
    }

    public State targetState(String code){
        return transitions.get(code).getTarget();
    }

    public void executeActions(CommandChannel commandChannel){
        for(Command command : actions){
            commandChannel.send(command.getName());
        }
    }
}
