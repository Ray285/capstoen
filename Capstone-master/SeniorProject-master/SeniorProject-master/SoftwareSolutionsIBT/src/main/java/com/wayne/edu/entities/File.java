package com.wayne.edu.entities;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 10/31/13
 * Time: 3:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class File {

    private Revision revision;
    private String name;
    private String path;
    private String changetype;

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getChange() {
        return changetype;
    }

    public void setChange(String changetype) {
        this.changetype = changetype;
    }
}
