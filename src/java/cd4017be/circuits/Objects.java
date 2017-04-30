package cd4017be.circuits;

import multiblock.IntegerComp;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import cd4017be.api.Capabilities;
import cd4017be.api.recipes.RecipeScriptContext.ConfigConstants;
import cd4017be.circuits.block.*;
import cd4017be.circuits.item.*;
import cd4017be.circuits.tileEntity.Assembler;
import cd4017be.circuits.tileEntity.Circuit;
import cd4017be.lib.BlockItemRegistry;
import cd4017be.lib.DefaultItemBlock;
import cd4017be.lib.TileBlock;
import cd4017be.lib.templates.BlockPipe;

public class Objects {

	//Capabilities
	@CapabilityInject(IntegerComp.class)
	public static Capability<IntegerComp> RS_INTEGER_CAPABILITY = null;

	//Creative Tabs
	public static CreativeTabs tabCircuits;

	//Blocks
	public static TileBlock designer;
	public static TileBlock programmer;
	public static TileBlock assembler;
	public static TileBlock circuit;
	public static BlockPipe rsp8bit;
	public static BlockRSPipe1 rsp1bit;
	public static TileBlock lever8bit;
	public static TileBlock display8bit;
	public static TileBlock blockSensor;
	public static TileBlock oszillograph;
	public static TileBlock potentiometer;
	public static TileBlock bitShifter;
	public static TileBlock fluidValve;
	public static TileBlock energyValve;
	public static TileBlock wirelessCon;
	public static BlockInvConnector invConnector;

	//Items
	public static ItemProgramm circuitPlan;
	public static ItemItemSensor itemSensor;
	public static ItemFluidSensor fluidSensor;
	public static ItemEnergySensor energySensor;
	public static ItemTimeSensor timeSensor;

	/** creates and registers them all */
	public static void init() {
		tabCircuits = new CreativeTabCircuits("circuits");
		
		Capabilities.registerIntern(IntegerComp.class);
		
		new DefaultItemBlock((designer = TileBlock.create("designer", Material.ROCK, SoundType.STONE, 0x1)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((assembler = TileBlock.create("assembler", Material.ROCK, SoundType.STONE, 0x1)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new ItemCircuit((circuit = new BlockCircuit("circuit", Material.ROCK, SoundType.STONE)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((lever8bit = TileBlock.create("lever8bit", Material.ROCK, SoundType.STONE, 0x11)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((potentiometer = TileBlock.create("potentiometer", Material.ROCK, SoundType.STONE, 0x11)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((display8bit = TileBlock.create("display8bit", Material.ROCK, SoundType.STONE, 0x1)).setCreativeTab(tabCircuits).setLightLevel(0.375F).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((blockSensor = TileBlock.create("blockSensor", Material.ROCK, SoundType.STONE, 0x10)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((oszillograph = TileBlock.create("oszillograph", Material.ROCK, SoundType.STONE, 0x1)).setCreativeTab(tabCircuits).setLightLevel(0.375F).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((rsp8bit = new BlockPipe("rsp8bit", Material.IRON, SoundType.METAL, 0x10)).setCreativeTab(tabCircuits).setHardness(1.0F).setResistance(10F));
		rsp8bit.size = 0.5F;
		new ItemRSPipe((rsp1bit = new BlockRSPipe1("rsp1bit", Material.IRON, SoundType.METAL)).setCreativeTab(tabCircuits).setHardness(1.0F).setResistance(10F));
		new DefaultItemBlock((bitShifter = TileBlock.create("bitShifter", Material.IRON, SoundType.METAL, 0x32)).setBlockBounds(new AxisAlignedBB(0.25, 0.25, 0.0, 0.75, 0.75, 1.0)).setCreativeTab(tabCircuits).setHardness(1.0F).setResistance(10F));
		new DefaultItemBlock((fluidValve = TileBlock.create("fluidValve", Material.IRON, SoundType.METAL, 0x12)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((energyValve = TileBlock.create("energyValve", Material.IRON, SoundType.METAL, 0x12)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((invConnector = new BlockInvConnector("invConnector", Material.GLASS, SoundType.GLASS)).setCreativeTab(tabCircuits).setHardness(0.5F).setResistance(10F));
		new ItemWirelessCon((wirelessCon = TileBlock.create("wirelessCon", Material.IRON, SoundType.METAL, 0x62)).setBlockBounds(new AxisAlignedBB(0.25, 0.25, 0.0, 0.75, 0.75, 0.875)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		new DefaultItemBlock((programmer = TileBlock.create("programmer", Material.WOOD, SoundType.WOOD, 0x1)).setCreativeTab(tabCircuits).setHardness(1.5F).setResistance(10F));
		
		(circuitPlan = new ItemProgramm("circuitPlan")).setCreativeTab(tabCircuits);
		(itemSensor = new ItemItemSensor("itemSensor")).setCreativeTab(tabCircuits);
		(fluidSensor = new ItemFluidSensor("fluidSensor")).setCreativeTab(tabCircuits);
		(energySensor = new ItemEnergySensor("energySensor")).setCreativeTab(tabCircuits);
		(timeSensor = new ItemTimeSensor("timeSensor")).setCreativeTab(tabCircuits);
	}

	public static void initConstants(ConfigConstants c) {
		c.getVect("circuit_ticks", Circuit.ClockSpeed);
		itemSensor.RangeSQ = c.getNumber("itemSensor_rangeSQ", 20);
		itemSensor.RangeSQ *= itemSensor.RangeSQ;
		fluidSensor.RangeSQ = c.getNumber("fluidSensor_rangeSQ", 20);
		fluidSensor.RangeSQ *= fluidSensor.RangeSQ;
		energySensor.RangeSQ = c.getNumber("energySensor_rangeSQ", 20);
		energySensor.RangeSQ *= energySensor.RangeSQ;
		timeSensor.RangeSQ = c.getNumber("timeSensor_rangeSQ", 20);
		timeSensor.RangeSQ *= timeSensor.RangeSQ;
		Assembler.materials[0] = BlockItemRegistry.stack("m.IORelay", 1);
		Assembler.materials[1] = BlockItemRegistry.stack("m.RAMPlate", 1);
		Assembler.materials[2] = BlockItemRegistry.stack("m.LogicPrc", 1);
		Assembler.materials[3] = BlockItemRegistry.stack("m.CalcPrc", 1);
	}
}
