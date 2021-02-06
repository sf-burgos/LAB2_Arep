package edu.escuelaing.AREP.webapp;

import edu.escuelaing.AREP.app.LinkedListImplementation;
import edu.escuelaing.AREP.app.Node;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;
public class SparkWebApp {

    private static String Mean;

    /**
     * This main method uses SparkWeb static methods and lambda functions to create
     * a App that calculate the mean and estandar deviation of a number list entered
     * by a field on the web page
     */
    public static void main(String[] args) {
        port(getPort());
        get("/input", (req, res) -> inputPage(req, res));
        get("/output", (req, res) -> outputPage(req, res));
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }

    private static String inputPage(Request req, Response rep) {
        String page ="<!DOCTYPE html>"
                + "<html>"
                + "<center>"
                + "<body>"
                + "<h1>Calculation of the mean and standard deviation</h1>"
                + "<form action=\"/results\">"
                + "<h2> Enter the numbers you want to be processed, separated by commas</h2> <br>"
                + "  <input type=\"text\" name=\"numbers\" size=50 >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calculate\" formaction=\"/output\">"
                + "</form>"
                + "</body>"
                + "</center>"
                + "</html>";

        return  page;
    }

    private static String outputPage(Request req, Response rep) {

        String page;
        //calculateMedia SD = new calculateMedia();

        LinkedListImplementation<Node> lista = new LinkedListImplementation<>();
        String [] aux = req.queryParams("numbers").split(",");

        for (String x:aux) {
            try {
                lista.insert(Double.parseDouble(x));
            } catch (NumberFormatException n) {
                page ="<!DOCTYPE html>"
                        + "<html>"
                        + "<center>"
                        + "<body>"
                        + "<h1>Data entered incorrectly.</h1>"
                        + "<form action=\"/DataIncorrectly\">"
                        + "  <input type=\"submit\" value=\"Ok\" formaction=\"/input\">"
                        + "</form>"
                        + "</body>"
                        + "</center>"
                        + "</html>";
            }
        }

        //mean.calculateMean(lista);
        //SD.(lista);

        //double Mean = mean.getResult();
        //double sd = SD.getResult();

        page ="<!DOCTYPE html>"
                + "<html>"
                + "<center>"
                + "<body>"
                + "<h1>Results.</h1>"
                + "<h3>Mean: "+Mean+"</h3><br>"
                //+ "<h3>Standard Deviation: "+sd+"</h3><br>"
                + "<form action=\"/Ok\">"
                + "  <input type=\"submit\" value=\"Ok\" formaction=\"/input\">"
                + "</form>"
                + "</body>"
                + "</center>"
                + "</html>";
        return page;
    }
}