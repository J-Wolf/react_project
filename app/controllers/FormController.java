package controllers;


import javax.inject.Inject;
import models.Autor;
import models.Buch;
import play.data.FormFactory;
import play.data.Form;
import play.mvc.*;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class FormController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    public FormFactory formFactory;

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result addAutor(){
        Form<Autor> autorForm = formFactory.form(Autor.class);
        return ok(views.html.addAutor.render(autorForm));
    }

    public Result addBuch(){
        Form<Buch> buchForm = formFactory.form(Buch.class);
        List<Autor> autorenList = Autor.find.all();
        return ok(views.html.addBuch.render(buchForm,autorenList));
    }
}
