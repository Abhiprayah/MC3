package com.example.abhi.mcassignment3;


import android.app.Fragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SqlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SqlFragment extends Fragment {

    private SQLiteDatabase db;
    private final static String TAG = "sql";
    private EditText nameText;
    private EditText numberText;
    ContactdbHelper myDBHelper;

    public SqlFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SqlFragment.
     */
    public static SqlFragment newInstance() {
        SqlFragment fragment = new SqlFragment();
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
        return inflater.inflate(R.layout.fragment_sql, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        myDBHelper = new ContactdbHelper(getActivity());
        db = myDBHelper.getWritableDatabase();
        View view = getView();
        nameText = (EditText) view.findViewById(R.id.sqlNameText);
        numberText = (EditText) view.findViewById(R.id.sqlNumberText);
        view.findViewById(R.id.insertButton).setOnClickListener(insertButtonListener);
        view.findViewById(R.id.deleteButton).setOnClickListener(deleteButtonListener);
        view.findViewById(R.id.updateButton).setOnClickListener(updateButtonListener);
        Log.d(TAG, "Inside onActivityCreated");
    }

    private final View.OnClickListener insertButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put(Contact.ContactEntry.COLUMN_NAME_NAME, nameText.getText().toString());
            values.put(Contact.ContactEntry.COLUMN_NAME_NUMBER, numberText.getText().toString());
            db.insert(Contact.ContactEntry.TABLE_NAME, null, values);
            Log.d(TAG, "Inside insertButtonListener");
        }
    };

    private final View.OnClickListener updateButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put(Contact.ContactEntry.COLUMN_NAME_NAME, nameText.getText().toString());
            values.put(Contact.ContactEntry.COLUMN_NAME_NUMBER, numberText.getText().toString());

            String select = Contact.ContactEntry.COLUMN_NAME_NAME + " = '" + nameText.getText().toString() + "'";

            db.update(Contact.ContactEntry.TABLE_NAME, values, select, null);
            Log.d(TAG, "Inside updateButtonListener");
        }
    } ;

    private final View.OnClickListener deleteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String select = Contact.ContactEntry.COLUMN_NAME_NAME + " = '" + nameText.getText().toString() + "'";
            db.delete(Contact.ContactEntry.TABLE_NAME, select, null);
            Log.d(TAG, "Inside deleteButtonListener");
        }
    };
}
