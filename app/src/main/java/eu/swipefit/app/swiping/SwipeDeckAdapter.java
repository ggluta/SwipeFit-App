package eu.swipefit.app.swiping;
/**
 * FILE DESCRIPTION
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eu.swipefit.app.R;

/** ADD COMMENTS */
public class SwipeDeckAdapter extends BaseAdapter {

    private List<CardView> data;
    private Context context;

    public SwipeDeckAdapter(List<CardView> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            //LayoutInflater inflater = getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            // normally use a viewholder
            v = inflater.inflate(R.layout.card_view, parent, false);
        }

        ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);

        //Picasso.with(context).load(R.drawable.peter).fit().centerCrop().into(imageView);
        Picasso.with(context).load(data.get(position).mProduct.getImageUrl()).into(imageView);
        TextView textView = (TextView) v.findViewById(R.id.name_of_product);
       /* String item = (String)getItem(position);
        textView.setText(item);*/

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return v;
    }
}