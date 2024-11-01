package com.example;

import com.example.registry.RenderRegistry;
import net.fabricmc.api.ClientModInitializer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderRegistry.initRenderRegistry();//注册实体渲染器
    }
}
