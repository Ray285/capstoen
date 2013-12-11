package com.wayne.edu.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "system")
public class System implements Serializable {

    @Id @GeneratedValue private int id;
    private String name;
	private String issueTrackerUrl;
	private String programmingLang;
	private String versionControlUrl;

    @OneToMany(mappedBy = "system", fetch = FetchType.LAZY)
    private List<Release> releases;

//    @OneToMany(mappedBy = "system", fetch = FetchType.LAZY)
//    private List<Revision> revisions;


    /**********************************************************************/

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setIssueTrackerUrl(String issueTrackerUrl) {
		this.issueTrackerUrl = issueTrackerUrl;
	}
	
	public String getIssueTrackerUrl() {
		return issueTrackerUrl;
	}
	
	public void setProgrammingLang(String programmingLang) {
		this.programmingLang = programmingLang;
	}
	
	public String getProgrammingLang() {
		return programmingLang;
	}
	
	public void setversionControlUrl(String versionControlUrl) {
		this.versionControlUrl = versionControlUrl;
	}
	
	public String getversionControlUrl() {
		return versionControlUrl;
	}

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
//
//    public List<Revision> getRevisions() {
//        return revisions;
//    }
//
//    public void setRevisions(List<Revision> revisions) {
//        this.revisions = revisions;
//    }
}
