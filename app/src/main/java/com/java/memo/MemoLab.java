package com.java.memo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoLab {
    private static MemoLab sMemoLab;
    private List<Memo> mMemos;
    public MemoLab(Context context) {
        mMemos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Memo memo = new Memo();
            memo.setTitle("Crime #"+ i);
            memo.setSolved(i%2 ==0);
            mMemos.add(memo);
        }
    }
    public List<Memo> getMemos(){
        return mMemos;
    }
    public Memo getMemo(UUID id){
        for (Memo memo : mMemos){
            if (memo.getId().equals(id)){
                return memo;
            }
        }
        return null;
    }
    public static MemoLab get(Context context) {
        if (sMemoLab == null){
            sMemoLab = new MemoLab(context);
        }
        return sMemoLab;
    }
}
