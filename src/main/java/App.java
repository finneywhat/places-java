import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("places", request.session().attribute("places"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/place", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Place> places = request.session().attribute("places");
      if (places == null) {
        places = new ArrayList<Place>();
        request.session().attribute("places", places);
      }

      Place newPlace = new Place(request.queryParams("place"));
      places.add(newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
