/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Retrieves news from various preferred sources Thank you Java
 *
 * @author jsdso1
 */
public class News {

    //format todays date mmddyyyy
    static String date;// with 0's
    static String daten0; // date without 0's

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

        setDate();

        News ui = new News();
        try {
            ui.getCathloicRef();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ui.getGoogleNews();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ui.getWeatherMelb();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ui.getCatholicReading();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ui.getSaintOfDay();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            ui.getCNA();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Set date in different formats
     *
     * @return
     */
    public static String setDate() {
        Date date1 = new Date();

        // display formatted date
        //System.out.printf("%s%tm%<td%<ty", "", date1);
        String result = String.format("%s%tm%<td%<ty", "", date1);
        date = result;
        System.out.println(date);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        result = ft.format(dNow);
        daten0 = result;
        System.out.println(daten0);
        return date;
    }

    /**
     * Daily Catholic Reflection
     *
     * @throws Exception
     */
    public void getCathloicRef() throws Exception {

        URL url = new URL("http://onlineministries.creighton.edu/CollaborativeMinistry/" + date + ".html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("catholic-reflection.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    /**
     * Daily Catholic readings
     *
     * @throws Exception
     */
    public void getCatholicReading() throws Exception {
        URL url = new URL("http://www.usccb.org/bible/readings/" + date + ".cfm");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("catholic-readings.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    /**
     * Get Google News
     *
     * @throws Exception
     */
    public void getGoogleNews() throws Exception {
        URL url = new URL("http://news.google.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("googlenews.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    /**
     * Weather Service
     *
     * @throws Exception
     */
    public void getWeatherMelb() throws Exception {
        URL url = new URL("http://www.bom.gov.au/vic/forecasts/melbourne.shtml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("melbweather.shtml"));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    /**
     * Saint of the day
     */
    public void getSaintOfDay() throws Exception {
        URL url = new URL("http://www.americancatholic.org/features/saints/ByDate.aspx?soddate=" + daten0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("sod.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    /**
     * Catholic News Agency
     */
//    public void getCNA() throws Exception {
//        URL url = new URL("http://www.catholicnewsagency.com/headlines/asia_pacific/");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//        BufferedWriter writer = new BufferedWriter(new FileWriter("cna.html"));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            //System.out.println(line);
//            writer.write(line);
//            writer.newLine();
//        }
//        reader.close();
//        writer.close();
//    }
    public void getCNA()
    {
        Wget ci = new Wget();
        ci.executeCommand("wget", true, " http://www.catholicnewsagency.com/headlines/asia_pacific/");
        
    }
    
}
