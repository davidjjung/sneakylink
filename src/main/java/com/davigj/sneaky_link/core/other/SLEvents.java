package com.davigj.sneaky_link.core.other;

import com.davigj.sneaky_link.core.SLConfig;
import com.davigj.sneaky_link.core.SneakyLink;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SneakyLink.MOD_ID)
public class SLEvents {
    @SubscribeEvent
    public static void onSneakyLink (TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        double radius = Math.min(SLConfig.COMMON.collectionRadius.get(), 8.0D);
        double depth = Math.min(SLConfig.COMMON.collectionDepth.get(), 8.0D);
        if (!player.level.isClientSide && player.tickCount % 5 == 0 && event.phase == TickEvent.Phase.END && player.isCrouching()) {
            AABB boundingBox = new AABB(player.getX() - radius, player.getY() - depth,
                    player.getZ() - radius,player.getX() + radius, player.getY(), player.getZ() + radius);
            for (ItemEntity itemEntity : player.level.getEntitiesOfClass(ItemEntity.class, boundingBox)) {
                itemEntity.playerTouch(player);
            }
        }
    }
}