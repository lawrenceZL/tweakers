package com.data.model;

import java.util.Date;

public class Mylt extends Entity {

    private int id;

    private String tzname;

    private Date tztime;

    private String tzlink;

    private int tzreply;

    public Mylt() {
    }

    public Mylt(String tzname, Date tztime, String tzlink, int tzreply) {
        this.tzname = tzname;
        this.tztime = tztime;
        this.tzlink = tzlink;
        this.tzreply = tzreply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTzname() {
        return tzname;
    }

    public void setTzname(String tzname) {
        this.tzname = tzname;
    }

    public Date getTztime() {
        return tztime;
    }

    public void setTztime(Date tztime) {
        this.tztime = tztime;
    }

    public String getTzlink() {
        return tzlink;
    }

    public void setTzlink(String tzlink) {
        this.tzlink = tzlink;
    }

    public int getTzreply() {
        return tzreply;
    }

    public void setTzreply(int tzreply) {
        this.tzreply = tzreply;
    }
}
