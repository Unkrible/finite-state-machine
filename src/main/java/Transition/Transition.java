package Transition;

import State.State;
import Event.Event;

public class Transition {
    protected final State source;
    protected final State target;
    protected final Event trigger;

    public Transition(State source, State target, Event trigger){
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return this.source;
    }

    public State getTarget(){
        return this.target;
    }

    public String getEventCode(){
        return this.trigger.getCode();
    }
}
