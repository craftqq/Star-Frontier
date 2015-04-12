package io.github.awsdcrafting.passiveObjects;

import io.github.craftqq.passiveObjects.PassiveWaffe;
import io.github.craftqq.passiveObjects.Preis;

public class Waffen 
{
	public static PassiveWaffe standardLaser = new PassiveWaffe(PassiveWaffe.WEAPON_LASER, 100, 2, 2, new Preis(0, 20, 5), 0, "Standard Laser");
	public static PassiveWaffe neutrinoGeschuetz = new PassiveWaffe(PassiveWaffe.WEAPON_CANNON, 85, 1, 6, new Preis(0, 15, 10), 0, "Neutrino Geschütz");
	public static PassiveWaffe plasmaKanone = new PassiveWaffe(PassiveWaffe.WEAPON_CANNON, 93, 5, 3, new Preis(0, 17, 13), 1, "Plasma Kanone");
	public static PassiveWaffe uranGeschuetz = new PassiveWaffe(PassiveWaffe.WEAPON_CANNON, 85, 4, 2, new Preis(0, 10, 5), 0, "Uran Geschütz");
	public static PassiveWaffe bombe250KG = new PassiveWaffe(PassiveWaffe.WEAPON_BOMB, 95, 1, 25, new Preis(0, 20, 15), 1, "250Kg Bombe");
	public static PassiveWaffe bombe500KG = new PassiveWaffe(PassiveWaffe.WEAPON_BOMB, 90, 1, 50, new Preis(0, 30, 25), 1, "500Kg Bombe");
	public static PassiveWaffe torpedo = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 75, 4, 30, new Preis(0, 20, 20), 1, "Torpedo");
	public static PassiveWaffe javaRakete = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 87, 3, 15, new Preis(0, 20, 15), 1, "Java Rakete");
	public static PassiveWaffe leechRakete = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 90, 6, 12, new Preis(0, 30, 20), 1, "Leech Rakete");
	public static PassiveWaffe stingrayRakete = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 85, 4, 18, new Preis(0, 35, 15), 1, "Stingray Rakete");
	public static PassiveWaffe zsRakete = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 100, 5, 15, new Preis(0, 40, 25), 1, "Zielsuchende Rakete");
	public static PassiveWaffe heRakete = new PassiveWaffe(PassiveWaffe.WEAPON_ROCKET, 80, 4, 23, new Preis(0, 40, 25), 1, "Hochexplosive Rakete");
	
}
