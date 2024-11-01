package com.example.entity;

import com.example.registry.EntityRegistry;
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

public class FireworkArrowEntity extends PersistentProjectileEntity {
    public FireworkArrowEntity(EntityType<? extends FireworkArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public FireworkArrowEntity(EntityType<?extends  FireworkArrowEntity> entityType,LivingEntity shooter,World world){
        super(entityType,shooter,world);
    }

    public FireworkArrowEntity(World world, LivingEntity owner) {
        super(EntityRegistry.FIREWORK_ARROW_ENTITY, owner, world);
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
        }
    }//使得生物获得漂浮效果并且被爆炸推动

    @Override
    protected ItemStack asItemStack(){
        return new ItemStack(Items.ARROW);
    }//返回普通箭矢




}
