package com.java.memo;

import androidx.fragment.app.Fragment;

public class MemoListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new MemoListFragment();
    }
}
