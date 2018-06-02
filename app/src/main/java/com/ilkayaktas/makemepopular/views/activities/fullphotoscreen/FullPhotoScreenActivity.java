package com.ilkayaktas.makemepopular.views.activities.fullphotoscreen;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.github.chrisbanes.photoview.PhotoView;
import com.ilkayaktas.makemepopular.controller.api.fivehundredpx.model.photo.Photo;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.ilkayaktas.makemepopular.utils.PhotoLoader;
import com.ilkayaktas.makemepopular.views.activities.base.BaseActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;
import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;
import permissions.dispatcher.*;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ilkay on 02/08/2017.
 */

@RuntimePermissions
public class FullPhotoScreenActivity extends BaseActivity implements FullPhotoScreenMvpView {
    private static final String TAG = FullPhotoScreenActivity.class.getSimpleName();
    private static final String SHARE_PHOTO = TAG + ".PHOTO_URL";

    @BindView(R.id.iv_fullphotoscreen_photo) PhotoView photoView;
    @BindView(R.id.fab_fullphotoscreen_share) FabSpeedDial fabSpeedDial;
    @BindView(R.id.tv_full_actionbartitle) TextView actionBartitle;
    @BindView(R.id.tv_full_peopleliked) TextView peopleLiked;
    @BindView(R.id.iv_full_favicon)SparkButton favoryIcon;

    @Inject
    FullPhotoScreenMvpPresenter<FullPhotoScreenMvpView> mPresenter;
    private Photo photo;

    public static Intent getStartIntent(Context context, Serializable photo) {
        Intent starter = new Intent(context, FullPhotoScreenActivity.class);
        starter.putExtra(SHARE_PHOTO, photo);
        return starter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        // Attach presenter
        mPresenter.onAttach(FullPhotoScreenActivity.this);

        photo = (Photo) getIntent().getSerializableExtra(SHARE_PHOTO);
        actionBartitle.setText(photo.name);
        peopleLiked.setText(photo.positiveVotesCount + " people like this photo in 500px.");
        String photoUrl = photo.images.get(1).url;

        PhotoLoader.load(this,photoUrl,photoView);

        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_download:
                        FullPhotoScreenActivityPermissionsDispatcher.downloadImageWithPermissionCheck(FullPhotoScreenActivity.this, photo);
                        break;
                    case R.id.action_share:
                        shareOnInstagram(photo);
                        break;
                    case R.id.action_wallpaper:
                        FullPhotoScreenActivityPermissionsDispatcher.setAsWallpaperWithPermissionCheck(FullPhotoScreenActivity.this, photo);
                        break;
                }
                return false;
            }
        });

        prepareFavoryButton();
    }

    @NeedsPermission({Manifest.permission.SET_WALLPAPER, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void setAsWallpaper(Photo photo){
        String photoUrl = photo.images.get(1).url;

        Picasso.with(getApplicationContext())
                .load(photoUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                File file = new File(Environment.getExternalStorageDirectory()
                                        + "/"+ Environment.DIRECTORY_PICTURES +
                                        "/" + "500PX_IMG_" + System.currentTimeMillis() + ".png");
                                try {
                                    boolean b = file.createNewFile();
                                    FileOutputStream ostream = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                                    ostream.flush();
                                    ostream.close();

                                    Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
                                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                                    intent.setDataAndType(getLocalBitmapUri(bitmap), "image/*");
                                    intent.putExtra("mimeType", "image/*");
                                    FullPhotoScreenActivity.this.startActivity(Intent.createChooser(intent, "Set as:"));

                                } catch (IOException e) {
                                    Log.e("IOException", e.getLocalizedMessage());
                                }
                            }
                        }).start();


                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                    }
                });
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void downloadImage(Photo photo){
        String photoUrl = photo.images.get(1).url;

        Picasso.with(getApplicationContext())
                .load(photoUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
    
                        FullPhotoScreenActivity.this.runOnUiThread(() -> {
    
                            File file = new File(Environment.getExternalStorageDirectory()
                                    + "/"+ Environment.DIRECTORY_PICTURES +
                                    "/" + "500PX_IMG_" + System.currentTimeMillis() + ".png");
                            try {
                                boolean b = file.createNewFile();
                                FileOutputStream ostream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                                ostream.flush();
                                ostream.close();
        
                                Toast.makeText(FullPhotoScreenActivity.this, "Downloaded:\n"+file.getPath(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                Log.e("IOException", e.getLocalizedMessage());
                            }
                        });
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                    }
                });
    }

    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage(R.string.permission_writeexternalstorage_rationale)
                .setPositiveButton(R.string.button_allow, (dialog, button) -> request.proceed())
                .setNegativeButton(R.string.button_deny, (dialog, button) -> request.cancel())
                .show();
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showDeniedForCamera() {
        Toast.makeText(this, getString(R.string.permission_writeexternalstorage_rationale), Toast.LENGTH_SHORT).show();
    }

    public void shareOnInstagram(Photo photo) {

        // save shared photo
        mPresenter.savePhoto(photo);
        
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Photo Name", photo.name);
        clipboard.setPrimaryClip(clip);

        String photoUrl = photo.images.get(1).url;

        Picasso.with(getApplicationContext())
                .load(photoUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("image/*");
                        i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap));
                        startActivity(Intent.createChooser(i, "Share Image"));

                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                    }
                });
    }

    public Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_fullphotoscreen;
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        photoView = null;
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            finish();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void prepareFavoryButton(){
        mPresenter.checkIfPhotoIsFavorite(photo);

        favoryIcon.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                mPresenter.setAsFavorite(buttonState, photo);
            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
    }

    @Override
    public void setAsFavorite(boolean isFavoried) {
        favoryIcon.setChecked(isFavoried);
    }

    @OnClick(R.id.iv_full_leftarrow)
    public void onBackArrowClicked(View v){
        finish();
    }
}
