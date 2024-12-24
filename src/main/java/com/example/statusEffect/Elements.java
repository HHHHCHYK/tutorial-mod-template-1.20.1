package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public abstract class Elements extends StatusEffect {
    protected Elements(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration,int amplifier){
        return duration%10==0;
    }//设置每tick检测

    @Override
    public abstract void applyUpdateEffect(LivingEntity entity, int amplifier);



}
