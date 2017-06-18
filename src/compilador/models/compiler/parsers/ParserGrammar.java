package compilador.models.compiler.parsers;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class ParserGrammar implements IParser {

    private String grammarText;

    private String grammarSpecialSymbolsText;

    public ParserGrammar(String grammarFileContent, String grammarSpecialSymbolsContent) {
        setGrammarText(grammarFileContent);
        setGrammarSpecialSymbolsText(grammarSpecialSymbolsContent);
    }

    /**
     * Get the value of grammarSpecialSymbolsText
     *
     * @return the value of grammarSpecialSymbolsText
     */
    public String getGrammarSpecialSymbolsText() {
        return grammarSpecialSymbolsText;
    }

    /**
     * Set the value of grammarSpecialSymbolsText
     *
     * @param grammarSpecialSymbolsText new value of grammarSpecialSymbolsText
     */
    public void setGrammarSpecialSymbolsText(String grammarSpecialSymbolsText) {
        this.grammarSpecialSymbolsText = grammarSpecialSymbolsText;
    }

    public String getGrammarText() {
        return grammarText;
    }

    public void setGrammarText(String grammarText) {
        this.grammarText = grammarText;
    }

    @Override
    public Object parse() throws Exception {
        String[] text = getGrammarText().replaceAll(" ", "").split("\n");
        ArrayList<String>[] cadena = new ArrayList[12];
        String buffer = "", line = "";
        for (int i = 0; i < text.length; i++) {
            cadena[i] = new ArrayList<String>();
            line = text[i];
            for (int j = 0; j < line.length(); j++) {
                buffer = line.charAt(j) + "";
                if (line.charAt(j) == '-' && line.charAt(j + 1) == '>') {
                    j++;
                    buffer = "";
                }
                if (j < line.length() - 2 && line.charAt(j + 1) == '\'') {
                    cadena[i].add(buffer + "'");
                    buffer = "";
                }
                if (line.charAt(j)=='i' && line.charAt(j + 1) == 'd') {
                    cadena[i].add("id");
                    buffer = "";
                }
                if (line.charAt(j)=='n' && line.charAt(j + 1) == 'u' && line.charAt(j + 2) == 'm') {
                    cadena[i].add("num");
                    j+=2;
                    buffer = "";
                }
                if (!buffer.equals("")) {
                    cadena[i].add(buffer);
                }
            }
        }
        return null;
    }

}
