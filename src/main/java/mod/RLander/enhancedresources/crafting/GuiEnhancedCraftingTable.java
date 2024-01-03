package mod.RLander.enhancedresources.crafting;

import mod.RLander.enhancedresources.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEnhancedCraftingTable extends GuiContainer
{
    private static final ResourceLocation ENHANCED_CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID +":" + "textures/gui/crafting_table.png");
    private boolean widthTooNarrow;

    public GuiEnhancedCraftingTable(InventoryPlayer playerInv, World worldIn)
    {
        this(playerInv, worldIn, BlockPos.ORIGIN);
    }

    public GuiEnhancedCraftingTable(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition)
    {
        super(new ContainerEnhancedCraftingTable(playerInv, worldIn, blockPosition));
   }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRenderer.drawString(I18n.format("Enhanced Crafting"), 30, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("Inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(ENHANCED_CRAFTING_TABLE_GUI_TEXTURES);
        int i = this.guiLeft;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
    	super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}