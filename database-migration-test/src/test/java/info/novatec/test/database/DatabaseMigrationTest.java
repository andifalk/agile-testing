package info.novatec.test.database;

/**
 * DB migration test.
 */
public class DatabaseMigrationTest extends AbstractDatabaseMigrationTest {
    
    /**
     * Constructor
     * @throws Exception
     */
    public DatabaseMigrationTest () throws Exception {
        super ();
    }

    @Override
    protected String getDataLocation () {
        return "/db/data";
    }
}
