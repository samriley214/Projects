import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BhmDatabase {

    /**
     * Handles an input query. Delegates this to the
     * handleSelectQuery method.
     * @param db - 2D array of info.
     * @param query - query to make.
     * @return results of query.
     */
    static List<String> query(String[][] db, String query) {
        return handleSelectQuery(db, query);
    }

    /**
     * Handles a SELECT query and returns the result of the query.
     *
     * SELECT <n> WHERE <predicate>
     *
     * A Predicate is one of:
     * - <header> <comparator> <value>
     *
     * A Comparator is one of:
     * - =
     * - !=
     * - >
     * - <
     * - >=
     * - <=
     * - LIKE
     *
     * A Value is one of:
     * - 'Number'
     * - 'String'
     * - '%String'
     * - 'String%'
     * - '%String%'
     *
     * @param db - the database to query.
     * @param query - the query to execute.
     * @return the result of the query.
     */
    private static List<String> handleSelectQuery(String[][] db, String query) {
        // TODO. You may want to write other helper methods to solve thiS!
        return null;
    }
}

