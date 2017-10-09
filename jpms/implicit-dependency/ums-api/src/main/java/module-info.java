import org.wildcraft.jpms.versioning.api.Version;

@Version(major = 1, minor = 0)
module org.wildcraft.jpms.implicit.ums.api {
    requires transitive org.wildcraft.jpms.versioning.api;
    requires transitive org.wildcraft.jpms.implicit.usergroup.api;
}