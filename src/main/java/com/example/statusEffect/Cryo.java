package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class Cryo extends Elements {

    protected Cryo(StatusEffectCategory category, int color) {
        super(category, color);
    }

    //冰元素
    public static final Cryo CRYO =new Cryo(StatusEffectCategory.NEUTRAL,0X4682B4);


    /*
    下面这个方法将在状态效果存在时每0.5s调用一次（10tick）
     */

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }

    /*
    下面是创建一个私有的速度修改器，用于实现冰元素附着时的减速效果。
        修改器数值：
            原本的总数值*0.9
     */

    private final EntityAttributeModifier CryoSpeedAttributeModifier =
            new EntityAttributeModifier("CryoSpeed",-0.1,EntityAttributeModifier.Operation.MULTIPLY_BASE);


    /*
    下面这个方法会在状态效果被施加到实体身上时被调用。并且其只会在此修改器不存在时添加（不会重复添加）
    作用：
        给予玩家一个减速，使得玩家在存在此状态时速度变为原本的0.9
     */
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributeContainer, int duration){
        super.onApplied(entity,attributeContainer,duration);


        EntityAttributeInstance speedAttributeInstance =
                entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        addAttributeModifier(speedAttributeInstance,CryoSpeedAttributeModifier);
    }//在获得状态时减速

    /*
    下面这个方法在状态被移除时被调用，作用是移除实体身上存在的减速修改器
     */

    @Override
    public void onRemoved(LivingEntity entity,AttributeContainer attributeContainer,int duration){
        UUID modifierUUID = CryoSpeedAttributeModifier.getId();


        EntityAttributeInstance attributeInstance =
                entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        removeAttributeModifier(attributeInstance,CryoSpeedAttributeModifier);
    }//在状态移除时移除减速

}
