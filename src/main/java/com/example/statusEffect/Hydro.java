package com.example.statusEffect;

import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

import javax.swing.plaf.PanelUI;

public class Hydro extends StatusEffect{

    protected Hydro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static final Hydro HYDRO = new Hydro(StatusEffectCategory.NEUTRAL, 0X00BFFF);

    @Override
    public boolean canApplyUpdateEffect(int duration,int amplifier){
        return duration%10==0;
    }

    /*

    @Override
    public void applyUpdateEffect()
     */



}
