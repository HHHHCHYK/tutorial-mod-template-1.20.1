package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Frozen extends Elements{

    protected Frozen(StatusEffectCategory category, int color) {
        super(category, color);
    }
    //冻元素
    public static final Frozen FROZEN =new Frozen(StatusEffectCategory.NEUTRAL,0X4682B4);

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }

    /*
    下面创建速度修改器，其作用分别是：
        速度
        //
        攻击速度
     */
    private final EntityAttributeModifier frozenSpeedModifier =
            new EntityAttributeModifier("FrozenSpeedModifier",-1, EntityAttributeModifier.Operation.MULTIPLY_BASE);
    //
    private final EntityAttributeModifier frozenAttachModifier =
            new EntityAttributeModifier("FrozenAttachModifier",-1, EntityAttributeModifier.Operation.MULTIPLY_BASE);


    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributeContainer, int duration){
        super.onApplied(entity,attributeContainer,duration);

        //下面增添frozen的速度修改器
        EntityAttributeInstance speedAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        addAttributeModifier(speedAttributeInstance,frozenSpeedModifier);


        //下面增添frozen的攻击速度修改器
        EntityAttributeInstance attachAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
        addAttributeModifier(attachAttributeInstance,frozenAttachModifier);

    }

    @Override
    public void onRemoved (LivingEntity entity, AttributeContainer attributeContainer, int duration){
        //下面移除frozen的速度修改器
        EntityAttributeInstance speedAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        removeAttributeModifier(speedAttributeInstance,frozenSpeedModifier);


        //下面移除frozen的攻击速度修改器
        EntityAttributeInstance attachAttributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
        removeAttributeModifier(attachAttributeInstance,frozenAttachModifier);
    }
}






