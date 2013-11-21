package com.wayne.edu.entities;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 10/30/13
 * Time: 3:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Changes {

        private File targetfile;
        private String granularity;
        private String qaulifiedname;

        public String getGranularity() {
            return granularity;
        }

        public void setGranularity(String granularity) {
            this.granularity = granularity;
        }

        public File getTargetfile() {
            return targetfile;
        }

        public void setTargetfile(File targetfile) {
            this.targetfile = targetfile;
        }

        public String getQaulifiedname() {
            return qaulifiedname;
        }

        public void setQaulifiedname(String qaulifiedname) {
            this.qaulifiedname = qaulifiedname;
        }
}








