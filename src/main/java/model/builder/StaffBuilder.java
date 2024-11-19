//package model.builder;
//
//import java.util.Date;
//import model.Staff;
//
//public class StaffBuilder {
//   
//    private String worktype;
//    private Date startWorkDate;
//    private Date endWorkDate;
//
//    public StaffBuilder() {
//    }
//
//    public StaffBuilder withWorktype(String worktype) {
//        this.worktype = worktype;
//        return this;
//    }
//
//    public StaffBuilder withStartWorkDate(Date startWorkDate) {
//        this.startWorkDate = startWorkDate;
//        return this;
//    }
//
//    public StaffBuilder withEndWorkDate(Date endWorkDate) {
//        this.endWorkDate = endWorkDate;
//        return this;
//    }
//
//    public String getWorktype() {
//        return worktype;
//    }
//
//    public Date getStartWorkDate() {
//        return startWorkDate;
//    }
//
//    public Date getEndWorkDate() {
//        return endWorkDate;
//    }
//
//    public Staff build() {
//        return new Staff(this);
//    }
//}
