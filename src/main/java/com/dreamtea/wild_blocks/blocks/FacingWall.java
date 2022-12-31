package com.dreamtea.wild_blocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

import java.util.Objects;

import static com.dreamtea.wild_blocks.utils.Utils.ROTATION;

public class FacingWall extends WallBlock {
    protected final boolean isGlazed;

    public FacingWall(Settings settings, boolean isGlazed) {
        super(settings);
        this.isGlazed = isGlazed;
        this.setDefaultState(super.getDefaultState().with(ROTATION, Direction.EAST));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing();

        return Objects.requireNonNull(super.getPlacementState(ctx)).with(ROTATION, direction);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return super.rotate(state, rotation).with(ROTATION, rotation.rotate(state.get(ROTATION)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return super.mirror(state, mirror).rotate(mirror.getRotation(state.get(ROTATION)));
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return isGlazed? PistonBehavior.PUSH_ONLY: super.getPistonBehavior(state) ;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
        super.appendProperties(builder);
    }
}
