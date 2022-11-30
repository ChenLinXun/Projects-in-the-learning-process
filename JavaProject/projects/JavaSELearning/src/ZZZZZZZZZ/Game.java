package ZZZZZZZZZ;

public class Game {

    public static void main(String[] args) {
        //zs是实参，类型是引用类型，指向一个Actor对象
        Actor zs = new Actor("张三");

        //修改引用本身，因为形参是实参引用本身的拷贝，相当于两个引用指向一个对象，
        // 光改变副本引用的指向，不会影响实参引用的指向
        changeActor(zs);
        //zs仍然指向原来的对象
        System.out.println("实参zs指向："+zs.getName());

        //修改引用所指对象的值（内部属性），因为拷贝的是实参引用本身，所以指向的是同一个对象
        changeName(zs);
        //实参所指对象的值会被修改
        System.out.println("zs的值被改变为了："+zs.getName());
    }

    public static void changeActor(Actor actor){
        Actor ww = new Actor("王五");
        actor = ww;
        System.out.println("形参actor的指向：" + actor.getName());
    }
    //actor是形参
    public static void changeName(Actor actor){
        actor.setName("李四");
    }
}
class Actor {
    private String name;

    public Actor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}