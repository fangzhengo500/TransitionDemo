package com.loosu.transitiondemo.adapter;

import android.support.transition.AutoTransition;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeClipBounds;
import android.support.transition.ChangeImageTransform;
import android.support.transition.ChangeScroll;
import android.support.transition.ChangeTransform;
import android.support.transition.Explode;
import android.support.transition.Fade;
import android.support.transition.Slide;
import android.support.transition.Transition;
import android.support.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loosu.transitiondemo.R;

public class TransitionModeAdapter extends BaseAdapter {
    private Transition[] transitions = new Transition[]{
            new ChangeTransform(),
            new ChangeImageTransform(),
            new ChangeScroll(),
            new ChangeBounds(),
            new ChangeClipBounds(),
            new TransitionSet(),
            new AutoTransition(),
            new Fade(),
            new Slide(),
            new Explode(),
    };

    @Override
    public int getCount() {
        return transitions.length;
    }

    @Override
    public Transition getItem(int position) {
        return transitions[position];
    }

    @Override
    public long getItemId(int position) {
        return R.layout.item_transition_mode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_transition_mode, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tvText.setText(getItem(position).getClass().getSimpleName());
        return convertView;
    }

    private static class Holder {
        final View itemView;
        TextView tvText;

        public Holder(View itemView) {
            this.itemView = itemView;
            tvText = itemView.findViewById(R.id.tv_text);
        }
    }
}
