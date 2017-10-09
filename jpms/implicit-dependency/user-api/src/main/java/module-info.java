import org.wildcraft.jpms.versioning.api.Version;

@Version(major = 1, minor = 0)
module org.wildcraft.jpms.implicit.user.api {
    requires org.wildcraft.jpms.versioning.api;

    //uses org.wildcraft.jpms.versioning.api.provider.ServiceProviderSelectorProvider;

    uses org.wildcraft.jpms.implicit.user.api.provider.UserServiceProvider;

    provides org.wildcraft.jpms.implicit.user.api.provider.UserServiceProvider with org.wildcraft.jpms.implicit.user.api.provider.impl.UserServiceProviderImpl;

    exports org.wildcraft.jpms.implicit.user.api;
    exports org.wildcraft.jpms.implicit.user.api.resources;
}