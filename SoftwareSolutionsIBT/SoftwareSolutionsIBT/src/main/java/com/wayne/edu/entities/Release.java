package com.wayne.edu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "versions")
public class Release implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    private System system;

    @OneToMany(mappedBy = "release", fetch = FetchType.LAZY)
    private List<Report> reports;

    /**********************************************************************/

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
