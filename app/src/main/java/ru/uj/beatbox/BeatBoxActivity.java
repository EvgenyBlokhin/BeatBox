package ru.uj.beatbox;

import android.support.v4.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {

//    private SeekBar mSeekBar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mSeekBar = findViewById(R.id.seek_bar);
//        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                ((BeatBoxFragment)fragmentManager.getFragments().get(0)).setRate(i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//    }

    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
