package com.wayne.edu.entities;

import javax.persistence.*;

@Entity
@Table(name = "revisions")
public class Revision {

    @Id
    @GeneratedValue
    private int id;

	private String name;
	private int vcsid;
	private String comment;

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    private Report report;

    @ManyToOne
    @JoinColumn(name = "rev_system_id", referencedColumnName = "id")
    private System system;
	   
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setvcsid(Integer vcsid) {
		this.vcsid = vcsid;
	}
	
	public Integer getvcsid() {
		return vcsid;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}

//    public Report getReport() {
//        return report;
//    }
//
//    public void setReport(Report report) {
//        this.report = report;
//    }

    public int getId() {
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
}
