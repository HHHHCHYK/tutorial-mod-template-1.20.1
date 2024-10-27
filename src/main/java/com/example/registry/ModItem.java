package com.example.registry;

import com.example.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItem {
    public static Item itemRegistry (String name){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name)
                ,new Item(new FabricItemSettings()));
    }

    public static final Item FIREWORK_ARROW = itemRegistry("firework_arrow");

    public static void initRegistry(){
        TutorialMod.LOGGER.debug("ModItem is Running");
    }
}
