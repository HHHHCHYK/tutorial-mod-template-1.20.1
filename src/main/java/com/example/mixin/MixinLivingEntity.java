package com.example.mixin;

import com.example.statusEffect.Cryo;
import com.example.statusEffect.Frozen;
import com.example.statusEffect.Hydro;
import com.example.statusEffect.Pyro;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
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

    @Shadow public abstract void enterCombat();

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

        /*
        下面的作用是实现：
            实体进入细雪时  ------->  冰附着
         */
        if(block.equals(Blocks.POWDER_SNOW)){
            livingEntity.addStatusEffect(new StatusEffectInstance(Cryo.CRYO,Cryo.CRYO.getDurationLevel(),3));
        }

        /*
        下面实现：
            当实体着火或者进入岩浆时  ----->  添加火附着
         */
        if(livingEntity.isOnFire() || block.equals(Blocks.LAVA)){
            livingEntity.addStatusEffect(new StatusEffectInstance(Pyro.PYRO,Pyro.PYRO.getDurationLevel(),3));
        }

    }

    @Inject(method = "jump",at = @At("TAIL"))
    public void changeEntityJump(CallbackInfo info){
        LivingEntity entity = (LivingEntity) (Object)this;



        Collection<StatusEffectInstance> statusEffectInstances = entity.getStatusEffects();

        for(StatusEffectInstance statusEffectInstance : statusEffectInstances){
            if(statusEffectInstance.getEffectType() instanceof Frozen){
                entity.addVelocity(0,-entity.getVelocity().y,0);

                Frozen.FROZEN.jumpCount++;//这里是为了实现跳跃破冰

                /*
                下面实现了每次跳跃破冰时会在聊天栏发送信息给玩家
                 */
                if(entity.isPlayer()){
                    PlayerEntity player = (PlayerEntity) entity;
                    int jumpCount = Frozen.FROZEN.jumpCount;
                    player.sendMessage(
                            Text.translatable("lang.genshin_mc.jumpCount",jumpCount).setStyle(Style.EMPTY.withColor(0X4682B4))
                    );

                }
            }
        }
    }

}