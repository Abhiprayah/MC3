package com.example.abhi.mcassignment3;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileFragment extends Fragment {

    String filename = "about_me";
    EditText aboutMeText;
    public FileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FileFragment.
     */
    public static FileFragment newInstance() {
        FileFragment fragment = new FileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("File", "Inside OnCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("File", "Inside OnCreateView");
        return inflater.inflate(R.layout.fragment_file, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        view.findViewById(R.id.saveFileButton).setOnClickListener(saveFileButtonListener);
        aboutMeText = (EditText) view.findViewById(R.id.aboutMeText);
        String aboutme = null;
        try{
            FileInputStream inputStream = getActivity().openFileInput(filename);
            byte b[] = new byte[10000];
            inputStream.read(b);
            aboutme = new String(b, "UTF-8");

        }catch (java.io.FileNotFoundException ex){}
        catch (Exception ex){
            ex.printStackTrace();
        }
        if(aboutme != null) aboutMeText.setText(aboutme);
        Log.d("File", "Inside OnActivityCreated");
    }

    private final View.OnClickListener saveFileButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FileOutputStream outputStream;
            try{
                outputStream = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(aboutMeText.getText().toString().getBytes());
                outputStream.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            Log.d("File", "Inside saveFileButtonListener");
        }
    };
}
