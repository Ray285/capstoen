package com.wayne.edu.Services.Implementation;


import com.wayne.edu.DAO.RevisionDAO;
import com.wayne.edu.Services.RevisionService;
import com.wayne.edu.entities.Revision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RevisionServiceImpl implements RevisionService{

    @Autowired
    private RevisionDAO revisionDAO;

    public void createRevision(Revision revision){
        this.revisionDAO.persistOrMerge(revision);
    }

    public Revision retrieveRevision(Integer id){
        return this.revisionDAO.findById(id);
    }


    public List<Revision> retrieveAllRevisions(){
        return this.revisionDAO.findAll();
    }

    public void updateRevision(Revision revision){
        this.revisionDAO.edit(revision);
    }

    public void deleteRevision(int id){
        this.revisionDAO.Delete(id);
    }


}
