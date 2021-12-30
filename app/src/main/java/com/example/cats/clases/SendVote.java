package com.example.cats.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendVote {

        @SerializedName("image_id")
        @Expose
        private String imageId;

        public SendVote(String imageId, String subId, int value) {
            this.imageId = imageId;
            this.subId = subId;
            this.value = value;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public String getSubId() {
            return subId;
        }

        public void setSubId(String subId) {
            this.subId = subId;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @SerializedName("sub_id")
        @Expose
        private String subId;
        @SerializedName("value")
        @Expose
        private int value;

}
