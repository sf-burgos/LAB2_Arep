package edu.escuelaing.AREP.webapp;

import edu.escuelaing.AREP.app.Calculator;
import edu.escuelaing.AREP.app.LinkedListImplementation;
import edu.escuelaing.AREP.app.Node;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

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
        get("/input", (req, res) -> inputPage(req, res));
        get("/results", (req, res) -> outputPage(req, res));
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
    private static String inputPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculo de la media y la desviacion estandar</h2>"
                + "<form action=\"/results\">"
                + "  Ingrese los numeros que desee que sean procesados, separados por comas <br>"
                + "  <input type=\"text\" name=\"numbers\" >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>Si da click en el boton \"Submit\", se enviaran los datos a un pagina llamada \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String outputPage(Request req, Response res) {

        LinkedListImplementation<Double> listaNumeros=new LinkedListImplementation<Double>();
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