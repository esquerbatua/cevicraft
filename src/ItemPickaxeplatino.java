package cevicraft;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemPickaxeplatino extends ItemToolcevi
{

	private static final Block blocksEffectiveAgainst[] = new Block[] {Block.blockEmerald, Block.oreEmerald, Block.cobblestone, Block.stairCompactCobblestone, Block.stairsBrick, Block.stairsNetherBrick, Block.stairsStoneBrickSmooth, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.redstoneLampActive, Block.redstoneLampIdle, Block.oreRedstone, Block.oreRedstoneGlowing,
		CommonProxy.b_coal_block, CommonProxy.b_lightsensor, CommonProxy.b_marble, CommonProxy.b_marble_ore, CommonProxy.b_normal_house, CommonProxy.b_platino_block, CommonProxy.b_platino_ore, CommonProxy.b_plutonio_block, CommonProxy.b_plutonio_ore};

    protected ItemPickaxeplatino(int i, EnumToolcevi enumtoolcevi)
    {
    	super(i, 3, enumtoolcevi, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block)
    {
	//blocks mod
    	if(block == CommonProxy.b_plutonio_block)
            return toolMaterial.getHarvestLevel() == 3;
    	if(block == CommonProxy.b_plutonio_ore)
            return toolMaterial.getHarvestLevel() == 2.5;
    	if(block == CommonProxy.b_normal_house || block == CommonProxy.b_coal_block || block == CommonProxy.b_platino_ore || block == CommonProxy.b_platino_block || block == CommonProxy.b_marble_ore || block == CommonProxy.b_marble)
            return toolMaterial.getHarvestLevel() == 1;
	//blocks minecraft
        if(block == Block.obsidian || block == Block.blockDiamond || block == Block.oreDiamond || block == Block.blockGold || block == Block.oreGold || block == Block.oreRedstone || block == Block.oreRedstoneGlowing || block == Block.oreEmerald || block == Block.blockEmerald)
            return toolMaterial.getHarvestLevel() == 1;
        if(block == Block.oreLapis || block == Block.oreLapis || block == Block.blockSteel || block == Block.oreIron)
            return toolMaterial.getHarvestLevel() >= 1;;
        if(block.blockMaterial == Material.rock)
            return true;
        return block.blockMaterial == Material.iron;
    }

    @SideOnly(Side.CLIENT)
    public String getTextureFile()
    {
        return "/cevicraft/items.png";
    }
}