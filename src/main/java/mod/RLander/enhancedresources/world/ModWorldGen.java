package mod.RLander.enhancedresources.world;

import mod.RLander.enhancedresources.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
	
	static Random random = new Random();
	
	private static WorldGenerator overworldGenBlatium, overworldGenClouds, netherGenVulcanium, endGenPeractio;
	
	private static int cloudNum = 0;
	
	private static int cloudCap = random.nextInt(200)+100;
	
	public ModWorldGen() {
		//Overworld
		overworldGenBlatium = new WorldGenMinable(ModBlocks.BLATIUM_ORE.getDefaultState(), random.nextInt(5)+2);
		overworldGenClouds = new WorldGenMinable(ModBlocks.CLOUD.getDefaultState(), random.nextInt(20)+15, BlockMatcher.forBlock(Blocks.AIR));

		//Nether 
		netherGenVulcanium = new WorldGenMinable(ModBlocks.VULCANIUM_ORE.getDefaultState(), random.nextInt(3)+3, BlockMatcher.forBlock(Blocks.NETHERRACK));
	
		//End
		endGenPeractio = new WorldGenMinable(ModBlocks.PERACTIO_ORE.getDefaultState(), random.nextInt(10)+9, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension())
		{
		
			case -1: 
				runGenerator(netherGenVulcanium, world, random, chunkX, chunkZ, 10, 0, 255);
				break;
			
			case 0: 
				runGenerator(overworldGenBlatium, world, random, chunkX, chunkZ, 10, 4, 20);
				runGenerator(overworldGenClouds, world, random, chunkX, chunkZ, 1, 150, 256);
				break;
				
			case 1:
				runGenerator(endGenPeractio, world, random, chunkX, chunkZ, 40, 40, 80);
				break;
		} 
	}
	
	private static void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minY, int maxY) {

		if (gen.equals(overworldGenClouds)) 
		{
			cloudNum++;
			if (cloudNum > cloudCap) 
			{
				cloudCap = random.nextInt(200)+100;
				cloudNum = 0;
				BlockPos pos = new BlockPos(chunkX*16 + rand.nextInt(16), rand.nextInt(100)+145, chunkZ*16 + rand.nextInt(16)); 
				gen.generate(world, rand, pos);
				System.out.println("gen");
			}
		} else if (gen.equals(endGenPeractio)) {
			int heightDiff = maxY - minY + 1;
			BlockPos orePos = new BlockPos(chunkX*16 + rand.nextInt(16), minY + rand.nextInt(heightDiff), chunkZ*16 + rand.nextInt(16));
			BlockPos above = new BlockPos(orePos.getX(), orePos.getY()+1, orePos.getZ());
			BlockPos below = new BlockPos(orePos.getX(), orePos.getY()-1, orePos.getZ()); 
			boolean isOpenToAir = false;
			if(world.getBlockState(above).getBlock().equals(Blocks.AIR) || world.getBlockState(below).getBlock().equals(Blocks.AIR)) isOpenToAir = true;
			if(isOpenToAir) gen.generate(world, rand, orePos);
		} else {
			int heightDiff = maxY - minY + 1;
			for(int i = 0; i<chance; i++) 
			{
				BlockPos pos = new BlockPos(chunkX*16 + rand.nextInt(16), minY + rand.nextInt(heightDiff), chunkZ*16 + rand.nextInt(16));
				gen.generate(world, rand, pos);
			}
		}
	}
}
