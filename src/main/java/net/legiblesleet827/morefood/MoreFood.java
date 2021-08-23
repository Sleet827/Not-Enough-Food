package net.legiblesleet827.morefood;

import net.legiblesleet827.morefood.setup.ClientSetup;
import net.legiblesleet827.morefood.setup.ModSetup;
import net.legiblesleet827.morefood.setup.Registration;
import net.legiblesleet827.morefood.setup.WorldSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreFood.MODID)
public class MoreFood {
    public static final String MODID = "morefood";

    public static final Logger LOGGER = LogManager.getLogger();

    public MoreFood() {
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
