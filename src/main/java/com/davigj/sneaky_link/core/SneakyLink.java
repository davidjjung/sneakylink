package com.davigj.sneaky_link.core;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(SneakyLink.MOD_ID)
public class SneakyLink {
    public static final String MOD_ID = "sneaky_link";

    public SneakyLink() {
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, SLConfig.COMMON_SPEC);
    }
}