package com.example.statusEffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
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

        if(duration>340){
            entity.removeStatusEffect(Hydro.HYDRO);
            entity.addStatusEffect(new StatusEffectInstance(Hydro.HYDRO,340,4));
        }//对于超过17秒的附着，全部变为17秒


        if(effectInstances != null){
            for(StatusEffectInstance effectInstance : effectInstances){

                StatusEffect effectType = effectInstance.getEffectType();//获取改状态实例的状态类型


                /*
                        这一部分的作用的实现水火反应在自然状态下的逻辑（没有伤害）
                 */


                if(effectInstance.getEffectType() instanceof Pyro){
                    int pyroDuration = effectInstance.getDuration();//这里获取火元素的等级
                    int newDuration = pyroDuration - duration*2;

                    entity.removeStatusEffect(Hydro.HYDRO);
                    entity.removeStatusEffect(Pyro.PYRO);
                    //前置移除已有元素

                    if(newDuration>0){//条件：火的元素量多于水
                        entity.addStatusEffect(new StatusEffectInstance(Pyro.PYRO,newDuration));
                    }//反应后，后手元素不残留，先手元素残留
                }


                /*
                    这里实现水雷感电反应
                 */
                if(effectType instanceof Electro){
                    int electroDuration = effectInstance.getDuration();
                    int newDuration = electroDuration - duration;

                    entity.removeStatusEffect(Hydro.HYDRO);
                    entity.removeStatusEffect(Electro.ELECTRO);
                    //前置移除已有元素


                    if(newDuration>0){
                        entity.addStatusEffect(new StatusEffectInstance(Electro.ELECTRO,newDuration));
                    }//反应后，后手元素不残留，先手元素残留
                }


            }
        }

    }






}
