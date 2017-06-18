package compilador.models.compiler.lexicanalyzer;

public class Automatas {

    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_ID = 3;
    private static boolean stringBegin;

    public static boolean isId(String text) {
        return false;
    }

    public static boolean isComment(String text) {
        return false;
    }

    public static boolean isNumeric(String text) {
        return false;
    }

    public static boolean isInteger(String text) {
        return false;
    }

    public static boolean isReal(String text) {
        return false;
    }

    public static boolean isSeparatorCharacter(char letter) {
        boolean result = false;
        if (letter == '"') {
            stringBegin = !stringBegin;
        }
        if (!stringBegin) {
            switch (letter) {
                case ',':
                case '(':
                case '{':
                case '+':
                case '-':
                case '*':
                case '/':
                case '=':
                case ' ':
                case ';':
                case ')':
                case '}':
                    result = true;
            }
        }
        return result;
    }

    static int getType(String lexema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
