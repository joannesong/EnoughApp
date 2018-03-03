package nyc.c4q.enough.data;

import android.provider.BaseColumns;

/**
 * Created by c4q on 3/3/18.
 */

public class ContactsContract {

    public static final class ContactEntries implements BaseColumns {
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CELL = "cell";
    }

}
