package com.example.entity;

import com.example.TutorialMod;
import com.example.misc.NormalVectorGenerator;
import com.example.registry.EntityRegistry;
import com.example.registry.ParticleRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireworkArrowEntity extends PersistentProjectileEntity {

    private final boolean flying =true;

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

        double x=target.getX();
        double y=target.getY();
        double z=target.getZ();


        World world = target.getWorld();
        if(!world.isClient()){
            StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.LEVITATION,10,15);
            target.addStatusEffect(effectInstance,this.getEffectCause());
            FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(
                    target.getWorld(),
                    x,y,z,new ItemStack(Items.FIREWORK_ROCKET));
            this.getWorld().spawnEntity(fireworkRocketEntity);
            this.getWorld().createExplosion(this,getX(),getY(),getZ(),0F,false, World.ExplosionSourceType.NONE);
            this.discard();
        }



    }//使得生物获得漂浮效果并且被爆炸推动



    @Override
    protected ItemStack asItemStack(){
        return new ItemStack(Items.ARROW);
    }//返回普通箭矢

    @Override
    public void tick(){
        super.tick();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double velocityX = this.getVelocity().x;
        double velocityY = this.getVelocity().y;
        double velocityZ = this.getVelocity().z;
        Vec3d axis = new Vec3d(velocityX,velocityY,velocityZ);
        Vec3d startVector = NormalVectorGenerator.generatePerpendicularVector(axis);

        double velocityMul = 0.07;


        double angle = 5f;
        if(flying){
            for(int i =0;i<72;i++){
                Vec3d direction = NormalVectorGenerator.rotateAroundAxis(startVector, axis, angle * i);

                this.getWorld().addParticle(
                        ParticleRegistry.WHITE_NORMAL_PARTICLE, x, y, z,
                        velocityMul * direction.x, velocityMul * direction.y, velocityMul * direction.z
                );
            }
            this.getWorld().addParticle(ParticleTypes.SMOKE,x,y,z,0,0F,0);
        }
        //生成粒子
    }
}
