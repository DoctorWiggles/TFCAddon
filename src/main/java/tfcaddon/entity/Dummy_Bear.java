package tfcaddon.entity;

import tfcaddon.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.bioxx.tfc.Entities.Mobs.EntityBear;

public class Dummy_Bear extends EntityBear{

	public Dummy_Bear(World world) {
		super(world);
	}
	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);		
		
		int ID = Block.getIdFromBlock(this.worldObj.getBlock(i, j-1, k));
		int ID2 = Block.getIdFromBlock(this.worldObj.getBlock(i, j, k));
		
		if (ID == Config.blacklist 
				|| ID2 == Config.blacklist  
				|| ID == 0
				|| ID == 52){
			return false;}
		
		return  this.worldObj.checkNoEntityCollision(this.boundingBox) 
				&& this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() 
				&& !this.worldObj.isAnyLiquid(this.boundingBox)
				&& this.worldObj.getBlock(i, j - 1, k).isNormalCube();
	}	
	
	@Override
	public void onEntityUpdate()
    {	
		if(this.worldObj.isRemote){return;}		
    	EntityBear bear = new EntityBear(this.worldObj);
    	bear.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
    	worldObj.spawnEntityInWorld(bear);
    	this.setDead();
    }

}
