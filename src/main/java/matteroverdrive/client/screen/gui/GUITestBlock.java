package matteroverdrive.client.screen.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import matteroverdrive.client.render.ClientRender;
import matteroverdrive.client.screen.TestScreenHandler;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class GUITestBlock extends HandledScreen<TestScreenHandler> {
    private static final Identifier TEXTURE_BACKGROUND = new Identifier("matteroverdrive", "textures/gui/custom/inscriber.png");
    public GUITestBlock(TestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {

        this.backgroundWidth = 224;
        this.backgroundHeight = 176;
        //原宽高：高166，宽176
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE_BACKGROUND);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, this.x, this.y, 0, 0, 225, 177);

        drawTexture(matrices, x + 142, y + 46, 4, 179, 14, handler.getScaledEnergyForTexture());
        drawTexture(matrices, x + 57, y + 56, 35, 181, handler.getScaledProgressForTexture(), 18);
        //this.backgroundWidth = 176;
        //this.backgroundHeight = 166;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        // 将标题居中

        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        //titleY = -10;
    }
}
