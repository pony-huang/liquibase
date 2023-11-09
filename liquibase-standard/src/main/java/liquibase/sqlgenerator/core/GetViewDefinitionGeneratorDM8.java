package liquibase.sqlgenerator.core;

import liquibase.CatalogAndSchema;
import liquibase.database.Database;
import liquibase.database.core.DM8Database;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.statement.core.GetViewDefinitionStatement;

/**
 * @author pony
 * @time 22:20
 */
public class GetViewDefinitionGeneratorDM8 extends GetViewDefinitionGenerator {

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(GetViewDefinitionStatement statement, Database database) {
        return database instanceof DM8Database;
    }

    @Override
    public Sql[] generateSql(GetViewDefinitionStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        CatalogAndSchema schema = new CatalogAndSchema(statement.getCatalogName(), statement.getSchemaName()).customize(database);

        return new Sql[]{
                new UnparsedSql("SELECT TEXT FROM ALL_VIEWS WHERE upper(VIEW_NAME)='" + statement.getViewName().toUpperCase() + "' AND OWNER='" + schema.getSchemaName() + "'")
        };
    }
}

