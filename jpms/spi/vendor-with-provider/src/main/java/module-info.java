module org.wildcraft.jpms.spi.vendorwithprovider {
    requires org.wildcraft.jpms.spi.agent;
    provides org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider with org.wildcraft.jpms.spi.vendorwithprovider.MadrasCoffeeProviderFactory;
}