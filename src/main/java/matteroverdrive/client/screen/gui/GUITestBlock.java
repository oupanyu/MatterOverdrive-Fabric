package matteroverdrive.client.screen.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import matteroverdrive.client.screen.TestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class GUITestBlock extends HandledScreen<ScreenHandler> {
    private static final Identifier TEXTURE_BACKGROUND = new Identifier("matteroverdrive", "textures/gui/custom/inscriber.png");
    public GUITestBlock(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        this.backgroundWidth = 225;
        this.backgroundHeight = 177;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE_BACKGROUND);
        int x = (width - backgroundWidth) / 2 + 12;
        int y = (height - backgroundHeight) / 2 - 12;
        drawTexture(matrices, x, y, 0, 0, 225, 177);

        drawTexture(matrices, x + 118, y + 39, 4, 179, 14, 42);
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
        titleY = -10;
    }
}
