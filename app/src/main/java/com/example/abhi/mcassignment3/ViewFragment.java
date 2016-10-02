package com.example.abhi.mcassignment3;


import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment {
    private SQLiteDatabase db;
    private final static String TAG = "view";
    ContactdbHelper myDBHelper;
    TextView contacts;

    public ViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ViewFragment.
     */
    public static ViewFragment newInstance() {
        ViewFragment fragment = new ViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "Inside onCreateView");
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    public void onActivityCreated(Bundle savedInstaceState){
        super.onActivityCreated(savedInstaceState);
        myDBHelper = new ContactdbHelper(getActivity());
        db = myDBHelper.getWritableDatabase();
        View view = getView();
        contacts = (TextView) view.findViewById(R.id.ContactsList);

        String[] projection = {
                Contact.ContactEntry._ID,
                Contact.ContactEntry.COLUMN_NAME_NAME,
                Contact.ContactEntry.COLUMN_NAME_NUMBER
        };

        String sortOrder = Contact.ContactEntry.COLUMN_NAME_NAME + " ASC";

        Cursor cursor = db.query(
                Contact.ContactEntry.TABLE_NAME,          // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        String list = "";

        while (cursor.moveToNext()){
            list += cursor.getString(cursor.getColumnIndex(Contact.ContactEntry._ID));
            list += " ";
            list += cursor.getString(cursor.getColumnIndex(Contact.ContactEntry.COLUMN_NAME_NAME));
            list += " ";
            list += cursor.getString(cursor.getColumnIndex(Contact.ContactEntry.COLUMN_NAME_NUMBER));
            list += "\n";
        }
        cursor.close();
        contacts.setText(list);

        Log.d(TAG, "Inside onActivityCreated");
    }
}
