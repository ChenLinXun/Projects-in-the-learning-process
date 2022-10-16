package DbCurriculumDesign.LaboratoryEquipmentManagement.model;



public class DeviceFix {

    private String id;            //设备名
    private String fix_date;         //报修时间
    private  String fix_factory;   //修理厂家
    private  String fix_money;     //修理费用
    private String dutyer;     //责任人

    public DeviceFix() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "\nDeviceFix{" +
                "id='" + id + '\'' +
                ", fix_date='" + fix_date + '\'' +
                ", fix_factory='" + fix_factory + '\'' +
                ", fix_money='" + fix_money + '\'' +
                ", dutyer='" + dutyer + '\'' +
                '}';
    }
}
