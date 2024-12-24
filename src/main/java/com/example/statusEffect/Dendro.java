package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Dendro extends Elements{
    protected Dendro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static final Dendro DENDRO =new Dendro(StatusEffectCategory.NEUTRAL,0X66AD16);


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }
}
