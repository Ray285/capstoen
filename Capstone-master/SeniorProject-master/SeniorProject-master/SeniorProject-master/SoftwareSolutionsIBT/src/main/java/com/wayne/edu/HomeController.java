package com.wayne.edu;

import javax.servlet.http.*;
import javax.security.auth.*;
import javax.*;
import java.security.Principal;
import javax.servlet.http.HttpServletResponse;
import com.wayne.edu.entities.*;
import com.wayne.edu.entities.System;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication.*;
import org.springframework.security.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    public SystemDAO systemDAO;

    @Autowired private SessionFactory sessionFactory;

    @RequestMapping(value = "hibernate", method = RequestMethod.GET)
    public String list(Model model) {
        List<System> systems = systemDAO.findAllSystemswithReleases();

        model.addAttribute("systems", systems);
//        List<System> systemsWithReleases = systemDAO.findAllWithReleases();
//        model.addAttribute("systemsWithReleases", systemsWithReleases);
        return "hibernate";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
	public  ModelAndView home(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("home");

        String userName = "guest"; // Any default user  name
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            userName = principal.getName();
        }

        mv.addObject("username", userName);
        mv.addObject("message" ,"Welcome") ;
        // By adding a little code (same way) you can check if user has any
        // roles you need, for example:

        boolean fAdmin = request.isUserInRole("ROLE_ADMIN");
        mv.addObject("isAdmin", fAdmin);


       // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //if (!(auth instanceof AnonymousAuthenticationToken)) {
           // User user = auth.getPrincipal();
      //  }
      //  else{
          //  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
           // String name = user.getUsername();
           // model.addAttribute("username", name);
       // }

        //model.addAttribute("username", name);
        //model.addAttribute("message", "welcome");

        return mv;
	}
	   
	@RequestMapping(value = "addSystem", method = RequestMethod.GET)
	public ModelAndView system() {
	   return new ModelAndView("addSystems", "command", new System());
	}
	
	@RequestMapping(value = "addRelease", method = RequestMethod.GET)
	public ModelAndView release() {
	   return new ModelAndView("addRelease", "command", new Release());
	}
	
	@RequestMapping(value = "addReport", method = RequestMethod.GET)
	public ModelAndView report() {
	   return new ModelAndView("addReport", "command", new Report());
	}
	
	@RequestMapping(value = "addRevision", method = RequestMethod.GET)
	public ModelAndView revision() {
	   return new ModelAndView("addRevision", "command", new Revision());
	}

    @RequestMapping(value = "addChanges", method = RequestMethod.GET)
    public ModelAndView changes() {
        return new ModelAndView("addChanges", "command", new Changes());
    }

    @RequestMapping(value = "addFile", method = RequestMethod.GET)
    public ModelAndView file() {
        return new ModelAndView("addFile", "command", new File());
    }
	
	@RequestMapping(value = "showRevision", method = RequestMethod.POST)
	public String addRevision(@ModelAttribute("revision")Revision revision, 
			ModelMap model) {
				
				model.addAttribute("name", revision.getName());
				model.addAttribute("id", revision.getvcsid());
				model.addAttribute("comment", revision.getComment());
			    return "showRevisions";
	}
	
	@RequestMapping(value = "showReports", method = RequestMethod.POST)
	public String addReport(@ModelAttribute("report")Report report, 
	ModelMap model) {
		model.addAttribute("issueid", report.getIssueid());
		model.addAttribute("release", report.getRelease());//NEEDS TO BE CHANGED TO ACCEPT AN OBJECT OF A RELEASE CLASS
		model.addAttribute("title", report.getTitle());
		model.addAttribute("description", report.getDescription());
		model.addAttribute("type", report.getType());
	      
	    return "showReports";
	}
	
	/*@RequestMapping(value = "/showReleases", method = RequestMethod.GET)
	public String addRelease(@ModelAttribute("release")Release release,
	ModelMap model) {
        System test = new System();

        release.setReleasename("test");
        release.setSystem(test);

		model.addAttribute("system", release.getSystem());
		model.addAttribute("release", release.getReleasename());
	    return "showReleases";
	}*/

//    @RequestMapping(value = "/showReleases", method = RequestMethod.POST)
//	public String addRelease(@ModelAttribute("release")Release release,
//	ModelMap model) {
//        release.getSystem().setName();
//
//        release.setReleasename("test");
//        release.setSystem(test);
//
//		model.addAttribute("system", release.getSystem());
//		model.addAttribute("release", release.getReleasename());
//	    return "showReleases";
//	}
		
	
/*	@RequestMapping(value = "/showReports", method = RequestMethod.GET)
	public String showReports(@ModelAttribute("report")Report report,
	ModelMap model) {
		report.setIssueid("Issue #10");
		report.setRelease("Juno");
		report.setTitle("Minimize button is broken");
		report.setDescription("Minimize button does not ....");
		report.setType("Bug");

		model.addAttribute("issueid", report.getIssueid());
		model.addAttribute("release", report.getRelease());//NEEDS TO BE CHANGED TO ACCEPT AN OBJECT OF A RELEASE CLASS
		model.addAttribute("title", report.getTitle());
		model.addAttribute("description", report.getDescription());
		model.addAttribute("type", report.getType());

	    return "showReports";
	}
*/
	@RequestMapping(value = "showSystems", method = RequestMethod.POST)
	public String addSystem(@ModelAttribute("system")System system, Model models) {

        SessionFactory sf = sessionFactory;
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(system);

        session.getTransaction().commit();
        session.close();

        List<System> systems = systemDAO.findAllSystemswithReleases();

        models.addAttribute("systems", systems);

	    return "showSystems";
	}

	@RequestMapping(value = "showSystems", method = RequestMethod.GET)
	public String showSystems(Model models) {

        List<System> systems = systemDAO.findAllSystems();

        models.addAttribute("systems", systems);

        return "showSystems";
	}

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "login";

    }
	  
}
