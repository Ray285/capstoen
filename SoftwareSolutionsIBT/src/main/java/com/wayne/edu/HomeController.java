package com.wayne.edu;

import com.wayne.edu.Services.*;
import com.wayne.edu.entities.*;
import com.wayne.edu.entities.System;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private RevisionService revisionService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ChangeService changeService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//    @RequestMapping(value = "/getreleases", method = RequestMethod.GET)
//    public @ResponseBody List<Release> ReleasesforSystem(@RequestParam(value = "SystemId", required = true) int Systemid) {
//        logger.debug("finding cities for state " + Systemid);
//        return this.releaseService.retrieveAllReleasesofSystem(Systemid);
//    }

    @RequestMapping(value="/getreleases" ,  method=RequestMethod.GET )
    public String getReleaseSubView(@RequestParam(value = "SystemId", required = true) int Systemid, Model model ) {

        logger.debug("finding releaes for system " + Systemid);
        List<Release> releases = releaseService.retrieveAllReleasesofSystem(Systemid);
        logger.debug("found this releaes for system: " + releases.get(0).getName());
        model.addAttribute( "releases", releases );
        return "releasesv";
    }

    @RequestMapping(value="/getreports" ,  method=RequestMethod.GET )
    public String getReportSubView(@RequestParam(value = "ReleaseId", required = true) int Releaseid, Model model ) {

        logger.debug("finding reports for release " + Releaseid);
        List<Report> reports = reportService.retrieveAllReportsforRelease(Releaseid);
        logger.debug("found this report for the specified release: " + reports.get(0).getTitle());
        model.addAttribute( "reports", reports );
        return "reportsv";
    }

    @RequestMapping(value="/getrevisions" ,  method=RequestMethod.GET )
    public String getRevisionSubView(@RequestParam(value = "ReportId", required = true) int Reportid, Model model ) {

        logger.debug("finding corresponding revision for specified report " + Reportid);
        Revision revision = revisionService.retrieveRevisionforReport(Reportid);
        logger.debug("found this revision for the specified report: " + revision.getName());
        model.addAttribute( "revision", revision );
        return "revisionsv";
    }

    @RequestMapping(value="/gettargetfiles" ,  method=RequestMethod.GET )
    public String getFileSubView(@RequestParam(value = "RevisionId", required = true) int Revisionid, Model model ) {

        logger.debug("finding corresponding files for specified revision " + Revisionid);
        List<File> files = fileService.retrieveAllFilesforRelease(Revisionid);
        logger.debug("found this file for the specified revision: " + files.get(0).getName());
        model.addAttribute( "files", files );
        return "filesv";
    }



    @RequestMapping(value = "home", method = RequestMethod.GET)
	public  ModelAndView home(HttpServletRequest request) {

        logger.debug("returning home page");

        ModelAndView mv = new ModelAndView("home");

        String userName = "Guest"; // Any default user  name
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            userName = principal.getName();
        }

        mv.addObject("username", userName);
        mv.addObject("message" ,"Welcome");
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

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {

        return "accessDenied"; // logical view name
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

    @RequestMapping(value = "/addSystem", method = RequestMethod.GET)
    public ModelAndView system() {
        return new ModelAndView("addSystems", "command", new System());
    }

    @RequestMapping(value = "/showSystems", method = RequestMethod.POST)
    public String addSystem(@ModelAttribute("system")System system,Model model) {

        systemService.createSystem(system);//create system
        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);
        return "showSystems";
    }

    @RequestMapping(value = "/showSystems", method = RequestMethod.GET)
    public String showSystems(Model model) {

        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);
        return "showSystems";
    }

    @RequestMapping(value = "/addRelease", method = RequestMethod.GET)
    public String release(Model model) {
        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);
        model.addAttribute("release", new Release());

        return "addRelease";
    }


    @RequestMapping(value = "/showReleases", method = RequestMethod.POST)
    public String addReleases(@RequestParam("id") int sysId, @ModelAttribute("release")Release release, Model model) {

        System sys = systemService.retrieveSystem(sysId);
        release.setSystem(sys);
        releaseService.createRelease(release);
        List<Release> releases = releaseService.retrieveAllReleases();
        model.addAttribute("releases", releases);
        return "showReleases";

    }

    @RequestMapping(value = "/showReleases", method = RequestMethod.GET)
    public String showReleases(@ModelAttribute("release")Release release, Model model) {

        List<Release> releases = releaseService.retrieveAllReleases();
        model.addAttribute("releases", releases);
        return "showReleases";
    }

    @RequestMapping(value = "/addRevision", method = RequestMethod.GET)
    public String revision(Model model) {
        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);
        model.addAttribute("revision", new Revision());

        return "addRevision";
    }

    @RequestMapping(value = "/showRevisions", method = RequestMethod.POST)
    public String addRevision(@RequestParam("reportid") int reportId, @ModelAttribute("revision")Revision revision, Model model) {

        Report report = reportService.retrieveReport(reportId);
        revision.setReport(report);
        revisionService.createRevision(revision);

        List<Revision> revisions = revisionService.retrieveAllRevisions();
        model.addAttribute("revisions", revisions);

        return "showRevisions";
    }

    @RequestMapping(value="/showRevisions", method = RequestMethod.GET)
    public String showRevisions(@ModelAttribute("revision") Revision revision, Model model){
        List<Revision> revisions = revisionService.retrieveAllRevisions();
        model.addAttribute("revisions", revisions );
        return "showRevisions";
    }

    @RequestMapping(value = "/addReport", method = RequestMethod.GET)
    public String report(Model model) {

        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);


        model.addAttribute("report", new Report());

        return "addReport";
    }

    @RequestMapping(value = "/showReports", method = RequestMethod.POST)
    public String addReport(@RequestParam("releaseid") int releaseId, @ModelAttribute("report")Report report, Model model) {

        logger.debug("finding releae " + releaseId);
        Release rel = releaseService.retrieveRelease(releaseId);
        report.setRelease(rel);
        reportService.createReport(report);

        List<Report> reports = reportService.retrieveAllReports();
        model.addAttribute("reports", reports);

        return "showReports";
    }

    @RequestMapping(value="/showReports", method = RequestMethod.GET)
    public String showReports(@ModelAttribute("report") Report report, Model model){
        List<Report> reports = reportService.retrieveAllReports();
        model.addAttribute("reports", reports );
        return "showReports";
    }

    @RequestMapping(value="/showTargetChanges", method = RequestMethod.GET)
    public String showChangess(@ModelAttribute("change") Changes change, Model model){
        List<Changes> changes = changeService.retrieveAllChanges();
        model.addAttribute("changes", changes );

        return "showTargetChanges";
    }

    @RequestMapping(value = "/showTargetChanges", method = RequestMethod.POST)
    public String addTargetChange(@RequestParam("fileId") int fileId, @ModelAttribute("change")Changes change, Model model) {

        File file = fileService.retrieveFile(fileId);
        change.setTargetfile(file);

        changeService.createChange(change);

        List<Changes> changes = changeService.retrieveAllChanges();
        model.addAttribute("changes", changes);

        return "showTargetChanges";
    }

    @RequestMapping(value = "/addChanges", method = RequestMethod.GET)
    public String change(Model model) {

        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);

        model.addAttribute("change", new Changes());

        return "addChanges";
    }

    @RequestMapping(value="/showTargetFile", method = RequestMethod.GET)
    public String showFiles(Model model){
        List<File> targetfiles = fileService.retrieveAllFiles();
        model.addAttribute("files", targetfiles );

        return "showTargetFile";
    }

    @RequestMapping(value = "/showTargetFile", method = RequestMethod.POST)
    public String addFiles(@RequestParam("revisionid") int revId, @ModelAttribute("Targetfile") File file, Model model) {

        Revision rev = revisionService.retrieveRevision(revId);
        file.setRevision(rev);

        fileService.createFile(file);

        List<File> targetfiles = fileService.retrieveAllFiles();
        model.addAttribute("files", targetfiles );

        return "showTargetFile";
    }

    @RequestMapping(value = "/addFile", method = RequestMethod.GET)
    public String file(Model model) {

        List<System> systems = systemService.retrieveAllSystems();
        model.addAttribute("systems", systems);

        model.addAttribute("Targetfile", new File());

        return "addFile";
    }






}
