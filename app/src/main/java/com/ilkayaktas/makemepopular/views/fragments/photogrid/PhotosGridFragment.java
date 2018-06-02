package com.ilkayaktas.makemepopular.views.fragments.photogrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.fivehundredpx.greedolayout.GreedoLayoutManager;
import com.fivehundredpx.greedolayout.GreedoSpacingItemDecoration;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.ilkayaktas.makemepopular.utils.AppConstants;
import com.ilkayaktas.makemepopular.utils.MeasureUtils;
import com.ilkayaktas.makemepopular.views.activities.base.BaseFragment;
import com.ilkayaktas.makemepopular.views.activities.fullphotoscreen.FullPhotoScreenActivity;
import com.ilkayaktas.makemepopular.views.adapters.PhotoAdapter;
import com.ilkayaktas.makemepopular.views.adapters.ViewPagerAdapter;
import com.ilkayaktas.makemepopular.views.widgets.gridlayout.InfiniteScrollListener;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KD on 2/5/16.
 * Fragment representing the main grid of the app.
 */
public class PhotosGridFragment extends BaseFragment implements PhotosGridFragmentMvpView, ViewPagerAdapter.OnUpdateFragment {
    private static final String BUNDLE_CATEGORY = "bundle_category";
    private static final String TAG = PhotosGridFragment.class.getSimpleName();
    private String category;

    @BindView(R.id.main_grid) RecyclerView recyclerView;
    @BindView(android.R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.main_container) FrameLayout mMainContainer;

    @Inject
    PhotosGridFragmentMvpPresenter<PhotosGridFragmentMvpView> mPresenter;

    private Snackbar mSnackbar;
    private PhotoAdapter mPhotoAdapter;

    private PhotoItemListener mPhotoItemListener = (photo, clickedView) -> ActivityCompat.startActivity(getActivity(),
            FullPhotoScreenActivity.getStartIntent(getContext(), photo), null);

    public PhotosGridFragment() {

    }

    public static PhotosGridFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_CATEGORY, category);
        PhotosGridFragment fragment = new PhotosGridFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        mPhotoAdapter = new PhotoAdapter(getActivity(), new ArrayList<Photo>(0), mPhotoItemListener);

        category = getArguments().getString(BUNDLE_CATEGORY);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final GreedoLayoutManager layoutManager = new GreedoLayoutManager(mPhotoAdapter);
        layoutManager.setMaxRowHeight(MeasureUtils.dpToPx(AppConstants.MAX_ROW_HEIGHT, getActivity()));

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mPhotoAdapter);

        int spacing = MeasureUtils.dpToPx(4, getActivity());
        recyclerView.addItemDecoration(new GreedoSpacingItemDecoration(spacing));


        recyclerView.addOnScrollListener(new InfiniteScrollListener(layoutManager) {
            @Override
            public void onLastItemReached() {
                mPresenter.fetchPhotos(category, true);
            }
        });

    }

    @Override
    protected int getTitle() {
        return 0;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_photogrid;
    }

    @Override
    public void updateGridAdapter(List<Photo> photos) {
        mPhotoAdapter.replaceData(photos);
    }

    @Override
    public void updateGridAdapter(Photo photo) {
        mPhotoAdapter.attachData(photo);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showError() {
        mSnackbar = Snackbar.make(mMainContainer, R.string.problem_on_loading,
                Snackbar.LENGTH_INDEFINITE);
//                .setAction(R.string.action_try_again, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mSnackbar.dismiss();
//                        setLoadingIndicator(false);
//                        mPresenter.fetchPhotos(category, true);
//                    }
//                });
        mSnackbar.show();
    }

    @Override
    public void dismissSnackbar() {
        if (mSnackbar != null) mSnackbar.dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onDetach();
    }

    /**
     * When fragment is selected on ViewPager, Fragment is notified with this method.
     */
    @Override
    public void updateFragment() {
        mPresenter.fetchPhotos(category, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public interface PhotoItemListener {
        void onPhotoClick(Serializable photo, View clickedView);
    }
}
