package ru.uj.beatbox;

import android.support.v4.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
