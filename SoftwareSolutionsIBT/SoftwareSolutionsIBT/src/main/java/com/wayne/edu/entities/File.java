package com.wayne.edu.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 10/31/13
 * Time: 3:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "targetfile")
public class File {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String path;

    @ManyToOne
    @JoinColumn(name = "revision_id", referencedColumnName = "id")
    private Revision revision;

    @OneToMany(mappedBy = "targetfile", fetch = FetchType.LAZY)
    private List<Changes> changes;

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

    public List<Changes> getChanges() {
        return changes;
    }

    public void setChanges(List<Changes> changes) {
        this.changes = changes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
