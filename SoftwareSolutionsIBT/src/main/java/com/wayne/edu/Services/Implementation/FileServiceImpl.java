package com.wayne.edu.Services.Implementation;

import com.wayne.edu.DAO.FileDAO;
import com.wayne.edu.Services.FileService;
import com.wayne.edu.entities.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDAO fileDAO;


    public void createFile(File file){
        this.fileDAO.persistOrMerge(file);
    }


    public File retrieveFile(int id){
        return this.fileDAO.findById(id);
    }

    public List<File> retrieveAllFiles(){
        return this.fileDAO.findAll();
    }
    public List<File> retrieveAllFilesforRelease(int revisionId){
        return this.fileDAO.findAllByRevision(revisionId);
    }

    public void updateFile(File file){
        this.fileDAO.edit(file);
    }

    public void deleteFile(int id){
        this.fileDAO.Delete(id);
    }
}
