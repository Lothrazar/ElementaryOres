package com.lothrazar.elementaryores.client;

import com.lothrazar.elementaryores.ModOres;
import com.lothrazar.elementaryores.RegistryOres;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;

@EventBusSubscriber(modid = ModOres.MODID, value = Dist.CLIENT)
public class ClientEvents {

  @SubscribeEvent
  public static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
    Map<BlockState, BlockStateModel> models = event.getBakingResult().blockStateModels();
    for (DeferredHolder<Block, ? extends Block> holder : RegistryOres.BLOCKS.getEntries()) {
      Block block = holder.get();
      for (BlockState state : block.getStateDefinition().getPossibleStates()) {
        BlockStateModel existing = models.get(state);
        if (existing != null) {
          models.put(state, new EmissiveOreBakedModel(existing));
        }
      }
    }
  }
}
