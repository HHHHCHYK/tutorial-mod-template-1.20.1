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

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }

    private final EntityAttributeModifier CryoSpeedAttributeModifier =
            new EntityAttributeModifier("CryoSpeed",0.9,EntityAttributeModifier.Operation.MULTIPLY_BASE);


    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributeContainer, int duration){
        super.onApplied(entity,attributeContainer,duration);

        EntityAttributeInstance speedAttributeInstance =
                entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        if(speedAttributeInstance == null){
            //noinspection DataFlowIssue
            speedAttributeInstance.addPersistentModifier(CryoSpeedAttributeModifier);
        }
    }//在获得状态时减速

    @Override
    public void onRemoved(LivingEntity entity,AttributeContainer attributeContainer,int duration){

        UUID modifierUUID = CryoSpeedAttributeModifier.getId();

        EntityAttributeInstance attributeInstance =
                entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        if(attributeInstance != null){
            if(attributeInstance.hasModifier(CryoSpeedAttributeModifier)){
                attributeInstance.removeModifier(modifierUUID);
            }
        }
    }//在状态移除时移除减速

}
