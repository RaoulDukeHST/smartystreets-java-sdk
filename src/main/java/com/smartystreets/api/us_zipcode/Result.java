package com.smartystreets.api.us_zipcode;

import com.google.api.client.util.Key;

public class Result {
    //region [ Fields ]

    @Key("status")
    String status;

    @Key("reason")
    String reason;

    @Key("input_index")
    private int inputIndex;

    @Key("input_id") // TODO: remove
    private String inputId;

    @Key("city_states")
    private CityState[] cityStates;

    @Key("zipcodes")
    private ZipCode[] zipcodes;

    //endregion

    public Result() {
    }

    public boolean isValid() {
        return (this.status == null && this.reason == null);
    }

    public CityState getCityState(int index) {
        return this.cityStates[index];
    }

    public ZipCode getZipCode(int index) {
        return this.zipcodes[index];
    }

    //region [ Getters ]

    public String getStatus() {
        return this.status;
    }

    public String getReason() {
        return this.reason;
    }

    public int getInputIndex() {
        return this.inputIndex;
    }

    public String getInputId() {
        return this.inputId;
    } // TODO: remove

    public CityState[] getCityStates() {
        return this.cityStates;
    }

    public ZipCode[] getZipcodes() {
        return this.zipcodes;
    }

    //endregion
}
