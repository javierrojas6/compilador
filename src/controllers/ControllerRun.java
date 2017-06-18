package compilador.controllers;

import compilador.config.Config;
import compilador.models.compiler.Grammar;
import compilador.models.compiler.IAnalyzer;
import compilador.models.compiler.SymbolsTable;
import compilador.models.compiler.lexicanalyzer.LexicalAnalyzer;
import compilador.models.compiler.sintacticanalyzer.SintacticAnalyzer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;

public class ControllerRun {

    private String pathName;
    private SymbolsTable symbolsTable;
    private Grammar grammar;

    public ControllerRun(String pathName, SymbolsTable table, Grammar grammar) {
        setPathName(pathName);
        setSymbolsTable(table);
        setGrammar(grammar);
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    /**
     * Get the value of symbolsTable
     *
     * @return the value of symbolsTable
     */
    public SymbolsTable getSymbolsTable() {
        return symbolsTable;
    }

    /**
     * Set the value of symbolsTable
     *
     * @param table new value of symbolsTable
     */
    public void setSymbolsTable(SymbolsTable table) {
        this.symbolsTable = table;
    }

    /**
     * Get the value of pathName
     *
     * @return the value of pathName
     */
    public String getPathName() {
        return pathName;
    }

    /**
     * Set the value of pathName
     *
     * @param pathName new value of pathName
     */
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    /**
     * ejecuta los algoritmos principales de ejecucion del compilador
     *
     * @param code el codigo que sera sometido a analisis
     * @return devuelve un booleano indicando si se ha llevado acabo todo el
     * proceso de analisis, que a la vez implica la generacion de todos los
     * archivos temporales que se necesitan
     * @throws java.io.FileNotFoundException
     */
    public boolean run(String code) throws FileNotFoundException, IOException {
        /*ejecucion del analisis lexico*/
        IAnalyzer lexicAnalyzer = new LexicalAnalyzer(getSymbolsTable(), code);
        String ObjString1 = lexicAnalyzer.start();
        
        /*ejecucion del analisis sintactico*/
        IAnalyzer sintacticAnalyzer = new SintacticAnalyzer(getGrammar(), ObjString1);
        String ObjString2 = sintacticAnalyzer.start();
        
        ControllerFile controller = new ControllerFile();
        String absoluteFileName = getPathName() + FileSystems.getDefault().getSeparator() + Config.FILENAME_LEXICAL_ANALIZER;
        return controller.saveContent(ObjString1, absoluteFileName);
    }

}
