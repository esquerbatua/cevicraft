package cevicraft;

public enum EnumToolcevi
{
    WOOD(0, 59, 2.0F, 0, 15),
    STONE(1, 131, 4F, 1, 5),
    IRON(2, 250, 6F, 2, 14),
    PLATINO(2, 500, 8F, 3, 15),
    EMERALD(3, 1561, 8F, 3, 10),
    GOLD(0, 32, 12F, 0, 22),
    CEVI(5, 100, 10000F, 10000, 10);


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;
    private static final EnumToolcevi allToolMaterials[];


    private EnumToolcevi(int par3, int par4, float par5, int par6, int par7)
    {
        harvestLevel = par3;
        maxUses = par4;
        efficiencyOnProperMaterial = par5;
        damageVsEntity = par6;
        enchantability = par7;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }

    public int getEnchantability()
    {
        return enchantability;
    }

    static 
    {
        allToolMaterials = (new EnumToolcevi[] {
            PLATINO, CEVI, WOOD, STONE, IRON, EMERALD, GOLD
        });
    }
}