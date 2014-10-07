package info.novatec.test.database;

import org.flywaydb.core.Flyway;

/**
 * Main class for migrating the database.
 */
public class MigrateDatabase {
    public static void main( String[] args ) {
        Flyway flyway = new Flyway ();
        flyway.setDataSource("jdbc:postgresql:testdb", "postgres", "postgres");
        flyway.clean ();
        flyway.migrate ();
    }
}
