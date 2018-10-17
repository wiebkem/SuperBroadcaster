package broadcaster.asuper.superbroadcaster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SnippetShelf extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snippet_shelf, container, false);

        Button shareButton = view.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), UnsharedSnippetActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        List<AudioBook> snippets = new ArrayList<AudioBook>();
        snippets.add(new AudioBook("Fear", "Wiebke", "Gothenburg Library", "http://t3.gstatic.com/images?q=tbn:ANd9GcRHWAMfKObxh8wCgY3MljQ36bhjNN7bDYlDTmTMRiKav40mtmw6"));
        snippets.add(new AudioBook("Title", "Wiebke", "Gothenburg Library", "http://t3.gstatic.com/images?q=tbn:ANd9GcRHWAMfKObxh8wCgY3MljQ36bhjNN7bDYlDTmTMRiKav40mtmw6"));
        snippets.add(new AudioBook("Fear2", "Wiebke", "Gothenburg Library", "http://t3.gstatic.com/images?q=tbn:ANd9GcRHWAMfKObxh8wCgY3MljQ36bhjNN7bDYlDTmTMRiKav40mtmw6"));
        snippets.add(new AudioBook("Title2", "Wiebke", "Gothenburg Library", "http://t3.gstatic.com/images?q=tbn:ANd9GcRHWAMfKObxh8wCgY3MljQ36bhjNN7bDYlDTmTMRiKav40mtmw6"));

        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<AudioBook> bookAdapter = new CustomSnippetAdapter(getActivity(), android.R.layout.simple_list_item_1, snippets.toArray());
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO
            }
        });

        return view;
    }

    class CustomSnippetAdapter extends ArrayAdapter {
        private Object[] allSnippets;

        public CustomSnippetAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
            super(context, resource, objects);

            this.allSnippets = objects;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_snippet_adapter_layout, null);

            // set the book title
            AudioBook currentBook = (AudioBook) allSnippets[position];
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
