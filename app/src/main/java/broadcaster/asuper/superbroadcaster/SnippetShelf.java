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
import android.widget.GridView;
import android.widget.ImageView;
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

        List<AudioBook> snippets = new ArrayList<>();
        snippets.add(new AudioBook("A Game of Thrones", "Jan", "Lundby", R.drawable.books_0001));
        snippets.add(new AudioBook("Abyss", "Aksel", "Haga", R.drawable.books_0002));
        snippets.add(new AudioBook("The Spear of Stars", "Wiebke", "City", R.drawable.books_0003));
        snippets.add(new AudioBook("Fear", "Zihua", "Haga", R.drawable.books_0004));
        snippets.add(new AudioBook("Holy Gost", "Aksel", "Majorna", R.drawable.books_0005));
        snippets.add(new AudioBook("Harry Potter and the Sorcerer's Stone", "Gunn", "Lundby", R.drawable.books_0006));

        GridView gridView = view.findViewById(R.id.gridView);
        ArrayAdapter<AudioBook> bookAdapter = new CustomSnippetAdapter(getActivity(), android.R.layout.simple_list_item_1, snippets.toArray());
        gridView.setAdapter(bookAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

            AudioBook currentBook = (AudioBook) allSnippets[position];

            ImageView image = view.findViewById(R.id.imageView);
            image.setImageResource(currentBook.getImage());
            TextView title = view.findViewById(R.id.titleView);
            title.setText(currentBook.getTitle());
            TextView user = view.findViewById(R.id.userView);
            user.setText("Snippet by " + currentBook.getUser());
            TextView location = view.findViewById(R.id.locationView);
            location.setText(currentBook.getLocation() + " Library");

            return view;
        }
    }
}
