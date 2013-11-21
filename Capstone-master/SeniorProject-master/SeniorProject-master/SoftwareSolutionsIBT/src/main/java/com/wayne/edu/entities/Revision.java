package com.wayne.edu.entities;

public class Revision {

    private Report report;
	private String name;
	private Integer vcsid;
	private String comment;
	
	   
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

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
