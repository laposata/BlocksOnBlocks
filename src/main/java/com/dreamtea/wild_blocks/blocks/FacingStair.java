package com.dreamtea.wild_blocks.blocks;

import com.dreamtea.wild_blocks.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

import java.util.Objects;

public class FacingStair extends StairsBlock {
    protected final boolean isGlazed;

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param baseBlockState
     * @param settings
     */
    public FacingStair(BlockState baseBlockState, Settings settings, boolean isGlazed) {
        super(baseBlockState, settings);
        this.isGlazed = isGlazed;
        this.setDefaultState(super.getDefaultState().with(Utils.ROTATION, Direction.EAST));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing();
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(Utils.ROTATION, direction);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)super.rotate(state, rotation).with(Utils.ROTATION, rotation.rotate(state.get(Utils.ROTATION)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return super.mirror(state, mirror).rotate(mirror.getRotation(state.get(Utils.ROTATION)));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Utils.ROTATION);
        super.appendProperties(builder);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return isGlazed? PistonBehavior.PUSH_ONLY: super.getPistonBehavior(state) ;
    }

}
