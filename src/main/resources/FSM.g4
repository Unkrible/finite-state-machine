grammar FSM;

TRANSITION: '=>';
Whitespace
    :   [ \t]+
        -> skip
    ;
LB : '{';
RB : '}';



fragment Letter: [a-zA-Z_];
fragment Digit: [0-9];
fragment LetterOrDigit: Letter | Digit;