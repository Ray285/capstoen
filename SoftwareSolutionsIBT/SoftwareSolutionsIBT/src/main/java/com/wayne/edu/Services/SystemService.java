package com.wayne.edu.Services;

/**
 * Created with IntelliJ IDEA.
 * User: RaymondII
 * Date: 11/28/13
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */

import com.wayne.edu.entities.System;

import java.util.List;

public interface SystemService {

    public void createSystem(System system);
    public System retrieveSystem(int id);
    public List<System> retrieveAllSystems();
    public void updateSystem(System system);
    public void deleteSystem(int id);

}
