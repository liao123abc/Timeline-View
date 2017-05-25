package com.github.vipulasri.timeline.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timeline.R;
import com.github.vipulasri.timeline.model.Orientation;
import com.github.vipulasri.timelineview.LineType;

import java.util.List;

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineAdapter2 extends RecyclerView.Adapter<TimeLineViewHolder2> {

    private List<TimeLineModel2> mFeedList;
    private Context mContext;
    private Orientation mOrientation;
    private boolean mWithLinePadding;
    private LayoutInflater mLayoutInflater;

    public TimeLineAdapter2(List<TimeLineModel2> feedList, Orientation orientation, boolean withLinePadding) {
        mFeedList = feedList;
        mOrientation = orientation;
        mWithLinePadding = withLinePadding;
    }

    @Override
    public int getItemViewType(int position) {
        return LineType.NORMAL;
    }

    @Override
    public TimeLineViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.item_timeline2, parent, false);

        return new TimeLineViewHolder2(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder2 holder, int position) {

        TimeLineModel2 timeLineModel = mFeedList.get(position);

        holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker),
                    ContextCompat.getColor(mContext, R.color.white));

        if(!timeLineModel.getReason().isEmpty()) {
            holder.reason.setVisibility(View.VISIBLE);
            holder.reason.setText(timeLineModel.getReason());
        } else {
            holder.reason.setVisibility(View.GONE);
        }

//        holder.time.setText(DateTimeUtils.parseDateTime(timeLineModel.getTime(), "yyyy-MM-dd HH:mm", "hh:mm a, dd-MMM-yyyy"));
        holder.time.setText(timeLineModel.getTime());
        holder.who.setText(timeLineModel.getWho());
        ApprovalStatus status = timeLineModel.getStatus();

        if (status == ApprovalStatus.AGREE) {
            holder.opinion.setTextColor(Color.GREEN);
        } else if (status == ApprovalStatus.DISAGREE) {
            holder.opinion.setTextColor(Color.RED);
        } else {
            holder.opinion.setTextColor(Color.GRAY);
        }

        String title = timeLineModel.getTitle();
        String opinion = timeLineModel.getOpinion();
        SpannableString spanString1 = new SpannableString(title);
        SpannableString spanString2 = new SpannableString(opinion);
        spanString1.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString1.length(), 0);
        spanString2.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString2.length(), 0);

        holder.opinion.setText(spanString2);
        holder.title.setText(spanString1);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

}
