package net.oupanyu;

import net.fabricmc.api.ModInitializer;
import net.oupanyu.Blocks.blockinit;
import net.oupanyu.Items.iteminit;
import net.oupanyu.generates.geninit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("MO-Remake");

	@Override
	public void onInitialize(){
		//new ItemLoader();
		new geninit();
		iteminit.init();
		new blockinit();
  }
}
