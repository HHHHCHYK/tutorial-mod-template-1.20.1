package com.example.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class FireworkArrowEntity extends ArrowEntity {
    public FireworkArrowEntity(EntityType<? extends FireworkArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public FireworkArrowEntity(World world, PlayerEntity user){
        super(world,user);
    }

    public FireworkArrowEntity(World world,LivingEntity shooter){
        super(world,shooter);
    }


    @Override
    protected void onHit(LivingEntity target){
        super.onHit(target);

        World world = target.getWorld();
        if(!world.isClient()){
            StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.LEVITATION,200,10);
            target.addStatusEffect(effectInstance,this.getEffectCause());
            this.getWorld().createExplosion(this,getX(),getY(),getZ(),0F,false, World.ExplosionSourceType.NONE);
            this.discard();
            this.discard();
        }
    }//使得生物获得漂浮效果并且被爆炸推动

    @Override
    protected ItemStack asItemStack(){
        return new ItemStack(Items.ARROW);
    }//返回普通箭矢


}
