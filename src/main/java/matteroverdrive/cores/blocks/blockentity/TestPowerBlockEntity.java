package matteroverdrive.cores.blocks.blockentity;

import matteroverdrive.api.inventory.ImplementedInventory;
import matteroverdrive.client.screen.TestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class TestPowerBlockEntity extends GenericPowerAcceptorBlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private long capacity = 100000;
    private long maxInsert = 10000;
    private long maxOutput = 0;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public TestPowerBlockEntity(BlockPos pos, BlockState state) {
        super(MOBlockEntityType.TEST_POWER_BLOCK_ENTITY_TYPE, pos, state, 100000, 10000, 0);

    }
    public final SimpleEnergyStorage EnergyStorage = new SimpleEnergyStorage(this.capacity,this.maxInsert,this.maxOutput){
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };


    public static void tickable(World world,BlockPos pos,BlockState state) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof TestPowerBlockEntity) {
            if (!world.isClient && ((TestPowerBlockEntity) entity).EnergyStorage.amount >= 10) {
                ((TestPowerBlockEntity) entity).EnergyStorage.amount -= 10;

            }
        }
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("energy", EnergyStorage.amount);
        Inventories.readNbt(nbt, this.inventory);
    }


    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        EnergyStorage.amount = nbt.getLong("energy");
        Inventories.writeNbt(nbt, this.inventory);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("mo.test");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        // 因为我们的类实现 Inventory，所以将*这个*提供给 ScreenHandler
        // 一开始只有服务器拥有物品栏，然后在 ScreenHandler 中同步给客户端
        return new TestScreenHandler(syncId, playerInventory, this);
    }


}
