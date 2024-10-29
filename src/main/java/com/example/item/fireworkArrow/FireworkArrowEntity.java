package com.example.item.fireworkArrow;

import com.example.TutorialMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class FireworkArrowEntity extends ArrowEntity {

    public FireworkArrowEntity(EntityType<?extends ArrowEntity> type, World world) {
        super(type,world);

    }


    public FireworkArrowEntity(World world, LivingEntity owner) {
        super(world,owner);
    }




    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(FireworkArrowItem.FIREWORK_ARROW);
    }

    @Override
    protected void onHit(LivingEntity target){
        super.onHit(target);
        int duration = 200;
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.LEVITATION, duration,3);
        target.addStatusEffect(statusEffectInstance,this.getEffectCause());
    }


/*
    public static DamageSource damageSource = new DamageSource();


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult){
        super.onEntityHit(entityHitResult);

        Entity target = entityHitResult.getEntity();
        if(target instanceof LivingEntity livingEntity){
            target.damage(new DamageSource())
        }

    }
*/
    public static final EntityType<FireworkArrowEntity> FIREWORK_ARROW_ENTITY =
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,(EntityType<FireworkArrowEntity> type, World world) -> new FireworkArrowEntity(type, world))
                    .dimensions(EntityDimensions.fixed(0.5F,0.5F))
                    .build();

    public static void initRegistryFireworkArrowEntity(){
        Registry.register(Registries.ENTITY_TYPE,new Identifier(TutorialMod.MOD_ID,"firework_arrow_entity"),FIREWORK_ARROW_ENTITY);
    }
}
