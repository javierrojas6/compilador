package compilador.models.compiler.lexicanalyzer;

public class Automatas {

    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_ID = 3;
    private static boolean stringBegin;

    public static boolean isId(String lexema) {
        boolean estadoAcepta = false;
        char estado = 'A';

        boolean error = false;
        for (int i = 0; i < lexema.length(); i++) {
            switch (estado) {
                case 'A':
                    if (Character.isLetter(lexema.charAt(i))) {
                        estado = 'B';
                    } else {
                        error = true;
                    }
                    break;
                case 'B':
                case 'D':
                case 'E':
                    estadoAcepta = true;
                    if (Character.isLetter(lexema.charAt(i))) {
                        estado = 'D';
                    } else if (Character.isDigit(lexema.charAt(i))) {
                        estado = 'E';
                    } else {
                        error = true;
                    }
                    break;
            }
        }

        return !error;
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
                case '\n':
                    result = true;
            }
        }
        return result;
    }

    static int getType(String lexema) {
        if (Automatas.isId(lexema)) {
            return Automatas.TYPE_ID;
        }
        return -1;
    }
}
