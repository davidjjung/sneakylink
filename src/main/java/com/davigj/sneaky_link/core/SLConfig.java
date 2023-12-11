package com.davigj.sneaky_link.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SLConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Double> collectionRadius;
        public final ForgeConfigSpec.ConfigValue<Double> collectionDepth;

        Common (ForgeConfigSpec.Builder builder) {
            builder.push("changes");
            collectionRadius = builder.comment("Horizontal radius within which the player picks up item entities").define("Collection radius", 3.0D);
            collectionDepth = builder.comment("Amount of blocks below the player where sneaking picks up item entities").define("Collection depth", 1.0D);
            builder.pop();
        }
    }

    static final ForgeConfigSpec COMMON_SPEC;
    public static final SLConfig.Common COMMON;


    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(SLConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
