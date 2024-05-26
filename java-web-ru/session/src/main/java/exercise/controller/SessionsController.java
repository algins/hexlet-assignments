package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;

import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var name = ctx.sessionAttribute("name");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptedPassword = encrypt(password);
        var user = UsersRepository.findByName(name);
        var userExists = UsersRepository.existsByName(name);

        if (!userExists || !user.getPassword().equals(encryptedPassword)) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else {
            ctx.sessionAttribute("name", name);
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
