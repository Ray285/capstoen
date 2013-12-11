package com.wayne.edu.Services.Implementation;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11/7/13
 * Time: 5:10 AM
 * To change this template use File | Settings | File Templates.
 */
import com.wayne.edu.Services.RoleService;
import com.wayne.edu.entities.Role;
import com.wayne.edu.DAO.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}
