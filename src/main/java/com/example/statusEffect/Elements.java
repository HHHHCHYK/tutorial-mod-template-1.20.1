package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public abstract class Elements extends StatusEffect {
    protected Elements(StatusEffectCategory category, int color) {
        super(category, color);
    }

    protected int duration=0;
    protected int amplifier=0;
    protected int electroChargedTimer;


    @Override
    public boolean canApplyUpdateEffect(int duration,int amplifier){

        this.duration = duration;
        this.amplifier = amplifier;
        electroChargedTimer = (duration%20==0)? 0 : 1;

        return duration%10==0;
    }//设置每tick检测

    @Override
    public abstract void applyUpdateEffect(LivingEntity entity, int amplifier);

    /*
    这个的作用是通过等级规范作用时间
     */
    public int getDurationLevel(){
        return amplifier*50 + 140;
    }

    protected static void addAttributeModifier(EntityAttributeInstance attributeInstance, EntityAttributeModifier attributeModifier){
        int hasModifier =0;

        if(attributeInstance != null){
            for(EntityAttributeModifier modifier : attributeInstance.getModifiers()){
                if(modifier.getId().equals(attributeModifier.getId())){
                    hasModifier =1;
                }
            }

            if(hasModifier == 0){
                attributeInstance.addPersistentModifier(attributeModifier);
            }
        }


    }

    /*
    此方法用于移除属性修改器，并且能够防止重复添加属性修改器
     */
    protected static void removeAttributeModifier(EntityAttributeInstance attributeInstance,EntityAttributeModifier attributeModifier){
        if(attributeInstance != null){
            if(attributeInstance.hasModifier(attributeModifier)){
               attributeInstance.removeModifier(attributeModifier);
            }
        }
    }


}
