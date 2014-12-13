package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.sql.Blob;

/**
 * Created by Mani on 12/12/2014.
 */
@Entity
public class Image extends Model {
    @Id @GeneratedValue
    public Long id;
    public String name;
    public String path;
}

