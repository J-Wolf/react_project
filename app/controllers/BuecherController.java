package controllers;

        import javax.inject.Inject;

        import models.Autor;
        import models.Buch;
        import play.data.Form;
        import play.data.FormFactory;
        import play.mvc.*;

        import java.util.List;
/**
 * Created by Julian on 27.07.2017.
 */
public class BuecherController extends Controller {

    @Inject
    public FormFactory formFactory;

    public Result show() {
        List<Buch> buecherList = Buch.find.all();
        return ok(views.html.buecher.render(buecherList));
    }

    public Result create(){
        Form<Buch> buchForm = formFactory.form(Buch.class);
        Buch buch = buchForm.bindFromRequest().get();
        buch.setAutor((Autor.find.byId(Long.parseLong(buch.getTmpAutor()))));
        buch.save();
        return  redirect(routes.BuecherController.show());
    }


}
