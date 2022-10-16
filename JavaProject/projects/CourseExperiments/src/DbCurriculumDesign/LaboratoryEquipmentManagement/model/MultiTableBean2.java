package DbCurriculumDesign.LaboratoryEquipmentManagement.model;

import java.sql.Date;

//这是用来进行多表查询的，报修表和设备表映射的javaBean

public class MultiTableBean2 {

    private String fix_date;         //报修时间
    private  String fix_factory;   //修理厂家
    private  String fix_money;     //修理费用
    private String dutyer;     //负责人

    private int id;            //设备编号
    private int batch;         //入库批次
    private String type;       //设备类型
    private String name;       //设备名称
    private  String model;     //设备型号
    private  String spec;      //设备规格
    private String money;      //设备单价
    private  String num;       //设备数量
    private  String date;      //设备入库日期
    private  String factory;   //设备生产厂家
    private  String buyer;     //设备购买人
    private String crname;     //所属实验室名称

    public MultiTableBean2() {
    }

    public String getFix_date() {
        return fix_date;
    }

    public void setFix_date(String fix_date) {
        this.fix_date = fix_date;
    }

    public String getFix_factory() {
        return fix_factory;
    }

    public void setFix_factory(String fix_factory) {
        this.fix_factory = fix_factory;
    }

    public String getFix_money() {
        return fix_money;
    }

    public void setFix_money(String fix_money) {
        this.fix_money = fix_money;
    }

    public String getDutyer() {
        return dutyer;
    }

    public void setDutyer(String dutyer) {
        this.dutyer = dutyer;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "\nMultiTableBean2{" +
                "fix_date=" + fix_date +
                ", fix_factory='" + fix_factory + '\'' +
                ", fix_money='" + fix_money + '\'' +
                ", dutyer='" + dutyer + '\'' +
                ", id=" + id +
                ", batch=" + batch +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
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
