// Generated from C:/xzr/Project/FiniteStateMachine/src/main/resources\FSM.g4 by ANTLR 4.7
package FSMParse;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FSMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FSMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FSMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FSMParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#events}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvents(FSMParser.EventsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(FSMParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(FSMParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(FSMParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#commands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommands(FSMParser.CommandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(FSMParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(FSMParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(FSMParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActions(FSMParser.ActionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitions(FSMParser.TransitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSMParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(FSMParser.TransitionContext ctx);
}