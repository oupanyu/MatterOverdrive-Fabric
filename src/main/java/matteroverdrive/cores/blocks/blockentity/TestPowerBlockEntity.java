package matteroverdrive.cores.blocks.blockentity;

import matteroverdrive.api.inventory.ImplementedInventory;
import matteroverdrive.client.screen.TestScreenHandler;
import matteroverdrive.cores.blocks.TestPowerBlock;
import matteroverdrive.cores.recipe.InscriberRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleBatteryItem;
import team.reborn.energy.api.base.SimpleEnergyStorage;
import team.reborn.energy.impl.SimpleItemEnergyStorageImpl;

import java.util.Optional;

public class TestPowerBlockEntity extends GenericPowerAcceptorBlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private long capacity = 100000;
    private long maxInsert = 10000;
    private long maxOutput = 0;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress;
    private int maxEnergy = (int) capacity;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public TestPowerBlockEntity(BlockPos pos, BlockState state) {
        super(MOBlockEntityType.INSCRIBER_BLOCK_ENTITY_TYPE, pos, state, 100000, 10000, 0);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0:return TestPowerBlockEntity.this.progress;
                    case 1:return TestPowerBlockEntity.this.maxProgress;
                    case 2:return (int) TestPowerBlockEntity.this.EnergyStorage.amount;
                    case 3:return TestPowerBlockEntity.this.maxEnergy;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        TestPowerBlockEntity.this.progress = value;
                        break;
                    case 1:
                        TestPowerBlockEntity.this.maxProgress = value;
                        break;
                    case 2:
                        TestPowerBlockEntity.this.EnergyStorage.amount = value;
                        break;
                    case 3:
                        TestPowerBlockEntity.this.maxEnergy = value;
                        break;
                }
            }
            @Override
            public int size() {
                return 4;
            }
    };
    }
    public final SimpleEnergyStorage EnergyStorage = new SimpleEnergyStorage(this.capacity,this.maxInsert,this.maxOutput){
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };
    public static void tick(World world, BlockPos pos, BlockState state, TestPowerBlockEntity entity) {

            if(hasRecipe(entity)){
                if (!world.isClient && entity.EnergyStorage.amount >= 10) {
                    entity.EnergyStorage.amount -= 10;
                    entity.progress++;
                    if (entity.progress > entity.maxProgress){
                        craftItem(entity);
                    }
                }

            }
            else {
                entity.resetProgress();
            }
            if (canCharge(entity)){
                charge(entity);
            }

    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("energy", EnergyStorage.amount);
        nbt.putInt("progress", progress);
        nbt.putInt("maxprogress", maxProgress);
        Inventories.writeNbt(nbt, this.inventory);
    }


    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        EnergyStorage.amount = nbt.getLong("energy");
        progress = nbt.getInt("progress");
        maxProgress = nbt.getInt("maxprogress");
        Inventories.readNbt(nbt, this.inventory);
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
        return new TestScreenHandler(syncId, playerInventory, this,this.propertyDelegate);
    }

    private static boolean hasRecipe(TestPowerBlockEntity entity){
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size();i++){
            inventory.setStack(i,entity.getStack(i));
        }
        Optional<InscriberRecipe> match = world.getRecipeManager()
                .getFirstMatch(InscriberRecipe.Type.INSTANCE,inventory,world);
        int maxP = match.isPresent() ? match.get().getTick() : 0;
        entity.maxProgress = maxP;
        return match.isPresent() && canInsrertAmountIntoOutputSlot(inventory) && canInsrertAmountIntoOutputSlot(inventory,match.get().getOutput());
    }

    private static boolean canCharge(TestPowerBlockEntity entity){
        return entity.getStack(2).getItem() instanceof SimpleBatteryItem;

    }
    private static void charge(TestPowerBlockEntity entity){
        ItemStack stack = entity.getStack(2);
        SimpleBatteryItem simpleBatteryItem = (SimpleBatteryItem) entity.getStack(2).getItem();
        if (simpleBatteryItem.getStoredEnergy(stack) > 0){
            simpleBatteryItem.tryUseEnergy(stack,1000);
            entity.EnergyStorage.amount += 1000;
        }

    }


    private static boolean canInsrertAmountIntoOutputSlot(SimpleInventory inventory,ItemStack output){
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsrertAmountIntoOutputSlot(SimpleInventory inventory){
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }
    private static void craftItem(TestPowerBlockEntity entity){
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i,entity.getStack(i));
        }
        Optional<InscriberRecipe> match = world.getRecipeManager()
                .getFirstMatch(InscriberRecipe.Type.INSTANCE,inventory,world);
        if (match.isPresent()){
            entity.removeStack(0,1);
            entity.removeStack(1,1);
            entity.setStack(3,new ItemStack(match.get().getOutput().getItem(),entity.getStack(3).getCount() + 1));
            entity.resetProgress();
        }
    }
    private void resetProgress(){
        this.progress = 0;
    }
    public int getProcessWithPercent(TestPowerBlockEntity entity){
        return Math.round((entity.EnergyStorage.getAmount() * 100f / entity.EnergyStorage.getCapacity()) * 13) / 100;
    }

}
