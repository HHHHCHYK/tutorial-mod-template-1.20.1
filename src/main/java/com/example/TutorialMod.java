package com.example;

import com.example.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "genshin_mc";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		/*
			下面的部分是模组的初始化注册，如若代码出现问题，请检查这里是否出现漏注册或者注册顺序错误
		*/
		DamageSourceRegistry.initDamageTypeRegistry();//注册伤害类型
		ItemRegistry.initItemRegistry();//注册物品
		StatusEffectsRegistry.initRegistry();//注册状态效果
		ParticleRegistry.initRegistryParticle();//注册粒子
		EntityRegistry.initEntityRegistry();//注册实体
		ModItemGroup.addItemGroup();//添加物品进入物品组
		ModItemGroup.initItemGroup();//创建物品组


	}

	
}