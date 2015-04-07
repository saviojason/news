/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Use wget and Java to retrieve content
 *
 * @author jsd 19/3/2015
 */
public class Wget {

    
    private static String command = "";
    private static String parameter = "";
    
    public static void main(String []args)
    {
        Wget ui = new Wget(command,parameter);
        ui.executeCommand(command, true, parameter);
        
    }
    
    /**
     * wget default constructor
     */

    Wget()
    {
        
    }
    
    /***
     *  constructor
     */
    
    Wget(String cmd, String pram)
    {
        command = cmd;
        parameter = pram;
        
    }
    
    public String executeCommand(String command, boolean waitForResponse, String parameter) {

        String response = "";

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command + " " + parameter);
        pb.redirectErrorStream(true);

        System.out.println("Linux command: " + command + "" + parameter);

        try {
            Process shell = pb.start();

            if (waitForResponse) {

// To capture output from the shell
                InputStream shellIn = shell.getInputStream();

// Wait for the shell to finish and get the return code
                int shellExitStatus = shell.waitFor();
                System.out.println("Exit status" + shellExitStatus);

                response = convertStreamToStr(shellIn);

                shellIn.close();
            }

        } catch (IOException e) {
            System.out.println("Error occured while executing Linux command. Error Description: "
                    + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error occured while executing Linux command. Error Description: "
                    + e.getMessage());
        }

        return response;
    }

    /*
     * To convert the InputStream to String we use the Reader.read(char[]
     * buffer) method. We iterate until the Reader return -1 which means
     * there's no more data to read. We use the StringWriter class to
     * produce the string.
     */
    public static String convertStreamToStr(InputStream is) throws IOException {

        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
