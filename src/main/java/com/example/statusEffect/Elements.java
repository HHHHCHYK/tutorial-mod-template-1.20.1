package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public abstract class Elements extends StatusEffect {
    protected Elements(StatusEffectCategory category, int color) {
        super(category, color);
    }

    protected int duration=0;
    protected int amplifier=0;

    @Override
    public boolean canApplyUpdateEffect(int duration,int amplifier){
        this.duration = duration;
        this.amplifier = amplifier;

        return duration%10==0;
    }//设置每tick检测

    @Override
    public abstract void applyUpdateEffect(LivingEntity entity, int amplifier);

    /*
    这个的作用是通过等级规范作用时间
     */
    public int getDurationLevel(){
        if(amplifier == 0){
            return 60;
        }
        return this.amplifier*60;
    }


}
