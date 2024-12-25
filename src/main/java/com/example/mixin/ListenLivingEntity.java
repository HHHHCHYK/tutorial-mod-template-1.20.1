package com.example.mixin;

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

@Mixin(LivingEntity.class)
public abstract class ListenLivingEntity {

    @Shadow public abstract void endCombat();

    @Inject(method = "tick",at = @At("HEAD"))
    public void Influence(CallbackInfo info){
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
            livingEntity.addStatusEffect(new StatusEffectInstance(Hydro.HYDRO));
        }
        if(livingEntity.isOnFire()){
            livingEntity.addStatusEffect(new StatusEffectInstance(Pyro.PYRO));
        }


    }

}