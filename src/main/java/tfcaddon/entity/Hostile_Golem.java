package tfcaddon.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.bioxx.tfc.Entities.Mobs.EntityIronGolemTFC;

public class Hostile_Golem extends 
EntityIronGolemTFC{
//EntityIronGolem{
	
	public Hostile_Golem(World par1World)
	{
		super(par1World);

		for (Object a : this.targetTasks.taskEntries.toArray())
		{
			EntityAIBase ai = ((EntityAITaskEntry) a).action;
			this.targetTasks.removeTask(ai);
		}		

		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected boolean canDespawn()
    {
        return true;
    }
	
	@Override
	protected void collideWithEntity(Entity p_82167_1_)
    {
		p_82167_1_.applyEntityCollision(this);
    }

}
