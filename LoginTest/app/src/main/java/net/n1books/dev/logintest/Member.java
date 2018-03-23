package net.n1books.dev.logintest;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by student on 2018-03-21.
 */

public class Member implements Parcelable{

    private String id;
    private String pw;

    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    protected Member(Parcel in) {
        id = in.readString();
        pw = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            String id = in.readString();
            String pw = in.readString();
            return new Member(id,pw);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(pw);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
