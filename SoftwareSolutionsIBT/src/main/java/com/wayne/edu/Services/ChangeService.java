package com.wayne.edu.Services;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */

import com.wayne.edu.entities.Changes;

import java.util.List;

public interface ChangeService {

    public void createChange(Changes change);
    public Changes retrieveChange(int id);
    public List<Changes> retrieveAllChanges();
    public void updateChange(Changes change);
    public void deleteChange(int id);
}
