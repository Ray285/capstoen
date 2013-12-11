package com.wayne.edu.entities;

import javax.persistence.*;


@Entity
@Table(name = "report")
public class Report {

    @Id
	private int id;//issue tracker id
	private String title;
	private String description;
	private String type;


//    private Revision revision;

    @ManyToOne
    @JoinColumn(name = "release_id", referencedColumnName = "id")
    private Release release;

    public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Revision getRevision() {
//        return revision;
//    }
//
//    public void setRevision(Revision revision) {
//        this.revision = revision;
//    }

}
