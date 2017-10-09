module org.wildcraft.jpms.spi.vendor {
    requires org.wildcraft.jpms.spi.agent;
    provides org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider with org.wildcraft.jpms.spi.vendor.CafeDayCoffeeProvider;
}