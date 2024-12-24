package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Pyro extends Elements{
    protected Pyro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static final Pyro PYRO =new Pyro(StatusEffectCategory.NEUTRAL,0XEC4923);

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }
}
