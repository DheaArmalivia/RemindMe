package id.sch.smktelkom_mlg.project.xirpl609182736.remindme.model;

import java.io.Serializable;

/**
 * Created by Smktelkom on 20/11/2016.
 */
public class Alarm implements Serializable {
    public String judul;
    public String desk;
    public String hari;
    public String waktu;

    public Alarm(String judul, String desk, String hari, String waktu) {
        this.judul = judul;
        this.desk = desk;
        this.hari = hari;
        this.waktu = waktu;
    }
}
