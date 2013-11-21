package com.wayne.edu.entities;

import javax.persistence.*;

@Entity
@Table(name = "versions")
public class Release {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne()
    @JoinColumn( name = "system_id", referencedColumnName = "id")
    private System systemvar;

    /**********************************************************************/

    public Release(String releasename) {
        this.name = releasename;
    }

    public Release(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public System getSystem() {
		return systemvar;
	}

	public void setSystem(System system) {
		this.systemvar = system;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
