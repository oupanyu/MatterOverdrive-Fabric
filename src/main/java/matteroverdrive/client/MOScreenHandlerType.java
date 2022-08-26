package matteroverdrive.client;

import matteroverdrive.client.screen.TestScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;


public class MOScreenHandlerType {
    public static final ScreenHandlerType<TestScreenHandler> TEST_SCREEN_HANDLER;
    static {
        TEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("matteroverdrive","inscriber_screen_handler"), TestScreenHandler::new);
    }
}
