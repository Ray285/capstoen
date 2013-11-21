package com.wayne.edu;


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

import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/edu")
public class HomeController {

    @Autowired
    public SystemDAO systemDAO;

    @Autowired private SessionFactory sessionFactory;

    @RequestMapping(value = "/hibernate", method = RequestMethod.GET)
    public String list(Model model) {
        List<System> systems = systemDAO.findAllSystemswithReleases();

        model.addAttribute("systems", systems);
//        List<System> systemsWithReleases = systemDAO.findAllWithReleases();
//        model.addAttribute("systemsWithReleases", systemsWithReleases);
        return "hibernate";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home() {
	   return "home";
	}
	   
	@RequestMapping(value = "/addSystem", method = RequestMethod.GET)
	public ModelAndView system() {
	   return new ModelAndView("addSystems", "command", new System());
	}
	
	@RequestMapping(value = "/addRelease", method = RequestMethod.GET)
	public ModelAndView release() {
	   return new ModelAndView("addRelease", "command", new Release());
	}
	
	@RequestMapping(value = "/addReport", method = RequestMethod.GET)
	public ModelAndView report() {
	   return new ModelAndView("addReport", "command", new Report());
	}
	
	@RequestMapping(value = "/addRevision", method = RequestMethod.GET)
	public ModelAndView revision() {
	   return new ModelAndView("addRevision", "command", new Revision());
	}

    @RequestMapping(value = "/addChanges", method = RequestMethod.GET)
    public ModelAndView changes() {
        return new ModelAndView("addChanges", "command", new Changes());
    }

    @RequestMapping(value = "/addFile", method = RequestMethod.GET)
    public ModelAndView file() {
        return new ModelAndView("addFile", "command", new File());
    }
	
	@RequestMapping(value = "/showRevision", method = RequestMethod.POST)
	public String addRevision(@ModelAttribute("revision")Revision revision, 
			ModelMap model) {
				
				model.addAttribute("name", revision.getName());
				model.addAttribute("id", revision.getvcsid());
				model.addAttribute("comment", revision.getComment());
			    return "showRevisions";
	}
	
	@RequestMapping(value = "/showReports", method = RequestMethod.POST)
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
	@RequestMapping(value = "/showSystems", method = RequestMethod.POST)
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

	@RequestMapping(value = "/showSystems", method = RequestMethod.GET)
	public String showSystems(Model models) {

        List<System> systems = systemDAO.findAllSystems();

        models.addAttribute("systems", systems);

        return "showSystems";
	}
			
	  
}
