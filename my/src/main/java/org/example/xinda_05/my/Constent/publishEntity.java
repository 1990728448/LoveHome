package org.example.xinda_05.my.Constent;

/**
 * Created by Administrator on 2016/8/12.
 */
public class publishEntity {

    private String merchant_name;
    private String detail_info;
    private String business_location;
    private String phone;

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getDetail_info() {
        return detail_info;
    }

    public void setDetail_info(String detail_info) {
        this.detail_info = detail_info;
    }

    public String getBusiness_location() {
        return business_location;
    }

    public void setBusiness_location(String business_location) {
        this.business_location = business_location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "publishEntity{" +
                "merchant_name='" + merchant_name + '\'' +
                ", detail_info='" + detail_info + '\'' +
                ", business_location='" + business_location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
