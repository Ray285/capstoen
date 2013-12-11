package com.wayne.edu.Services.Implementation;

/**
 * Created with IntelliJ IDEA.
 * User: RaymondII
 * Date: 11/28/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */

import com.wayne.edu.Services.ReleaseService;
import com.wayne.edu.entities.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    private com.wayne.edu.DAO.ReleaseDAO ReleaseDAO;

    public void createRelease(Release release){
        this.ReleaseDAO.persistOrMerge(release);
    }


    public Release retrieveRelease(int id){
        return this.ReleaseDAO.findById(id);
    }

    public List<Release> retrieveAllReleases(){
        return this.ReleaseDAO.findAll();
    }

    public void updateRelease(Release release){
        this.ReleaseDAO.edit(release);
    }

    public void deleteRelease(int id){
        this.ReleaseDAO.Delete(id);
    }



}




