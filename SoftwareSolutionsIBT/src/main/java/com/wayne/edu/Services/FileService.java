package com.wayne.edu.Services;

import com.wayne.edu.entities.File;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */

public interface FileService {

    public void createFile(File file);
    public File retrieveFile(int id);
    public List<File> retrieveAllFiles();
    public List<File> retrieveAllFilesforRelease(int revisionId);
    public void updateFile(File file);
    public void deleteFile(int id);
}

