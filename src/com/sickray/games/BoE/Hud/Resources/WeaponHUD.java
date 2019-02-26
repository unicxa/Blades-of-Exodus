package com.sickray.games.BoE.Hud.Resources;

public class WeaponHUD {
	   int ammo;
	int ammoCount;
	
	boolean isSemeAuto, isMelee;
	
	
	
	{
	if(ammo == 0) {
		ammo = 250;
		}
	}
	
	
	
	public void setAmmo(int ammoCount) {
		this.ammoCount = ammoCount;
		
		 
	}
	public void setMelee(boolean isMelee) {
		this.isMelee = isMelee;
		
		 
	}
	public boolean isMelee() {
		return isMelee;
	}
	
	public int getAmmo() {
		return ammoCount;
	}
	
	

}
