package matteroverdrive.client.screen;

import matteroverdrive.client.MOScreenHandlerType;
import matteroverdrive.client.screen.gui.GUITestBlock;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ScreenRegistian {
    public static void register(){
        ScreenRegistry.register(MOScreenHandlerType.TEST_SCREEN_HANDLER, GUITestBlock::new);
    }
}
