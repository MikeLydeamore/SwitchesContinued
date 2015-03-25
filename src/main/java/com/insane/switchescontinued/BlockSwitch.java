package com.insane.switchescontinued;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLever;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSwitch extends BlockLever {

	private Block baseBlock;
	private String name;

	public IIcon colors;
	public IIcon off, on;

	public BlockSwitch(Block base, String name)
	{
		super();
		this.name = name;
		this.setBlockName("switch_"+name);
		this.baseBlock = base;
		this.setHardness(0.8f);
	}

	public Block getBaseBlock()
	{
		return this.baseBlock;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		off = register.registerIcon("switchescontinued:off_"+name);
		on = register.registerIcon("switchescontinued:on_"+name);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0)
		{
			if (meta == 0 || meta == 7)
				return off;
			if (meta == 8 || meta == 15)
				return on;
		}
		if (side == 5)
		{
			if (meta == 1)
				return off;
			if (meta == 9)
				return on;
		}
		if (side == 4)
		{
			if (meta == 2)
				return off;
			if (meta == 10)
				return on;
		}
		if (side == 3)
		{
			if (meta == 3)
				return off;
			if (meta == 11)
				return on;
		}
		if (side == 2)
		{
			if (meta == 4)
				return off;
			if (meta == 12)
				return on;
		}
		if (side == 1)
		{
			if (meta == 5 || meta == 6)
				return off;
			if (meta == 13 || meta == 14)
				return on;
		}
		
		return baseBlock.getIcon(side, meta);
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered (IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		switch (meta%8)
		{
		case 0:
			this.setBlockBounds(0.38f, 0.9f, 0.4f, 0.62f, 1.0f, 0.6f);
			break;
		case 7:
			this.setBlockBounds(0.38f, 0.9f, 0.4f, 0.62f, 1.0f, 0.6f);
			break;
		case 1:
			this.setBlockBounds(0.0f, 0.38f, 0.38f, 0.1f, 0.62f, 0.62f);
			break;
		case 2:
			this.setBlockBounds(0.9f, 0.38f, 0.38f, 1.0f, 0.62f, 0.62f);
			break;
		case 3:
			this.setBlockBounds(0.38f, 0.38f, 0.0f, 0.62f, 0.62f, 0.1f);
			break;
		case 4:
			this.setBlockBounds(0.38f, 0.38f, 0.9f, 0.62f, 0.62f, 1.0f);
			break;
		case 5:
			this.setBlockBounds(0.38f, 0.0f, 0.38f, 0.62f, 0.1f, 0.62f);
			break;
		case 6:
			this.setBlockBounds(0.38f, 0.0f, 0.38f, 0.62f, 0.1f, 0.62f);
			break;

		}
	}
	
	@Override
	public void setBlockBoundsForItemRender()
	{
		this.setBlockBounds(0.38f, 0.0f, 0.38f, 0.62f, 0.1f, 0.62f);
	}

}
