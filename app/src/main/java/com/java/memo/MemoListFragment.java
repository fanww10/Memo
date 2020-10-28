package com.java.memo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MemoListFragment extends Fragment {
    private RecyclerView mMemoRecyclerView;
    private MemoAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_memo_list, container, false);
        mMemoRecyclerView = view.findViewById(R.id.memo_recycler_view);
        mMemoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        MemoLab memoLab = MemoLab.get(getActivity());
        List<Memo> memos = memoLab.getMemos();

        mAdapter = new MemoAdapter(memos);
        mMemoRecyclerView.setAdapter(mAdapter);

    }

    private class MemoHoder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Memo mMemo;
        private TextView mTitleTextView;
        private TextView mDataTextView;

        public MemoHoder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_memo, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = itemView.findViewById(R.id.memo_title);
            mDataTextView = itemView.findViewById(R.id.memo_date);
        }//实例化list_item_memo,后传给super()方法，

        public void bind(Memo memo){
            mMemo = memo;
            mTitleTextView.setText(mMemo.getTitle());
            mDataTextView.setText(mMemo.getDate().toString());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), mMemo.getTitle()+"clicked", Toast.LENGTH_SHORT).show();
        }
    }


    private class MemoAdapter extends RecyclerView.Adapter<MemoHoder>{
        private List<Memo> mMemos;
        public MemoAdapter(List<Memo> memos){
            mMemos = memos;
        }


        @Override
        public MemoHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MemoHoder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MemoHoder holder, int position) {
            Memo memo = mMemos.get(position);
            holder.bind(memo);
        }

        @Override
        public int getItemCount() {
            return mMemos.size();
        }
    }


}
