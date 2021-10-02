package net.legiblesleet827.nef;

import net.legiblesleet827.nef.setup.ClientSetup;
import net.legiblesleet827.nef.setup.ModSetup;
import net.legiblesleet827.nef.setup.Registration;
import net.legiblesleet827.nef.setup.WorldSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(NotEnoughFood.MODID)
public class NotEnoughFood {
    public static final String MODID = "nef";

    public static final Logger LOGGER = LogManager.getLogger();

    public NotEnoughFood() {
        GeckoLib.initialize();
        Registration.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(ClientSetup::setup);
        bus.addListener(ModSetup::onAttributeCreate);

        MinecraftForge.EVENT_BUS.addListener(WorldSetup::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}
}
