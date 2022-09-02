package matteroverdrive.client.render;

import matteroverdrive.common.events.MOContent;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ClientRender {
    public static void glass(){
        BlockRenderLayerMap.INSTANCE.putBlock(MOContent.INDUSTRIAL_GLASS_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MOContent.TRITANIUM_GLASS_BLOCK, RenderLayer.getTranslucent());
    }
}
