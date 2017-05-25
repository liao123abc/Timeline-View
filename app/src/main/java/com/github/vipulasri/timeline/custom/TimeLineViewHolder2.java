package com.github.vipulasri.timeline.custom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.vipulasri.timeline.R;
import com.github.vipulasri.timelineview.TimelineView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineViewHolder2 extends RecyclerView.ViewHolder {

    @BindView(R.id.text_timeline_title)
    TextView title;
    @BindView(R.id.text_timeline_opinion)
    TextView opinion;
    @BindView(R.id.text_timeline_who)
    TextView who;
    @BindView((R.id.text_timeline_time))
    TextView time;
    @BindView((R.id.text_timeline_reason))
    TextView reason;

    @BindView(R.id.time_marker)
    TimelineView mTimelineView;

    public TimeLineViewHolder2(View itemView, int viewType) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mTimelineView.initLine(viewType);
    }
}
