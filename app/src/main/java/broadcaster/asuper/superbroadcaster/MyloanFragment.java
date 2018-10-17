package broadcaster.asuper.superbroadcaster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyloanFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_myloan2, container, false);

        final List<AudioBooklist> myloan = new ArrayList<>();
        myloan.add(new AudioBooklist ("A Game of Thrones: Book One", "By: George R.R. Martin", "22 days left", R.drawable.books_0008 ));
        myloan.add(new AudioBooklist("Run for Your Life", "By: William Pullen", "14 day left", R.drawable.my_loans_book_2));
        myloan.add(new AudioBooklist("Astrophysics for People in a Hurry", "By: Neil deGrasse Tyson", "21 day left", R.drawable.my_loans_book_3));

        ListView listView = view.findViewById(R.id.mainMain);
        ArrayAdapter<AudioBooklist> customAdapter = new CustomMyloanAdapter (getActivity(), android.R.layout.simple_list_item_1, myloan.toArray());
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MyLoan", "Item On Click Event fired");
                Intent intent = new Intent(getActivity(), MediaPlayerActivity.class);
                startActivity(intent);
            }
        });
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

            AudioBooklist currentBook = (AudioBooklist) allloans[position];

            ImageView image = view.findViewById(R.id.imageView);
            image.setImageResource(currentBook.getImage());
            TextView title = view.findViewById(R.id.titleView);
            title.setText(currentBook.getTitle());
            TextView author = view.findViewById(R.id.authorview);
            author.setText(currentBook.getAuthor());
            TextView time= view.findViewById(R.id.timeview);
            time.setText(currentBook.getTimeTime());

            return view;
        }
    }

}
