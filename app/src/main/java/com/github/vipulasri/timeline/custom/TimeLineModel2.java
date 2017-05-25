package com.github.vipulasri.timeline.custom;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.vipulasri.timeline.model.OrderStatus;
import com.github.vipulasri.timeline.model.TimeLineModel;

/**
 * Created by thomasliao on 2017/5/25.
 */

public class TimeLineModel2 implements Parcelable{

    private String title;
    private String opinion;
    private String who;
    private String time;
    private String reason;
    private ApprovalStatus status;

    public TimeLineModel2(String title, String opinion, String who, String time, String reason,
                          ApprovalStatus status) {
        this.title = title;
        this.opinion = opinion;
        this.who = who;
        this.time = time;
        this.reason = reason;
        this.status = status;
    }

    protected TimeLineModel2(Parcel in) {
        this.title = in.readString();
        this.opinion = in.readString();
        this.who = in.readString();
        this.time = in.readString();
        this.reason = in.readString();
        int tmpStatus = in.readInt();
        this.status = tmpStatus == -1 ? null : ApprovalStatus.values()[tmpStatus];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.opinion);
        dest.writeString(this.who);
        dest.writeString(this.time);
        dest.writeString(this.reason);
        dest.writeInt(this.status == null ? -1 : this.status.ordinal());
    }

    public String getTitle() {
        return title;
    }

    public String getOpinion() {
        return opinion;
    }

    public String getWho() {
        return who;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public static final Parcelable.Creator<TimeLineModel2> CREATOR = new Parcelable.Creator<TimeLineModel2>() {
        @Override
        public TimeLineModel2 createFromParcel(Parcel source) {
            return new TimeLineModel2(source);
        }

        @Override
        public TimeLineModel2[] newArray(int size) {
            return new TimeLineModel2[size];
        }
    };
}
