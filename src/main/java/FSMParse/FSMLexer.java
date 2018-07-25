// Generated from C:/xzr/Project/FiniteStateMachine/src/main/resources\FSM.g4 by ANTLR 4.7
package FSMParse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FSMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Transition=1, State=2, Events=3, Commands=4, Actions=5, End=6, Semicolon=7, 
		Whitespace=8, ID=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Transition", "State", "Events", "Commands", "Actions", "End", "Semicolon", 
		"Whitespace", "ID", "Letter", "Digit", "LetterOrDigit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'=>'", "'state'", "'events'", "'commands'", "'actions'", "'end'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Transition", "State", "Events", "Commands", "Actions", "End", "Semicolon", 
		"Whitespace", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FSMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FSM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13V\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tD\n\t\r\t\16\tE\3\t\3\t\3"+
		"\n\6\nK\n\n\r\n\16\nL\3\13\3\13\3\f\3\f\3\r\3\r\5\rU\n\r\2\2\16\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\3\2\5\4\2\13\13\"\""+
		"\5\2C\\aac|\3\2\62;\2U\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\33"+
		"\3\2\2\2\5\36\3\2\2\2\7$\3\2\2\2\t+\3\2\2\2\13\64\3\2\2\2\r<\3\2\2\2\17"+
		"@\3\2\2\2\21C\3\2\2\2\23J\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31T\3\2\2\2"+
		"\33\34\7?\2\2\34\35\7@\2\2\35\4\3\2\2\2\36\37\7u\2\2\37 \7v\2\2 !\7c\2"+
		"\2!\"\7v\2\2\"#\7g\2\2#\6\3\2\2\2$%\7g\2\2%&\7x\2\2&\'\7g\2\2\'(\7p\2"+
		"\2()\7v\2\2)*\7u\2\2*\b\3\2\2\2+,\7e\2\2,-\7q\2\2-.\7o\2\2./\7o\2\2/\60"+
		"\7c\2\2\60\61\7p\2\2\61\62\7f\2\2\62\63\7u\2\2\63\n\3\2\2\2\64\65\7c\2"+
		"\2\65\66\7e\2\2\66\67\7v\2\2\678\7k\2\289\7q\2\29:\7p\2\2:;\7u\2\2;\f"+
		"\3\2\2\2<=\7g\2\2=>\7p\2\2>?\7f\2\2?\16\3\2\2\2@A\7=\2\2A\20\3\2\2\2B"+
		"D\t\2\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\b\t\2\2"+
		"H\22\3\2\2\2IK\5\31\r\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\24\3"+
		"\2\2\2NO\t\3\2\2O\26\3\2\2\2PQ\t\4\2\2Q\30\3\2\2\2RU\5\25\13\2SU\5\27"+
		"\f\2TR\3\2\2\2TS\3\2\2\2U\32\3\2\2\2\6\2ELT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}