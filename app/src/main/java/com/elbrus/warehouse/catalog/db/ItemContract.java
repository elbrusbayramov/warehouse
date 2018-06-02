package com.elbrus.warehouse.catalog.db;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the Items app.
 */
public final class ItemContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private ItemContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.elbrus.warehouse.catalog";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.elbrus.warehouse.catalog/catalog/ is a valid path for
     * looking at catalog data. content://com.elbrus.warehouse.catalog/something/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "something".
     */
    public static final String PATH_ITEMS = "items";

    /**
     * Inner class that defines constant values for the warehouse database table.
     * Each entry in the table represents a single item.
     */
    public static final class ItemEntry implements BaseColumns {

        /** The content URI to access the warehouse data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEMS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of items.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;

        /** Name of database table for items */
        public final static String TABLE_NAME = "catalog";

        /**
         * Unique ID number for the item (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the item.
         *
         * Type: TEXT
         */
        public final static String COLUMN_ITEM_NAME ="name";

        /**
         * Brand of the item.
         *
         * Type: TEXT
         */
        public final static String COLUMN_ITEM_BRAND = "brand";

        /**
         * Price of item.
         *
         *
         *
         * Type: INTEGER
         */
        public final static String COLUMN_ITEM_PRICE = "price";

        /**
         * amount of items existing in warehouse.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_ITEM_AMOUNT = "amount";
        /**
         * Possible values for the price of the item.
         */
        public static final int PRICE_LOW = 0;
        public static final int PRICE_HIGH = 1;
        public static final int PRICE_MIDDLE = 2;
    }




}
