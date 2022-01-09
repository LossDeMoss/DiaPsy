package database;

/**
 * Created by LossDeMoss on 08.08.2018.
 */

public class ZamerDBSchema {
    public static final class ZamerTable {
        public static final String NAME = "zamers";

        public static  final class Cols {
            public static final String UUID = "uuid";
            public static final String BS = "bs";
            public static final String IU = "iu";
            public static final String BU = "bu";
            public static final String LIU = "liu";
            public static final String TYPE = "type";
            public static final String DATE = "date";
            public static final String YESTERDAY = "yesterday";
            public static final String TWO_DAYS_AGO = "twodaysago";
        }
    }
}
