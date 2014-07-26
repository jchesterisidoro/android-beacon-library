package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by dyoung on 7/21/14.
 */
public class AltBeacon extends Beacon {
    private static final String TAG = "AltBeacon";

    protected AltBeacon() {
    }

    /**
     * Returns a field with a value from 0-255 that can be used for the purposes specified by the
     * manufacturer.  The manufacturer specifications for the beacon should be checked before using
     * this field, and the manufacturer should be checked against the Beacon#mManufacturerCode
     * field
     * @return mfgReserved
     */
    public int getMfgReserved() {
        return mDataFields.get(0).intValue();
    }

    /**
     * Required for making object Parcelable.  If you override this class, you must provide an
     * equivalent version of this method.
     */
    public static final Parcelable.Creator<AltBeacon> CREATOR
            = new Parcelable.Creator<AltBeacon>() {
        public AltBeacon createFromParcel(Parcel in) {
            return new AltBeacon(in);
        }

        public AltBeacon[] newArray(int size) {
            return new AltBeacon[size];
        }
    };

    /**
     * Required for making object Parcelable
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Required for making object Parcelable
     **/
     @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
    }

    /**
     * Required for making object Parcelable
     **/
    protected AltBeacon(Parcel in) {
        super(in);
    }

    protected AltBeacon(Beacon beacon) {
        super();
        this.mBluetoothAddress = beacon.mBluetoothAddress;
        this.mIdentifiers = beacon.mIdentifiers;
        this.mBeaconTypeCode = beacon.mBeaconTypeCode;
        this.mDataFields = beacon.mDataFields;
        this.mDistance = beacon.mDistance;
        this.mRssi = beacon.mRssi;
        this.mTxPower = beacon.mTxPower;
    }

    /**
     * Builder class for AltBeacon objects. Provides a convenient way to set the various fields of a
     * Beacon
     *
     * <p>Example:
     *
     * <pre>
     * Beacon beacon = new Beacon.Builder()
     *         .setId1(&quot;2F234454-CF6D-4A0F-ADF2-F4911BA9FFA6&quot;)
     *         .setId2("1")
     *         .setId3("2")
     *         .setMfgReserved(3);
     *         .build();
     * </pre>
     */
    public static class Builder extends Beacon.Builder {
        @Override
        public Beacon build() {
            return new AltBeacon(super.build());
        }
        public Builder setMfgReserved(int mfgReserved) {
            if (mBeacon.mDataFields.size() != 0) {
                mBeacon.mDataFields = new ArrayList<Long>();
            }
            mBeacon.mDataFields.add((long)mfgReserved);
            return this;
        }
    }

}
