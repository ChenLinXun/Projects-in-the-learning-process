package OOP.polymorphic.Polymorphic_Application.Poly_Parameter;

/*多态参数的用例：
  主要看这个方法：public void testWork(Employee e)
*/

public class Test {

    public static void main(String[] args) {

        Worker chen = new Worker("陈林迅",10000);
        Manager zhang = new Manager("张三",30000,50000);
        Test test = new Test();

        test.testWork(chen);//查看工作的员工是哪个职位的
        test.showEmpAnnal(chen);//查看普通员工的年薪
        test.testWork(zhang);
        test.showEmpAnnal(zhang);
    }

    //查看在工作的是什么类型的员工的方法
    public void testWork(Employee e){//多态参数的使用

        if(e instanceof Worker){//如果父类引用指向的是Worker
            ((Worker) e).work();//向下转型操作调用特有方法
        }else if (e instanceof Manager){//如果父类引用指向的是Manager
            ((Manager) e).manage();//向下转型操作调用特有方法
        }else {
            System.out.println("不做处理");
        }

    }

    //查看任何员工年薪的方法
    public void showEmpAnnal(Employee e){
        System.out.println(e.getName()+"的年薪为："+e.getAnnual());
    }

}
