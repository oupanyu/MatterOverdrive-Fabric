package matteroverdrive.cores.blocks;

import matteroverdrive.cores.blocks.blockentity.MOBlockEntityType;
import matteroverdrive.cores.blocks.blockentity.TestPowerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class TestPowerBlock extends BlockWithEntity {
    public static final DirectionProperty FACING;
    static{FACING = DirectionProperty.of("facing", new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST});}
    public TestPowerBlock(Settings settings) {
        super(settings.nonOpaque());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TestPowerBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity entity = world.getBlockEntity(pos);
            if (!world.isClient) {
                // 这里会调用 BlockWithEntity 的 createScreenHandlerFactory 方法，会将返回的方块实体强转为
                // 一个 namedScreenHandlerFactory。如果你的方块没有继承 BlockWithEntity，那就需要单独实现 createScreenHandlerFactory。
                NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

                if (screenHandlerFactory != null) {
                    // 这个调用会让服务器请求客户端开启合适的 Screenhandler
                    player.openHandledScreen(screenHandlerFactory);
                }

        }



        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState blockState, BlockEntityType<T> blockEntityType){
        return checkType(blockEntityType, MOBlockEntityType.INSCRIBER_BLOCK_ENTITY_TYPE,(world1, pos, state, testPowerBlockEntity) -> TestPowerBlockEntity.tick(world1,pos,state,testPowerBlockEntity));
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block,BlockState> builder){builder.add(FACING);}

    public BlockState getPlacementState(ItemPlacementContext ctx){
        return this.getDefaultState().with(FACING,ctx.getPlayerFacing().getOpposite());
    }
}

