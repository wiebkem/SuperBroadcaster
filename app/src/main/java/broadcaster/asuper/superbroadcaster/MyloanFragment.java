package broadcaster.asuper.superbroadcaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.ClipData.Item;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyloanFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_myloan2, container, false);

        Button shareButton = view.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), UnsharedSnippetActivity.class);
                getActivity().startActivity(myIntent);
            }
        });


        List<AudioBooklist> myloan = new ArrayList<AudioBooklist>();
        myloan.add(new AudioBooklist (" A Game of Thrones: Book One", "By: George R.R. Martin", "22 days left", R.drawable.image1 ));
        myloan.add(new AudioBooklist("Run for Your Life", "By: William Pullen", "14 day left", R.drawable.my_loans_book_2));
        myloan.add(new AudioBooklist("Astrophysics for People in a Hurry", "By: Neil deGrasse Tyson", "21 day left", R.drawable.my_loans_book_3));

        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<AudioBook> bookAdapter = new CustomMyloanAdapter (getActivity(), android.R.layout.simple_list_item_1, myloan.toArray());
        listView.setAdapter(bookAdapter);
        // Inflate the layout for this fragment

       // String [] menuItems = {"Game of thrones:Book one", "Abyss:Book two", "The spear of stars"};

        //ListView listView = (ListView) view.findViewById(R.id.mainMain);

        //ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(

                //getActivity(),
                //android.R.layout.simple_list_item_1,
                //menuItems
        //);

        //listView.setAdapter(listViewAdapter);
        return view;


    }

    class CustomMyloanAdapter extends ArrayAdapter {
        private Object[] allloans;

        public CustomMyloanAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
            super(context, resource, objects);

            this.allloans = objects;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_myloan_adapter_layout, null);

            // set the book title
            AudioBook currentBook = (AudioBook) allloans[position];
            TextView title = view.findViewById(R.id.titleView);
            title.setText(currentBook.getTitle());
            TextView user = view.findViewById(R.id.userView);
            user.setText(currentBook.getUser());
            TextView location = view.findViewById(R.id.locationView);
            location.setText(currentBook.getLocation());

            return view;
        }
    }


}
