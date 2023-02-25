package com.github.yck.pattern.factory.improve.absfactory;

import com.github.yck.pattern.factory.cmdUtil;
import com.github.yck.pattern.factory.improve.absfactory.factory.AbstractFactory;
import com.github.yck.pattern.factory.improve.absfactory.pizzas.Pizza;
import com.github.yck.principle.openClosed.OpenClosed1;

import java.util.Optional;

public class OrderPizza {
    private AbstractFactory fs;

    public OrderPizza(AbstractFactory fs) {
        this.fs = fs;
        orderPizza(cmdUtil.getCmdInput("请选择口味："));
    }

    /**
     * 这里不同于方法工厂，制作pizza的过程 放在了 OrderPizza
     *
     * @param type
     */
    public void orderPizza(String type){
        Pizza pizza = fs.createPizza(type);
        Optional.ofNullable(pizza)
                .ifPresent(
                        o -> {
                            o.prepare();o.bake();o.cut();o.box();
                        }
                );
    }
}
