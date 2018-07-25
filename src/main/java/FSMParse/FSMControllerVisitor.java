package FSMParse;

import Event.AbstractEvent;
import Event.Event;
import Event.Command;

import State.State;
import State.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FSMControllerVisitor extends FSMBaseVisitor<Integer>{
    Map<String, AbstractEvent> eventMap = new HashMap<String, AbstractEvent>();
    Map<String, State> stateMap = new HashMap<String, State>();
    private Controller controller;

    @Override
    public Integer visitEvent(FSMParser.EventContext ctx) {
        String name = ctx.name().getText();
        String code = ctx.code().getText();
        eventMap.put(code, new Event(name, code));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitCommand(FSMParser.CommandContext ctx) {
        String name = ctx.name().getText();
        String code = ctx.code().getText();
        eventMap.put(code, new Command(name, code));
        return visitChildren(ctx);
    }

    @Override
    public Integer visitState(FSMParser.StateContext ctx) {
        String name = ctx.name().getText();
        State state;
        if(stateMap.containsKey(name)){
            state = stateMap.get(name);
        }
        else{
            state = new State(name);
            stateMap.put(name, state);
        }
        visitTransitions(ctx.transitions(), state);
        visitActions(ctx.actions(), state);

        if(name.equals("idle"))
            controller = new Controller(state);

        return visitChildren(ctx);
    }

    public void visitTransitions(FSMParser.TransitionsContext ctx, State state) {
        if(ctx == null)
            return;
        List<FSMParser.TransitionContext> transitions = ctx.transition();
        for(FSMParser.TransitionContext transition : transitions)
            visitTransition(transition, state);

    }

    public void visitTransition(FSMParser.TransitionContext ctx, State source) {
        String code = ctx.code().getText();
        String name = ctx.name().getText();
        if(!(eventMap.containsKey(code) && eventMap.get(code) instanceof Event)) {
            System.err.printf("Error: unknown Event %s\r\n", code);
            return;
        }
        State target;
        if(stateMap.containsKey(name)){
            target = stateMap.get(name);
        }
        else{
            target = new State(name);
            stateMap.put(name, target);
        }
        source.addTransition((Event)eventMap.get(code), target);
    }

    public void visitActions(FSMParser.ActionsContext ctx, State state) {
        if(ctx == null)
            return;
        List<FSMParser.CodeContext> codes = ctx.code();
        for(FSMParser.CodeContext codeContext : codes){
            String code = codeContext.getText();
            if(!(eventMap.containsKey(code) && eventMap.get(code) instanceof Command)){
                System.err.printf("Error: unknown Command %s", code);
                continue;
            }
            state.addCommand((Command)eventMap.get(code));
        }
    }

    public Controller getController(){
        return this.controller;
    }

}
