package liquibase.database.core;

/**
 * @author pony
 * @time 22:11
 */
public class DM8Database extends OracleDatabase {

    @Override
    public String getDefaultDriver(String s) {
        return "dm.jdbc.driver.DmDriver";
    }

    @Override
    public String getShortName() {
        return "dm";
    }

    @Override
    protected String getDefaultDatabaseProductName() {
        return "DM";
    }

    @Override
    public Integer getDefaultPort() {
        return 5236;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DEFAULT;
    }
}
