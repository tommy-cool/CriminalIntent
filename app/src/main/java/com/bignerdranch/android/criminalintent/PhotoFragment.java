package com.bignerdranch.android.criminalintent;


import android.support.v4.app.DialogFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PhotoFragment extends DialogFragment{

    private static final String EXTRA_PHOTO = "com.bignerdranch.android.criminalintent.photo";

    public static PhotoFragment newInstance(String photo) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PHOTO, photo);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ImageView mPhotoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mPhotoView = new ImageView(getActivity());
        String photo = (String) getArguments().getSerializable(EXTRA_PHOTO);
        Bitmap bitmap = PictureUtils.getScaledBitmap(photo, getActivity());

        mPhotoView.setImageBitmap(bitmap);

        return mPhotoView;
    }


}
