package com.feng.ioc.beanControlTest;

import com.feng.ioc.bean.Actor;

/**
 * 常规对象管理的方法
 */
public class Test01 {
    public static void main(String[] args) {

        Actor actor = new Actor();
        actor.setName("炼狱杏寿郎");
        actor.setSex("男");
        actor.setSkill("炎之呼吸");
        actor.setLevel("柱");
        System.out.println(actor);
    }

}
