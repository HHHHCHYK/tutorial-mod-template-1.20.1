package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Collection;

public class Hydro extends Elements{

    protected Hydro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static final Hydro HYDRO = new Hydro(StatusEffectCategory.NEUTRAL, 0X00BFFF);//创建水附着实例

    @Override
    public void applyUpdateEffect(LivingEntity entity,int amplifier){
        EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);//获取当前实体的属性实例
        Collection<StatusEffectInstance> effectInstances = entity.getStatusEffects();//获取当前实体状态


        if(entity.isFireImmune()){
            entity.removeStatusEffect(this);
        }//实体着火时清除这个状态效果

    }





}
