package com.example.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StdGenshinSword implements ToolMaterial {

    @Override
    public int getDurability() {
        return 20000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 10;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }


}
