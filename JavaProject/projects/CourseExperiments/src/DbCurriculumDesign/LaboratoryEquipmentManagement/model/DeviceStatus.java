package DbCurriculumDesign.LaboratoryEquipmentManagement.model;


//这是个库设备运行状态的javaBean

public class DeviceStatus {

    private String id;
    private String status;
    private String status_date;
    private String crname;


    public DeviceStatus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_date() {
        return status_date;
    }

    public void setStatus_date(String status_date) {
        this.status_date = status_date;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public DeviceStatus(String id, String status, String status_date, String crname) {
        this.id = id;
        this.status = status;
        this.status_date = status_date;
        this.crname = crname;
    }

}
