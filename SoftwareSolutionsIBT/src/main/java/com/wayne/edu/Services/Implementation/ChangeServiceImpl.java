package com.wayne.edu.Services.Implementation;

import com.wayne.edu.DAO.ChangeDAO;
import com.wayne.edu.Services.ChangeService;
import com.wayne.edu.entities.Changes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class ChangeServiceImpl implements ChangeService{

    @Autowired
    private ChangeDAO changeDAO;


    public void createChange(Changes change){
        this.changeDAO.persistOrMerge(change);
    }


    public Changes retrieveChange(int id){
        return this.changeDAO.findById(id);
    }

    public List<Changes> retrieveAllChanges(){
        return this.changeDAO.findAll();
    }

    public void updateChange(Changes change){
        this.changeDAO.edit(change);
    }

    public void deleteChange(int id){
        this.changeDAO.Delete(id);
    }
}
