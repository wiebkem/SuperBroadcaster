package broadcaster.asuper.superbroadcaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.ClipData.Item;


public class MyloanFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_myloan2, container, false);
        // Inflate the layout for this fragment

        String [] menuItems = {"Game of thrones:Book one", "Abyss:Book two", "The spear of stars"};

        ListView listView = (ListView) view.findViewById(R.id.mainMain);

        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(

                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);
        return view;


    }
   



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
