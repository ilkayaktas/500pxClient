package com.ilkayaktas.makemepopular.views.adapters;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.fivehundredpx.greedolayout.GreedoLayoutSizeCalculator;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.ilkayaktas.makemepopular.utils.PhotoLoader;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragment;

import java.util.List;

/**
 * Created by KD on 2/5/16.
 * <p/>
 * Adapter used to represent the items on the main grid.
 * Launched by {@link PhotosGridFragment}
 */
public class PhotoGridAdapter extends RecyclerView.Adapter<PhotoGridAdapter.ViewHolder> implements GreedoLayoutSizeCalculator.SizeCalculatorDelegate{
    private static final long CLICK_TIME_INTERVAL = 300;
    private PhotosGridFragment.PhotoItemListener mPhotoItemListener;
    private List<Photo> mPhotoList;
    private long mLastClickTime = System.currentTimeMillis();
    private Context mContext;

    public PhotoGridAdapter(PhotosGridFragment.PhotoItemListener photoItemListener,
                            List<Photo> photoList) {
        setList(photoList);
        mPhotoItemListener = photoItemListener;
        setHasStableIds(true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photogrid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // make black&white shared pictures
        if(mPhotoList.get(position).isSharedPreviously){
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
    
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.mPhotoThumb.setColorFilter(filter);
        }
        
        final String thumbUrl = mPhotoList.get(position).images.get(0).url;

        PhotoLoader.load(mContext, thumbUrl, holder.mPhotoThumb);
    }

    @Override
    public long getItemId(int position) {
        return mPhotoList.get(position).id;
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public void replaceData(List<Photo> photos) {
        setList(photos);
        notifyDataSetChanged();
    }

    @Override
    public double aspectRatioForIndex(int index) {
        // Precaution, have better handling for this in greedo-layout
        if (index >= getItemCount()) return 1.0;
        return mPhotoList.get(index).width / (double) mPhotoList.get(index).height;
    }

    private void setList(List<Photo> photos) {
        mPhotoList = photos;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.photo_thumb)
        ImageView mPhotoThumb;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            long now = System.currentTimeMillis();
            if (now - mLastClickTime < CLICK_TIME_INTERVAL) {
                return;
            }
            mLastClickTime = now;
            int position = getAdapterPosition();
            mPhotoItemListener.onPhotoClick(mPhotoList.get(position), view);
        }
    }
}
