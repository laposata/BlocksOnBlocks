package com.dreamtea.wild_blocks.blocks;

import com.dreamtea.wild_blocks.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

import java.util.Objects;

import static com.dreamtea.wild_blocks.utils.Utils.DIRECTION;

public class DirectionalStair extends StairsBlock {

    public DirectionalStair(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing();
        Utils.HorizontalFacing axis = Utils.HorizontalFacing.fromDirection(direction);
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(DIRECTION, axis);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return super.rotate(state, rotation).with(DIRECTION, Utils.HorizontalFacing.flip(state.get(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return super.mirror(state, mirror);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        super.appendProperties(builder);
    }
}
