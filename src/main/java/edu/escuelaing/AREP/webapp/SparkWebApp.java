package edu.escuelaing.AREP.webapp;
import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello Heroku");
    }
}