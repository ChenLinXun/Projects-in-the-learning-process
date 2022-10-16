package DbCurriculumDesign.LaboratoryEquipmentManagement.model;

public class DeviceScrap {

    private String id;          //设备名称
    private String type;       //设备类型
    private  String model;     //设备型号

    private String date;        //入库日期
    private String scrap_date;      //报废日期


    public DeviceScrap() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getScrap_date() {
        return scrap_date;
    }

    public void setScrap_date(String scrap_date) {
        this.scrap_date = scrap_date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\nDeviceScrap{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", date='" + date + '\'' +
                ", scrap_date='" + scrap_date + '\'' +
                '}';
    }

}
