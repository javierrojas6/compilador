package compilador.models.compiler.lexicanalyzer;

import java.util.regex.Pattern;

public class Automatas {

    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_ID = 3;
    public static final int TYPE_REAL = 4;
    private static boolean stringBegin;

    public static boolean isId(String lexema) {
        boolean estadoAcepta = false;
        char estado = 'A';

        for (int i = 0; i < lexema.length(); i++) {
            switch (estado) {
                case 'A':
                    if (Character.isLetter(lexema.charAt(i))) {
                        estado = 'B';
                        estadoAcepta = true;
                    }
                    break;
                case 'B':
                case 'C':
                case 'D':
                    if (Character.isLetter(lexema.charAt(i))) {
                        estado = 'C';
                        estadoAcepta = true;
                    } else if (Character.isDigit(lexema.charAt(i))) {
                        estado = 'D';
                        estadoAcepta = true;
                    } else {
                        estadoAcepta = false;
                    }
                    break;
            }
        }

        return estadoAcepta;
    }

    public static boolean isComment(String text) {
        Pattern pat = Pattern.compile("/\\*(?:.|[\\n\\r])*?\\*/");
        return pat.matcher(text).matches();
    }

    public static boolean isNumeric(String text) {
        return Pattern.compile("(+|-)?\\d+").matcher(text).matches();
    }

    public static boolean isInteger(String text) {
        return Pattern.compile("(+|-)?\\d+").matcher(text).matches();
    }

    public static boolean isReal(String text) {
        return Pattern.compile("(-?\\d+(\\.\\d+)?)").matcher(text).matches();
    }

    public static boolean isString(String text) {
        return Pattern.compile("\".*\"").matcher(text).matches();
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
                case '&':
                case '|':
                    result = true;
            }
        }
        return result;
    }

    static int getType(String lexema) {
        if (Automatas.isComment(lexema)) {
            return Automatas.TYPE_COMMENT;
        } else if (Automatas.isString(lexema)) {
            return Automatas.TYPE_STRING;
        } else if (Automatas.isId(lexema)) {
            return Automatas.TYPE_ID;
        } else if (Automatas.isReal(lexema)) {
            return Automatas.TYPE_REAL;
        } else {
            return -1;
        }
    }
}
