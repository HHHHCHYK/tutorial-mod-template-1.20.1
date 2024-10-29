package com.example;

import com.example.item.LightningItem;
import com.example.item.fireworkArrow.FireworkArrowItem;
import com.example.registry.ModItemGroup;
import com.example.item.fireworkArrow.FireworkArrowEntity;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";

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

		FireworkArrowItem.initRegistry();//注册烟花火矢
		LightningItem.registryLightningItem();//注册测试物品：引雷棍
		FireworkArrowEntity.initRegistryFireworkArrowEntity();//注册烟花火矢实体
		ModItemGroup.initItemGroup();

	}

	
}