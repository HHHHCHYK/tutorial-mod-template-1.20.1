package com.example.mixin;

import com.example.statusEffect.Cryo;
import com.example.statusEffect.Frozen;
import com.example.statusEffect.Hydro;
import com.example.statusEffect.Pyro;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {

    @Shadow public abstract void endCombat();

    @Inject(method = "tick",at = @At("HEAD"))
    public void entityInfluence(CallbackInfo info){
        /*
        下面这一段是为了与原函数对齐颗粒度
         */
        LivingEntity livingEntity = (LivingEntity) (Object)this;
        World world = livingEntity.getWorld();

        /*
        下面这一部分是为了实现检测实体脚下方块并且做出反应
            其中包括：{
                当实体碰到水的时候，实体会出现水附着状态
            }
         */

        BlockPos blockPos = livingEntity.getBlockPos();//获取当前实体脚下方块坐标
        Block block = world.getBlockState(blockPos).getBlock();//获取当前实体脚下方块

        if(block.equals(Blocks.WATER)){
            /*
            如果实体进入水中，将会被添加水附着状态
             */
            livingEntity.addStatusEffect(new StatusEffectInstance(Hydro.HYDRO,Hydro.HYDRO.getDurationLevel(),3));

        }

        if(block.equals(Blocks.POWDER_SNOW)){
            livingEntity.addStatusEffect(new StatusEffectInstance(Cryo.CRYO,Cryo.CRYO.getDurationLevel(),3));
        }

        if(livingEntity.isOnFire()){
            livingEntity.addStatusEffect(new StatusEffectInstance(Pyro.PYRO,Pyro.PYRO.getDurationLevel(),3));
        }

    }

    @Inject(method = "jump",at = @At("HEAD"))
    public void changeEntityJump(CallbackInfo info){
        LivingEntity entity = (LivingEntity) (Object)this;



        Collection<StatusEffectInstance> statusEffectInstances = entity.getStatusEffects();

        for(StatusEffectInstance statusEffectInstance : statusEffectInstances){
            if(statusEffectInstance.getEffectType() instanceof Frozen){
                //Debug
                System.out.println("Mixin is running");


                entity.setVelocity(entity.getVelocity().getX(),0.1,entity.getVelocity().getZ());
                return;
            }
        }
    }

}