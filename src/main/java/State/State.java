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
    protected String name;
    protected List<Command> actions = new LinkedList<Command>();
    protected Map<String, Transition> transitions = new HashMap<String, Transition>();
    protected Map<String, String> codes = new HashMap<>();

    public void addCommand(Command command){
        assert null != command;
        actions.add(command);
    }

    public void addTransition(Event event, State target){
        assert null != target;
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
        return codes.getOrDefault(name, null);
    }

    public State targetState(String code){
        return transitions.get(code).getTarget();
    }

    public void executeActions(CommandChannel commandChannel){
        for(Command command : actions){
            commandChannel.send(command.getCode());
        }
    }
}
