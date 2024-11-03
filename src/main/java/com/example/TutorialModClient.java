package com.example;

import com.example.particle.WhiteNormalParticle;
import com.example.particle.factory.WhiteNormalParticleFactory;
import com.example.registry.ParticleFactoryRegistry;
import com.example.registry.RenderRegistry;
import net.fabricmc.api.ClientModInitializer;

public class TutorialModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        RenderRegistry.initRenderRegistry();//注册实体渲染器
        ParticleFactoryRegistry.initRegistryFactory();//注册粒子工厂
    }
}
