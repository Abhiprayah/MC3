package com.example.abhi.mcassignment3;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SharedPreferences#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SharedPreferences extends Fragment {

    EditText nameText;
    EditText contactText;

    public SharedPreferences() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment SharedPreferences.
     */
    // TODO: Rename and change types and number of parameters
    public static SharedPreferences newInstance() {
        SharedPreferences fragment = new SharedPreferences();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        View fragView = getView();
        fragView.findViewById(R.id.saveButton).setOnClickListener(saveButtonListener);
        nameText = (EditText) fragView.findViewById(R.id.nameText);
        contactText = (EditText) fragView.findViewById(R.id.phoneText);
        android.content.SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        String name = sp.getString("Name", null);
        if(name != null) nameText.setText(name);
        String contact = sp.getString("Contact", null);
        if(contact != null) contactText.setText(contact);
        Log.d("FRAG", "Inside onActivityCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_shared_preferences, container, false);
        Log.d("FRAG", "Inside OnCreateView");
        return fragView;
    }

    private final View.OnClickListener saveButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            android.content.SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
            android.content.SharedPreferences.Editor editor = sp.edit();
            editor.putString("Name", nameText.getText().toString());
            editor.putString("Contact", contactText.getText().toString());
            editor.apply();
            Log.d("FRAG", "Inside saveButtonListener");
        }
    };
}
