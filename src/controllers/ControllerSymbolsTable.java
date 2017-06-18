package compilador.controllers;

import compilador.models.compiler.SymbolsTable;
import compilador.models.compiler.parsers.IParser;
import compilador.models.compiler.parsers.ParserSymbolsTable;
import java.io.File;

public class ControllerSymbolsTable {

    private ControllerFile controllerFile;

    public ControllerSymbolsTable(ControllerFile controllerFile) {
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

    public SymbolsTable getContent(File file) throws Exception {
        String string = getControllerFile().getContent(file, false);
        IParser parser = new ParserSymbolsTable(string);
        return (SymbolsTable) parser.parse();
    }

}
