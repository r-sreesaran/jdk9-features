import org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider;

module org.wildcraft.jpms.spi.agent {
    exports org.wildcraft.jpms.spi.agent.api;
    uses CoffeeServiceProvider;
    provides CoffeeServiceProvider with org.wildcraft.jpms.spi.agent.service.AgentCoffeeProviderImpl;
}