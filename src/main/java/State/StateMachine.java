package State;

import java.util.Collection;
import java.util.LinkedList;

public class StateMachine {
    private State start;

    public StateMachine(State start){
        this.start = start;
    }

    public Collection<State> getStates(){
        Collection<State> results = new LinkedList<State>();
        collectStates(results, this.start);
        return results;
    }

    private void collectStates(Collection<State> results, State start){
        if(results.contains(start))
            return;

        results.add(start);
        Collection<State> targets = start.getAllTargets();
        for(State each : targets)
            collectStates(results, each);
    }
}
