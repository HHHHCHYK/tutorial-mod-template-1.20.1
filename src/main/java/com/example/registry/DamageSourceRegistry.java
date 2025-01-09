package com.example.registry;

import com.example.TutorialMod;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class DamageSourceRegistry {
    public static final RegistryKey<DamageType> ELECTRO_CHARGED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,new Identifier(TutorialMod.MOD_ID,"electro-charged"));



    public static DamageSource of(World world,RegistryKey<DamageType> registryKey){
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(registryKey));
    }

    public static void initDamageTypeRegistry(){
    }
}
