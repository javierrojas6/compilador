package compilador.models.compiler.parsers;

import compilador.models.compiler.Symbol;
import compilador.models.compiler.SymbolsTable;
import java.util.ArrayList;

public class ParserSymbolsTable implements IParser {

    private String text;

    /**
     *
     * @param text
     */
    public ParserSymbolsTable(String text) {
        this.text = text;
    }

    /**
     * Get the value of text
     *
     * @return the value of text
     */
    public String getText() {
        return text;
    }

    /**
     * Set the value of text
     *
     * @param text new value of text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Object parse() throws Exception {
        text = getText();
        String[] rows = text.split("\n");
        String[] fields;
        SymbolsTable table = new SymbolsTable();
        ArrayList<Symbol> list = new ArrayList<Symbol>();
        if (rows.length > 0) {
            for (int i = 0; i < rows.length; i++) {
                fields = rows[i].split(",");
                Symbol symbol = new Symbol();
                if (fields.length == 3) {
                    symbol.setLexema(fields[0].replaceAll("\\s+", ""));
                    symbol.setTokenId(fields[1].replaceAll("\\s+", ""));
                    symbol.setReservedWord(fields[2].replaceAll("\\s+", "").compareTo("1") == 0);
                    list.add(symbol);
                }
            }
        } else {
            throw new Exception("la tabla de simbolos esta vacia");
        }
        if (list.size() < 1) {
            throw new Exception("la tabla de simbolos esta vacia");
        }
        table.setList(list);
        return table;
    }

}
