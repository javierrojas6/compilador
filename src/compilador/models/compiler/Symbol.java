package compilador.models.compiler;

public class Symbol {

    private String lexema;

    private String tokenId;

    private boolean reservedWord;

    public Symbol() {
        setLexema(null);
        setTokenId(null);
        setReservedWord(false);
    }

    public Symbol(String lexema, String token, boolean isReservedWord) {
        setLexema(lexema);
        setTokenId(token);
        setReservedWord(isReservedWord);
    }

    /**
     * Get the value of reservedWord
     *
     * @return the value of reservedWord
     */
    public boolean isReservedWord() {
        return reservedWord;
    }

    /**
     * Set the value of reservedWord
     *
     * @param reservedWord new value of reservedWord
     */
    public void setReservedWord(boolean reservedWord) {
        this.reservedWord = reservedWord;
    }

    /**
     * Get the value of tokenId
     *
     * @return the value of tokenId
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * Set the value of tokenId
     *
     * @param tokenId new value of tokenId
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    /**
     * Get the value of lexema
     *
     * @return the value of lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * Set the value of lexema
     *
     * @param lexema new value of lexema
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

}
