package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Electro extends Elements{
    protected Electro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static final Electro ELECTRO =new Electro(StatusEffectCategory.NEUTRAL,0X945DC4);

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }
}
