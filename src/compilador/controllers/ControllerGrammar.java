package compilador.controllers;

import compilador.models.compiler.Grammar;
import compilador.models.compiler.parsers.IParser;
import compilador.models.compiler.parsers.ParserGrammar;
import java.io.File;

public class ControllerGrammar {

    private ControllerFile controllerFile;

    public ControllerGrammar(ControllerFile controllerFile) {
        this.controllerFile = controllerFile;
    }

    /**
     * Get the value of controllerFile
     *
     * @return the value of controllerFile
     */
    public ControllerFile getControllerFile() {
        return controllerFile;
    }

    /**
     * Set the value of controllerFile
     *
     * @param controllerFile new value of controllerFile
     */
    public void setControllerFile(ControllerFile controllerFile) {
        this.controllerFile = controllerFile;
    }

    public Grammar getContent(File fileGrammar, File fileGrammarSpecialSymbols) throws Exception {
        String grammarFileContent = getControllerFile().getContent(fileGrammar, false);
        String grammarSpecialSymbolsContent = getControllerFile().getContent(fileGrammarSpecialSymbols, false);
        IParser parser = new ParserGrammar(grammarFileContent, grammarSpecialSymbolsContent);
        return (Grammar) parser.parse();
    }

}
