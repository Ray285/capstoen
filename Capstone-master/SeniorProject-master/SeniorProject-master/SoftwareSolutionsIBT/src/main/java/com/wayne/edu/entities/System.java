package com.wayne.edu.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "system")
public class System {

    @Id @GeneratedValue private long id;
    private String name;
	private String issueTrackerUrl;
	private String programmingLang;
	private String versionControlUrl;

    @OneToMany(mappedBy = "systemvar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Release> releases;

    /**********************************************************************/

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(long id) {
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
//    @OneToMany(mappedBy = "system", fetch = FetchType.EAGER)
    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}
