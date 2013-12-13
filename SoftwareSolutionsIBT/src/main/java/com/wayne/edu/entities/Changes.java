package com.wayne.edu.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 10/30/13
 * Time: 3:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "targetchange")
public class Changes {

    @Id
    @GeneratedValue
    private int id;

    private String granularity;
    private String qualifiedname;
    private String type;

    @ManyToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File targetfile;

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public File getTargetfile() {
        return targetfile;
    }

    public void setTargetfile(File targetfile) {
        this.targetfile = targetfile;
    }

    public String getQualifiedname() {
        return qualifiedname;
    }

    public void setQualifiedname(String qualifiedname) {
        this.qualifiedname = qualifiedname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}








