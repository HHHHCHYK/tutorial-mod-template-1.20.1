package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;

import java.util.Collection;

public class Hydro extends Elements{

    protected Hydro(StatusEffectCategory category, int color) {
        super(category, color);
    }

    //水元素
    public static final Hydro HYDRO = new Hydro(StatusEffectCategory.NEUTRAL, 0X00BFFF);//创建水附着实例

    @Override
    public void applyUpdateEffect(LivingEntity entity,int amplifier){
        EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);//获取当前实体的属性实例
        Collection<StatusEffectInstance> effectInstances = entity.getStatusEffects();//获取当前实体状态
        World world = entity.getWorld();


        if(effectInstances != null){
            for(StatusEffectInstance effectInstance : effectInstances){
                if(effectInstance.getEffectType() instanceof Pyro){
                    int pyroDuration = effectInstance.getDuration();
                    entity.removeStatusEffect(Hydro.HYDRO);
                    entity.removeStatusEffect(Pyro.PYRO);

                    if(this.duration > pyroDuration){
                        entity.addStatusEffect(new StatusEffectInstance(Hydro.HYDRO,duration));
                    }
                }
            }
        }

    }






}
