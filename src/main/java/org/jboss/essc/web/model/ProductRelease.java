package org.jboss.essc.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *  Information about product.
 * 
 *  Status
 *  Links to staged and released binaries
 *  Links to staged and released docs
 *  Links maven-local-repo and other goodies
 *  Links to verification job runs
 *  Links to Jira - bugs resolved/found in this release, bugs with release notes...
 *  Links to MEAD build
 *  Links to git repos
 *  Basic metadata, like git hash from which the build originated,
 * 
 *  @author Ondrej Zizka
 */
@SuppressWarnings("serial")
@Entity
public class ProductRelease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(unique=true)
    private ProductLine line;
    private String version;
    
    @Temporal(TemporalType.DATE)
    private Date plannedFor;
    
    private Status status;
    
    private String note;
    private String gitHash;

    /** For combined builds like AS in EAP. */
    private ProductRelease parent;
    
    
    // Files links
    private String linkReleasedBinaries;
    private String linkReleasedDocs;
    private String linkStagedBinaries;
    private String linkStagedDocs;
    private String linkMavenLocalRepo;
    
    // Info links
    private String linkJiraResolvedInThisVersion;
    private String linkJiraFixedInThisVersion;
    
    // Build links
    private String linkMead;
    private String linkBrew;
    private String linkGitRepo;
    

    
    
    public ProductRelease() {
    }

    public ProductRelease(Long id, ProductLine line, String version) {
        this.id = id;
        this.line = line;
        this.version = version;
    }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Get/set">
    public String getGitHash() {        return gitHash;    }
    public void setGitHash(String gitHash) {        this.gitHash = gitHash;    }
    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }
    public String getLinkBrew() {        return linkBrew;    }
    public void setLinkBrew(String linkBrew) {        this.linkBrew = linkBrew;    }
    public String getLinkGitRepo() {        return linkGitRepo;    }
    public void setLinkGitRepo(String linkGitRepo) {        this.linkGitRepo = linkGitRepo;    }
    public String getLinkJiraFixedInThisVersion() {        return linkJiraFixedInThisVersion;    }
    public void setLinkJiraFixedInThisVersion(String linkJiraFixedInThisVersion) {        this.linkJiraFixedInThisVersion = linkJiraFixedInThisVersion;    }
    public String getLinkJiraResolvedInThisVersion() {        return linkJiraResolvedInThisVersion;    }
    public void setLinkJiraResolvedInThisVersion(String linkJiraResolvedInThisVersion) {        this.linkJiraResolvedInThisVersion = linkJiraResolvedInThisVersion;    }
    public String getLinkMavenLocalRepo() {        return linkMavenLocalRepo;    }
    public void setLinkMavenLocalRepo(String linkMavenLocalRepo) {        this.linkMavenLocalRepo = linkMavenLocalRepo;    }
    public String getLinkMead() {        return linkMead;    }
    public void setLinkMead(String linkMead) {        this.linkMead = linkMead;    }
    public String getLinkReleasedBinaries() {        return linkReleasedBinaries;    }
    public void setLinkReleasedBinaries(String linkReleasedBinaries) {        this.linkReleasedBinaries = linkReleasedBinaries;    }
    public String getLinkReleasedDocs() {        return linkReleasedDocs;    }
    public void setLinkReleasedDocs(String linkReleasedDocs) {        this.linkReleasedDocs = linkReleasedDocs;    }
    public String getLinkStagedBinaries() {        return linkStagedBinaries;    }
    public void setLinkStagedBinaries(String linkStagedBinaries) {        this.linkStagedBinaries = linkStagedBinaries;    }
    public String getLinkStagedDocs() {        return linkStagedDocs;    }
    public void setLinkStagedDocs(String linkStagedDocs) {        this.linkStagedDocs = linkStagedDocs;    }
    public String getNote() {        return note;    }
    public void setNote(String note) {        this.note = note;    }
    public ProductRelease getParent() {        return parent;    }
    public void setParent(ProductRelease parent) {        this.parent = parent;    }
    public Status getStatus() {        return status;    }
    public void setStatus(Status status) {        this.status = status;    }
    //</editor-fold>


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((line == null) ? 0 : line.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)  return true;
        if (obj == null)  return false;
        if (getClass() != obj.getClass())  return false;
        ProductRelease other = (ProductRelease) obj;
        
        if (line == null) {
            if (other.line != null) return false;
        }
        else if (!line.equals(other.line)) return false;
        
        if (version == null) {
            if (other.version != null) return false;
        }
        else if (!version.equals(other.version)) return false;
        
        return true;
    }
    
    
    public enum Status {
        PLANNED,
        IN_PROGRESS,
        RELEASED
    }
    
}