package com.example.registry;

import com.example.TutorialMod;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DamageTypeRegistry {

    public static final RegistryKey<DamageType> ELECTRO_CHARGED =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE,new Identifier(TutorialMod.MOD_ID,"electro-charged"));//注册感电伤害类型


    public static void initDamageTypeRegistry(){
        return;
    }
}
