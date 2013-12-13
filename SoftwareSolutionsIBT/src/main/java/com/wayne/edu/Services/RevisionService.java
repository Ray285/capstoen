package com.wayne.edu.Services;


import com.wayne.edu.entities.Revision;

import java.util.List;

public interface RevisionService {

    public void createRevision(Revision revision) ;
    public Revision retrieveRevision(Integer id);
    public Revision retrieveRevisionforReport(int reportId);
    public List<Revision> retrieveAllRevisions();
    public void deleteRevision(int id);
    public void updateRevision(Revision revision);

}
