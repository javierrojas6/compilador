package compilador.controllers;

import compilador.config.Config;
import compilador.models.validators.ValidatorCodeContent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ControllerFile {

    public ControllerFile() {
    }

    /**
     *
     * @param file
     * @param validate
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public String getContent(File file, boolean validate) throws FileNotFoundException, IOException, Exception {
        StringBuilder content;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tmp = reader.readLine();
            content = new StringBuilder();
            while (tmp != null) {
                content.append(tmp).append("\n");
                tmp = reader.readLine();
            }
        }
        if (validate) {
            new ValidatorCodeContent(Config.VALIDATION_CODE, content.toString()).start();
        }
        return content.toString();
    }

    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public String getContent(File file) throws FileNotFoundException, IOException, Exception {
        return getContent(file, true);
    }

    /**
     *
     * @param content
     * @param filename
     * @return
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean saveContent(String content, String filename) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            writer.write(content);
        }
        return true;
    }
}
