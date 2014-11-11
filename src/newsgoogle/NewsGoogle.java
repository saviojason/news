/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsgoogle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author jsdso1
 */
public class NewsGoogle {

    public static void main(String[] args) {
//            throws Exception {
//        URL url = new URL("http://www.news.google.com");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//        BufferedWriter writer = new BufferedWriter(new FileWriter("googlenewsdata.html"));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//            writer.write(line);
//            writer.newLine();
//        }
//        reader.close();
//        writer.close();
        NewsGoogle ui = new NewsGoogle();
        try {
            ui.getCathloic();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ui.getGoogleNews();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void getCathloic() throws Exception {

        URL url = new URL("http://onlineministries.creighton.edu/CollaborativeMinistry/111314.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("catholicnews.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    public void getGoogleNews() throws Exception {
        URL url = new URL("http://news.google.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("googlenews.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

}
