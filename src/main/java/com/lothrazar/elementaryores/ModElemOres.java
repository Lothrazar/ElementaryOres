package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.BiomeLoader;
import com.lothrazar.elementaryores.world.ClientOreRegistry;
import com.lothrazar.elementaryores.world.ConfigHandler;
import com.lothrazar.elementaryores.world.WorldGenRegistry;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ModElemOres.MODID)
public class ModElemOres {

  public static final String MODID = "elementaryores";
  private static final String MODIFY_BIOMES = "modify_biomes";
  private static final ResourceLocation MODIFY_BIOMES_RL = new ResourceLocation(MODID, MODIFY_BIOMES);

  public ModElemOres() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    eventBus.addListener(this::setup);
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      eventBus.addListener(ClientOreRegistry::setup);
    });
    final DeferredRegister<Codec<? extends BiomeModifier>> serializers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    serializers.register(modBus);
    serializers.register(MODIFY_BIOMES, TestModifier::makeCodec);
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      WorldGenRegistry.init();
    });
  }

  public record TestModifier(HolderSet<Biome> biomes) implements BiomeModifier {

    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(MODIFY_BIOMES_RL, ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);

    @Override
    public void modify(Holder<Biome> biome, Phase phase, BiomeInfo.Builder builder) {
      //      NetherFeatures.BASALT_BLOBS
      OreFeatures fuck;
      //intln("basdfasdf BREAKPOINT NEVER GETS HIT");
      if (phase == Phase.MODIFY && biome.is(BiomeTags.IS_NETHER)) {
        //no more BiomeCategory. only nether. 
        BiomeLoader.modifyNether(builder.getGenerationSettings());
      }
      if (phase == Phase.MODIFY && biome.is(BiomeTags.IS_END)) {
        //no more BiomeCategory. only nether. 
        BiomeLoader.modifyNether(builder.getGenerationSettings());
      }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
      return SERIALIZER.get();
    }

    private static Codec<TestModifier> makeCodec() {
      //ok a breakpoint gets hit in this one
      return RecordCodecBuilder.create(builder -> builder
          .group(
              Biome.LIST_CODEC.fieldOf("biomes").forGetter(TestModifier::biomes)
          //              Precipitation.CODEC.fieldOf("precipitation").forGetter(TestModifier::precipitation),
          //              Codec.INT.fieldOf("water_color").forGetter(TestModifier::waterColor)
          )
          .apply(builder, TestModifier::new));
    }
  }
}
