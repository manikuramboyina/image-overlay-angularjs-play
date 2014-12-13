package controllers;

import models.Image;
import play.*;
import play.mvc.*;

import views.html.*;

import java.io.File;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result imageOverlay() {
        return ok(imageoverlay.render("Image overlay"));
    }

    public static Result uploadImage() {
        return ok(imageUpload.render());
    }

    public static Result upload() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart image = body.getFile("image");
        if (image != null) {
            String fileName = image.getFilename();
            String contentType = image.getContentType();
            File file = image.getFile();
            Image img = new Image();
            img.path = "images/";
            img.name = "FloorPlan";
            img.id = Integer.toUnsignedLong(20);
            img.save();
            return ok(imageoverlay.render("image uploaded successfully"));
        } else {
            flash("error", "Missing file");
            return redirect(routes.Application.uploadImage());
        }
    }
}
