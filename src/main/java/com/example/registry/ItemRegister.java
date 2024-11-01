package com.example.registry;

import com.example.TutorialMod;
import com.example.item.FireworkArrowItem;
import com.example.item.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {

    public static final Item FIREWORK_ARROW = itemRegistry("firework_arrow",
            new FireworkArrowItem(new Item.Settings().maxCount(16)));

    public static final Item PROSPECTOR = itemRegistry("prospector",new Prospector(new FabricItemSettings()));

    public static Item itemRegistry (String path, Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,path)
                ,item);
    }

    public static void initItemRegistry(){
        TutorialMod.LOGGER.debug("Item was registered.");
    }
}
