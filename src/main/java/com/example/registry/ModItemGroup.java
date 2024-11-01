package com.example.registry;

import com.example.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup extends ItemGroups {
    public static final ItemGroup MY_ITEMGROUP = FabricItemGroup.builder().icon(()->new ItemStack(ItemRegister.FIREWORK_ARROW))
            .displayName(Text.translatable("itemGroup.tutorial-mod.my_mod"))
            .entries(((displayContext, entries) -> entries.add(ItemRegister.FIREWORK_ARROW)))
            .build();

    public static void initItemGroup(){
        Registry.register(Registries.ITEM_GROUP,new Identifier(TutorialMod.MOD_ID,"my_item_group"),MY_ITEMGROUP);
    }

    public static void addItemGroup(){//向已存在物品组添加物品的方法
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content ->
                content.add(ItemRegister.FIREWORK_ARROW));
        //战斗物品组的物品添加
    }


}
