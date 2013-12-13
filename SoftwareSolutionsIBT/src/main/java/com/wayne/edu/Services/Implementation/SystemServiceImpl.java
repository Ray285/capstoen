package com.wayne.edu.Services.Implementation;

import com.wayne.edu.DAO.SystemDAO;
import com.wayne.edu.Services.SystemService;
import com.wayne.edu.entities.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RaymondII
 * Date: 11/28/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemDAO systemDAO;


    public void createSystem(System system){
        this.systemDAO.persistOrMerge(system);
    }


    public System retrieveSystem(int id){
        return this.systemDAO.findById(id);
    }

    public List<System> retrieveAllSystems(){
        return this.systemDAO.findAll();
    }

    public void updateSystem(System system){
        this.systemDAO.edit(system);
    }

    public void deleteSystem(int id){
        this.systemDAO.Delete(id);
    }
}
