package com.qualapps.ka.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public PqvpError buildPqvpError(String propKey, String type, String[] params) {
        PqvpError error = new PqvpError();
        error.setCode(getErrorCode(propKey));
        error.setMessage(getErrorMessage(type, params));
        error.setType(type);
        return error;
    }

    public PqvpError buildPqvpError(PqvpException e) {
        PqvpError error = new PqvpError();
        error.setCode(getErrorCode(e.getType()));
        error.setMessage(getErrorMessage(e.getType(), e.getParams()));
        error.setType(e.getType());
        return error;
    }

    public String  getErrorCode(String propKey) {
        Properties prop = new Properties();
        String propFileName = "errorcodes.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new FileNotFoundException("Property File" + propFileName + "Not found in the classpath");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty((propKey));
    }

    public String getErrorMessage (String exceptionType, String[] messageParams) {
        String propValue = getErrorCode(exceptionType);
        String[] st = propValue.split("\\|");
        String code = st[0];
        String name = st[1];
        String message = "Error " + name + " - Code: " + code + " - " + " Message: " + st[2];
        message = String.format(message, (Object[]) messageParams);
        return message;

    }
}