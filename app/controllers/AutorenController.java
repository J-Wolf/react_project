package controllers;

import javax.inject.Inject;
import models.Autor;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AutorenController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    public FormFactory formFactory;

    public Result show() {
        List<Autor> autorenList = Autor.find.all();
        return ok(views.html.autoren.render(autorenList));
    }

    public Result create(){
        Form<Autor> autorForm = formFactory.form(Autor.class);
        Autor autor = autorForm.bindFromRequest().get();
        autor.save();
        return  redirect(routes.AutorenController.show());
    }

}
