package compilador.models.validators;

public class ValidatorCodeContent implements IValidator {

    private String Code;
    private String regexp;

    public ValidatorCodeContent(String regexp, String code) throws Exception {
        setCode(code);
        setRegexp(regexp);
    }

    /**
     * Get the value of regexp
     *
     * @return the value of regexp
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Set the value of regexp
     *
     * @param regexp new value of regexp
     */
    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    /**
     * Get the value of Code
     *
     * @return the value of Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * Set the value of Code
     *
     * @param Code new value of Code
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    @Override
    public boolean start() throws Exception {
        if (getCode().matches(getRegexp())) {
            throw new Exception("Existen caracteres inaceptados en el codigo");
        }
        return true;
    }
}
