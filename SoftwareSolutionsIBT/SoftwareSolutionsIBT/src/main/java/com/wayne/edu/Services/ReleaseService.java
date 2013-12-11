package com.wayne.edu.Services;

import com.wayne.edu.entities.Release;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RaymondII
 * Date: 12/3/13
 * Time: 8:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ReleaseService {

    public void createRelease(Release release);
    public Release retrieveRelease(int id);
    public List<Release> retrieveAllReleases();
    public void updateRelease(Release release);
    public void deleteRelease(int id);

}
