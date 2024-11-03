package com.example.registry;

import com.example.TutorialMod;
import com.example.particle.WhiteNormalParticle;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticleRegistry {
    public static final DefaultParticleType WHITE_NORMAL_PARTICLE = FabricParticleTypes.simple();

    public static void initRegistryParticle(){
        Registry.register(Registries.PARTICLE_TYPE,new Identifier(TutorialMod.MOD_ID,"white_normal_particle"),WHITE_NORMAL_PARTICLE);
    }

}
