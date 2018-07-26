import FSMParse.FSMControllerVisitor;
import FSMParse.FSMLexer;
import FSMParse.FSMParser;

import GUI.PanelFrame;
import State.Controller;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.charset.Charset;
import java.util.Properties;

public class Driver {
    public static void main(String[] args) throws Exception{
        String path = args.length == 1 ? args[0] : "/151220136.fsm";
        CharStream stream = CharStreams.fromStream(Driver.class.getResourceAsStream(path), Charset.forName("UTF-8"));
        FSMParser parser = new FSMParser(new CommonTokenStream(new FSMLexer(stream)));
        FSMControllerVisitor visitor = new FSMControllerVisitor();
        visitor.visitProgram(parser.program());
        Controller roomController = visitor.getController();
        PanelFrame frame = new PanelFrame(roomController.getCommandChannel());
    }
}
