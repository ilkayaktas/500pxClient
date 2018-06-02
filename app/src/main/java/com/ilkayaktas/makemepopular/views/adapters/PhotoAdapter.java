package com.ilkayaktas.makemepopular.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fivehundredpx.greedolayout.GreedoLayoutSizeCalculator;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.utils.PhotoLoader;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragment;

import java.util.List;

/**
 * Created by iaktas on 28.09.2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> implements GreedoLayoutSizeCalculator.SizeCalculatorDelegate {
    private final String TAG = "PhotoAdapter";
    private PhotosGridFragment.PhotoItemListener mPhotoItemListener;
    private List<Photo> mPhotoList;
    private Context mContext;

    public PhotoAdapter(Context context, List<Photo> mPhotoList, PhotosGridFragment.PhotoItemListener mPhotoItemListener) {
        this.mContext = context;
        this.mPhotoList = mPhotoList;
        this.mPhotoItemListener = mPhotoItemListener;
    }

    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        return new PhotoViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoViewHolder holder, int position) {

        final String thumbUrl = mPhotoList.get(position).images.get(0).url;

        PhotoLoader.load(mContext, thumbUrl, holder.mPhotoThumb);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    @Override
    public double aspectRatioForIndex(int i) {
        if (i >= getItemCount()) return 1.0;
        return (double)mPhotoList.get(i).width / (double)mPhotoList.get(i).height;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mPhotoThumb;

        public PhotoViewHolder(ImageView imageView) {
            super(imageView);
            mPhotoThumb = imageView;
            mPhotoThumb.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mPhotoItemListener.onPhotoClick(mPhotoList.get(position), view);
        }
    }

    public void replaceData(List<Photo> photos) {
        setList(photos);
        notifyDataSetChanged();
    }

    public void attachData(Photo photo){
        for (Photo p : mPhotoList) {
            if(p.id == photo.id) return; // photo already exits
        }

        Log.d(TAG, "attachData: " + photo.id);
        mPhotoList.add(photo);
        notifyDataSetChanged();
    }

    private void setList(List<Photo> photos) {
        mPhotoList = photos;
    }

}
