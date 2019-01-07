package com.babyassistant.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.babyassistant.R;
import com.babyassistant.Response.PromoResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPageAdapter extends PagerAdapter {

    private Context mContext;
    private List<PromoResponse.Datum> mResouces;
    private LayoutInflater inflater;
    private ImageView imageView;
    private TextView tvTitlePromo;

    public ViewPageAdapter(Context context, List<PromoResponse.Datum> mResouces)
    {
        this.mContext = context;
        this.mResouces = mResouces;
    }

    @Override
    public int getCount() {
        return mResouces.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position)
    {
        ViewGroup itemView = (ViewGroup) inflater.from(viewGroup.getContext()).inflate(R.layout.pager_item, viewGroup, false);
        imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);
        tvTitlePromo = (TextView) itemView.findViewById(R.id.tvPromo_title);

        Picasso.with(mContext).load(mResouces.get(position).image_url).into(imageView);
        tvTitlePromo.setText(Html.fromHtml(mResouces.get(position).title));
        tvTitlePromo.setAllCaps(true);

        viewGroup.addView(itemView);

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup collection, int position, Object view)
    {
        collection.removeView((View) view);
    }
}
