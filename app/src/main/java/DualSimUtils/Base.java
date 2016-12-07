package DualSimUtils;

import android.content.Context;

import java.util.HashSet;

public abstract class Base {
    public static final String NULL_DEVICEID = "nothing";
    public static final String MAIN_NULL_DEVICEID = "MainSimnothing";
    public String modul;
    protected static HashSet<String> subscriberIdSet = new HashSet<String>();

    public Base(String model) {
        this.modul = model;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(";");
        sb.append(toStringInternal());
        return sb.toString();
    }

    public abstract String toStringInternal();


    public static abstract class ImplementableBase extends Base {
        private static final String TAG = ImplementableBase.class.getSimpleName();
        protected HashSet<String> tmpscriberIdSet;
        public ImplementableBase(String model) {
            super(model);
        }
        protected abstract void getSubscriberId(HashSet<String> set);
        protected abstract HashSet<String> getTmpMsg();
    }

    public static abstract class ImplementableElementBase extends ImplementableBase {
        private static final String TAG = ImplementableElementBase.class.getSimpleName();
        public ImplementableElementBase(String model) {
            super(model);
        }

    }


    public static abstract class BaseBuilder {
        protected String model;
        protected HashSet<String> buildSet;
//        protected Context context = ;

        private boolean hasValue = false;

        protected boolean hasValue() {
            return hasValue;
        }

        private void setValue() {
            hasValue = true;
        }

        protected final boolean loadSubscriberId(Context context) {
            boolean ret = loadSubscriberIdInternal(context);
            if (ret) {
                setValue();
            }
            return ret;
        }

        protected abstract boolean loadSubscriberIdInternal(Context context);
    }

}