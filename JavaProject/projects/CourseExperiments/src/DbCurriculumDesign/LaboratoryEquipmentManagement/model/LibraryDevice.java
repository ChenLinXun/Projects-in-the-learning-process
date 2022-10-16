package DbCurriculumDesign.LaboratoryEquipmentManagement.model;



//这是一个库设备的javaBean
public class LibraryDevice {

    private String id;         //设备名
    private int batch;         //入库批次
    private String type;       //设备类别
    private  String model;     //设备型号
    private  String spec;      //设备规格
    private String money;      //设备单价
    private  String num;       //设备数量
    private  String date;      //设备入库日期
    private  String factory;   //设备生产厂家
    private  String buyer;     //设备购买人
    private String crname;     //所属实验室名称

    public LibraryDevice() {
    }


    //get和set方法是给反射使用的


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "\nLibraryDevice{" +
                "id='" + id + '\'' +
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
                '}';
    }
}
