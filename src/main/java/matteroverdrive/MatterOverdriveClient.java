package matteroverdrive;

import matteroverdrive.client.MOScreenHandlerType;
import matteroverdrive.client.render.ClientRender;
import matteroverdrive.client.screen.gui.GUITestBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;


public class MatterOverdriveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MOScreenHandlerType.TEST_SCREEN_HANDLER, GUITestBlock::new);
        ClientRender.glass();
    }
}
