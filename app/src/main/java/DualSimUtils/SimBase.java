package DualSimUtils;

import android.content.Context;

import java.util.Set;

/**
 * Created by hexuan on 17-1-4.
 */

public abstract class SimBase {

    public SimBase() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(";");
        sb.append(toStringInternal());
        return sb.toString();
    }

    protected abstract String toStringInternal();

    public static abstract class ImplementableBase extends SimBase implements IMulitIMSIManager {
        private static final String TAG = ImplementableBase.class.getSimpleName();
        public ImplementableBase() {
            super();
        }

        protected abstract void getAllEntrieIMSI(Set<String> result);

        @Override
        public void getEntireIMSI(Set<String> result) {
            getAllEntrieIMSI(result);
        }
    }

    public static abstract class BaseBuilder {
        protected String model;
        private boolean supported = false;

        protected boolean isSupported() {
            return supported;
        }

        private void setSupported() {
            supported = true;
        }

        public final boolean isSupportedReflect(Context context) {
            boolean ret = isSupportedReflectInternal(context);
            if (ret) {
                setSupported();
            }
            return ret;
        }

        protected abstract boolean isSupportedReflectInternal(Context context);
    }

    protected interface IMulitIMSIManager {
        void getEntireIMSI(Set<String> result);
    }

    protected interface ITelephoneManager {
        String getMainIMSI(Context context);
        String getSecondIMSI(Context context);
    }
}
