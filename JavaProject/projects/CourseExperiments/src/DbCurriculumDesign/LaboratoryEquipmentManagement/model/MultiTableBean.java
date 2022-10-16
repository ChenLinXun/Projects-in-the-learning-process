package DbCurriculumDesign.LaboratoryEquipmentManagement.model;


//这是用来进行多表查询的，运行表和设备表映射的javaBean

public class MultiTableBean {

    private int id;            //设备名
    private int batch;         //入库批次
    private String type;       //设备类型
    private  String model;     //设备型号
    private  String spec;      //设备规格
    private String money;      //设备单价
    private  String num;       //设备数量
    private  String date;      //设备入库日期
    private  String factory;   //设备生产厂家
    private  String buyer;     //设备购买人
    private String crname;     //所属实验室名称

    private String status;     //设备运行状态
    private String status_date; //记录设备运行状态时间


    public MultiTableBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
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

    @Override
    public String toString() {
        return "\nMultiTableBean{" +
                "id=" + id +
                ", batch=" + batch +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", spec='" + spec + '\'' +
                ", money='" + money + '\'' +
                ", num='" + num + '\'' +
                ", date='" + date + '\'' +
                ", factory='" + factory + '\'' +
                ", buyer='" + buyer + '\'' +
                ", crname='" + crname + '\'' +
                ", status='" + status + '\'' +
                ", status_date='" + status_date + '\'' +
                '}';
    }
}
