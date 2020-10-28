package com.java.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MemoActivity extends /*AppCompatActivity*/ SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new MemoFragment();
    }
    /**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();//获取fragment manager
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//获取fragment
        if (fragment == null){
            fragment = new MemoFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();//创建并提交事务
        }
    }
    */
}