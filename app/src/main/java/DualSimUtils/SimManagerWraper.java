package DualSimUtils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexuan on 17-1-4.
 */

public class SimManagerWraper {
    private final static String TAG = "SimManagerWraper";
    private static volatile SimCardID SIM_CARD_ID;
    private static volatile SimManagerWraper instance;
    private static final HashSet<String> SINGLE_LIST = new HashSet<>();


    static {
        SINGLE_LIST.add("HUAWEI M2-803L");
    }

    private SimManagerWraper(Context context) {
        SIM_CARD_ID = new Builder().init(context).build();
    }

    public static SimManagerWraper getInstance(Context context) {
        if (instance == null) {
            instance = new SimManagerWraper(context);
        }
        return instance;
    }

    public static boolean isSingleCard() {
        boolean ret = false;
        ret = SINGLE_LIST.contains(Build.MODEL) || Build.MODEL.contains("Nexus");
        return ret;
    }

    public final boolean hasSimCard() {
        SimCardIDResult result = new SimCardIDResult(getSimIMSIInternal());
        return result.hasSimCard();
    }

    public final String getMainIMSI() {
        SimCardIDResult result = new SimCardIDResult(getSimIMSIInternal());
        return result.getMainIMSI();
    }

    public final String getSecondIMSI() {
        SimCardIDResult result = new SimCardIDResult(getSimIMSIInternal());
        return result.getSecondMSI();
    }

    public final String getEntireIMSI() {
        SimCardIDResult result = new SimCardIDResult(getSimIMSIInternal());
        return result.getEntireIMSI();
    }

    private String[] getSimIMSIInternal() {
        Set<String> result = new HashSet<>();
        SIM_CARD_ID.getAllEntrieIMSI(result);
        result.remove(null);
        String[] strings = new String[result.size()];
        result.toArray(strings);
        Arrays.sort(strings);
        Log.d(TAG, "getSimIMSIInternal() " + Arrays.toString(strings));
        return strings;
    }

    public static class SimCardIDResult {
        private String mainIMSI = "nothing";
        private String secondMSI = "nothing";

        public SimCardIDResult(String[] result) {
            if (null == result) {
                mainIMSI = "nothing";
                secondMSI = "nothing";
            } else if (result.length == 0) {
                mainIMSI = "nothing";
                secondMSI = "nothing";
            } else if (result.length == 1) {
                mainIMSI = result[0];
                secondMSI = "nothing";

            } else if (result.length == 2) {
                mainIMSI = result[0];
                secondMSI = result[1];
            } else {
                Log.e(TAG, "SIM_ERROR");
            }
        }

        public String getEntireIMSI() {
            return new StringBuilder(getMainIMSI()).append("|").append(getSecondMSI()).toString();
        }

        public final boolean hasSimCard() {
            return !"nothing".equals(mainIMSI);
        }

        public String getMainIMSI() {
            return mainIMSI;
        }
        public String getSecondMSI() {
            return isSingleCard() ? "" : secondMSI;
        }
    }

    public static class Builder extends SimBase.BaseBuilder {
        private SimCardID.Builder builder = new SimCardID.Builder();

        public Builder init(Context context) {
            isSupportedReflect(context);
            return this;
        }

        @Override
        protected boolean isSupportedReflectInternal(Context context) {
            return builder.isSupportedReflect(context);
        }

        public SimCardID build() {
            return isSupported() ? builder.build() : null;
        }
    }
}
