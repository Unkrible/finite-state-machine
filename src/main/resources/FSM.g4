grammar FSM;

program: events commands states;

events: Events event+ End;

event: name code Semicolon;
name: ID;
code: ID;

commands: Commands command+ End;
command: name code Semicolon;

states: state+;

state: State name actions? transitions? End;
actions: Actions code+ Semicolon;
transitions: transition+;
transition: code Transition name Semicolon;

Transition: '=>';
State: 'state';
Events: 'events';
Commands: 'commands';
Actions: 'actions';
End: 'end';
Semicolon: ';';

Whitespace
    :   [ \r\t\n]+
        -> skip
    ;
ID: Char+;

fragment Letter: [a-zA-Z_];
fragment Digit: [0-9];
fragment Char: Letter | Digit;