package com.example.registry;

import com.example.TutorialMod;
import com.example.particle.factory.WhiteNormalParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.random.Random;

public class ParticleFactoryRegistry {


    public static void initRegistryFactory(){
        net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.getInstance()
                .register(ParticleRegistry.WHITE_NORMAL_PARTICLE,WhiteNormalParticleFactory::new);
        TutorialMod.LOGGER.info("PF is running");
    }
}
