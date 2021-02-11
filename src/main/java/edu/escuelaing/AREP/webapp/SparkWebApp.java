package edu.escuelaing.AREP.webapp;

import edu.escuelaing.AREP.app.Calculator;
import edu.escuelaing.AREP.app.LinkedListImplementation;
import edu.escuelaing.AREP.app.Node;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.Collections;
import java.util.List;

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
        get("/input", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     * <p>
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set

    }

    private static String inputDataPage(Request req, Response res) {
        String page ="<!DOCTYPE html>"
                + "<html>"
                + "<center>"
                + "<body>"
                + "<h1>Calculadora basica</h1>"
                + "<form action=\"/results\">"
                + "<h2> ponga los numeros, separados por comas (,)</h2> <br>"
                + "  <input type=\"text\" name=\"numbers\" size=50 >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calculate\" formaction=\"/results\">"
                + "</form>"
                + "</body>"
                + "</center>"
                + "</html>";

        return  page;
    }



    private static String resultsPage(Request req, Response res) {
        LinkedListImplementation<Double> listaNumeros=new LinkedListImplementation<>();
        String[] listaNormal= req.queryParams("numbers").split(",");
        String pageContent;

        for (String i: listaNormal){
            try {
                listaNumeros.insert(Double.parseDouble(i));
            }
            catch (NumberFormatException n){
                pageContent
                        = "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + "<h2>El formato de ingreso de los numeros no es el correcto</h2>"
                        + "</body>"
                        + "</html>";
            }

        }

        Double media = Calculator.calculateMedia((List<Double>) listaNumeros);
        Double desviacionEstandar = Calculator.calcularDesviacion((List<Double>) listaNumeros);

        pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h3>Media: "+media+"</h3>"
                + "<h3>Desviacion Estandar: "+desviacionEstandar+"</h3>"
                + "</body>"
                + "</html>";

        return pageContent;
    }
}


