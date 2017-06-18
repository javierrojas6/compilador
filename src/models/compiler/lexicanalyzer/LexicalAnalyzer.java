package compilador.models.compiler.lexicanalyzer;

import compilador.models.compiler.IAnalyzer;
import compilador.models.compiler.SymbolsTable;

public class LexicalAnalyzer implements IAnalyzer {

    private SymbolsTable simbolsTable;

    private String code;

    public LexicalAnalyzer(SymbolsTable simbolsTable, String code) {
        this.simbolsTable = simbolsTable;
        this.code = code;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the value of simbolsTable
     *
     * @return the value of simbolsTable
     */
    public SymbolsTable getSymbolsTable() {
        return simbolsTable;
    }

    /**
     * Set the value of simbolsTable
     *
     * @param simbolsTable new value of simbolsTable
     */
    public void setSimbolsTable(SymbolsTable simbolsTable) {
        this.simbolsTable = simbolsTable;
    }

    /**
     * hace el analisis lexico pasando del codigo fuente a codigo objeto lexico
     *
     * @return devuelve el codigo objeto resultado del analisis lexico
     */
    @Override
    public String start() {
        code = getCode();
        Automatas aut = new Automatas();
        String objCode = "";
        code = code.replaceAll("\n", "").replaceAll("\\s+", " ");
        String lexema = "";
        char currentChar;
        SymbolsTable table = getSymbolsTable();
        for (int i = 0; i < code.length(); i++) {
            currentChar = code.charAt(i);
            if (Automatas.isSeparatorCharacter(currentChar)) {
                /*aca termina algun lexema asi que se analiza que es*/
                if (table.isReserverWord(lexema)) {
                    objCode += table.getToken(lexema) + currentChar;
                } else {
                    switch (Automatas.getType(lexema)) {
                        case Automatas.TYPE_COMMENT:
                            break;
                        case Automatas.TYPE_STRING:
                            break;
                        case Automatas.TYPE_ID:
                            break;
                        default:
                            objCode += table.getToken(lexema) + currentChar;
                            break;
                    }
                }

                lexema = "";
            } else {
                lexema += currentChar;
            }
        }
        return objCode + lexema;
    }
}
